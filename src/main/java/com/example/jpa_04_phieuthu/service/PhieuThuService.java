package com.example.jpa_04_phieuthu.service;

import com.example.jpa_04_phieuthu.entity.ChiTietPhieuThu;
import com.example.jpa_04_phieuthu.payload.converter.PhieuThuConverter;
import com.example.jpa_04_phieuthu.payload.dto.PhieuThuDTO;
import com.example.jpa_04_phieuthu.payload.request.phieuthu.PhieuThuRequest;
import com.example.jpa_04_phieuthu.payload.response.ResponseObject;
import com.example.jpa_04_phieuthu.repository.ChiTietPhieuThuRepository;
import com.example.jpa_04_phieuthu.repository.NguyenLieuRepository;
import com.example.jpa_04_phieuthu.repository.NhanVienRepository;
import com.example.jpa_04_phieuthu.repository.PhieuThuRepository;
import com.example.jpa_04_phieuthu.service.interfaceservice.iPhieuThuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhieuThuService implements iPhieuThuService {
    @Autowired
    private PhieuThuRepository _phieuThuRepository;
    @Autowired
    private ChiTietPhieuThuRepository _chiTietPhieuThuRepository;
    @Autowired
    NguyenLieuRepository _nguyenLieuRepository;
    @Autowired
    private NhanVienRepository _nhanVienRepository;
    @Autowired
    public ChiTietPhieuThuService _chiTietPhieuThuService;
    @Autowired
    public PhieuThuConverter _converter;
    @Autowired
    public ResponseObject<PhieuThuDTO> _phieuThuDTOResponseObject;

    public ResponseObject<PhieuThuDTO> themPhieuThu(PhieuThuRequest request) {
        var checkNhanVien = _nhanVienRepository.findById(request.getNhanVienId());
        if (checkNhanVien.isEmpty()) {
            return _phieuThuDTOResponseObject.responseError(HttpURLConnection.HTTP_NOT_FOUND, "Chua co nhan vien", null);
        } else {
            var phieuThu = _converter.themPhieuThu(request);
            _phieuThuRepository.save(phieuThu);

            List<ChiTietPhieuThu> list = _chiTietPhieuThuService.themChiTietPhieuThu(phieuThu.getPhieuThuId(), request.getChiTietPhieuThuRequestList());
            phieuThu.setChiTietPhieuThus(list);
            phieuThu.setTongTien(0);
            phieuThu.getChiTietPhieuThus().forEach(x -> {
                var nguyenLieu = _nguyenLieuRepository.findById(x.getNguyenLieuId());
                phieuThu.setTongTien(phieuThu.getTongTien() + (x.getSoLuongBan() * nguyenLieu.get().getGiaBan()));
                nguyenLieu.get().setSoLuongKho(nguyenLieu.get().getSoLuongKho() - x.getSoLuongBan());
                _nguyenLieuRepository.save(nguyenLieu.get());
            });
            _phieuThuRepository.save(phieuThu);
            return _phieuThuDTOResponseObject.responseSuccess("Them phieu thu thanh cong", _converter.entityToDTO(phieuThu));
        }
    }

    public ResponseObject<PhieuThuDTO> suaPhieuThu(int phieuThuId, PhieuThuRequest request) {
        var checkPhieuThu = _phieuThuRepository.findById(phieuThuId);
        if (checkPhieuThu.isEmpty()) {
            return _phieuThuDTOResponseObject.responseError(HttpURLConnection.HTTP_NOT_FOUND, "Phieu thu khong ton tai", null);
        } else {
            var phieuThu = _converter.suaPhieuThu(checkPhieuThu.get(), request);
            var checkNhanVien = _nhanVienRepository.findAll()
                    .stream().filter(x -> x.getNhanVienId() == phieuThu.getNhanVienId())
                    .findFirst()
                    .orElse(null);
            if (checkPhieuThu.isEmpty()) {
                return _phieuThuDTOResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Nhan vien khong trung khop", null);
            } else {
                _phieuThuRepository.save(phieuThu);
                return _phieuThuDTOResponseObject.responseSuccess("Sua phieu thu thanh cong", _converter.entityToDTO(phieuThu));
            }
        }
    }

    public ResponseObject<PhieuThuDTO> xoaPhieuThu(int phieuThuId) {
        var checkPhieuThu = _phieuThuRepository.findById(phieuThuId);
        if (checkPhieuThu.isEmpty()) {
            return _phieuThuDTOResponseObject.responseError(HttpURLConnection.HTTP_NOT_FOUND, "Phieu thu khong ton tai", null);
        } else {
            _phieuThuRepository.delete(checkPhieuThu.get());
            return _phieuThuDTOResponseObject.responseSuccess("Xoa phieu thu thanh cong", _converter.entityToDTO(checkPhieuThu.get()));
        }
    }

    public List<PhieuThuDTO> layTatCaPhieuThu(int pageSize, int pageNumber) {
        return _phieuThuRepository.findAll()
                .stream()
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize)
                .map(x -> _converter.entityToDTO(x))
                .collect(Collectors.toList());
    }

    public List<PhieuThuDTO> layPhieuThuTheoNgayTao(LocalDate date, int pageSize, int pageNumber) {
        return _phieuThuRepository.findAll()
                .stream()
                .filter(x -> x.getNgayLap() == date)
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize)
                .map(x -> _converter.entityToDTO(x))
                .collect(Collectors.toList());
    }
}
