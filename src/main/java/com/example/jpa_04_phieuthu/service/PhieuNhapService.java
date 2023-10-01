package com.example.jpa_04_phieuthu.service;

import com.example.jpa_04_phieuthu.entity.ChiTietPhieuNhap;
import com.example.jpa_04_phieuthu.payload.converter.PhieuNhapConverter;
import com.example.jpa_04_phieuthu.payload.converter.PhieuThuConverter;
import com.example.jpa_04_phieuthu.payload.dto.PhieuNhapDTO;
import com.example.jpa_04_phieuthu.payload.dto.PhieuThuDTO;
import com.example.jpa_04_phieuthu.payload.request.phieunhap.PhieuNhapRequest;
import com.example.jpa_04_phieuthu.payload.response.ResponseObject;
import com.example.jpa_04_phieuthu.repository.NguyenLieuRepository;
import com.example.jpa_04_phieuthu.repository.NhanVienRepository;
import com.example.jpa_04_phieuthu.repository.PhieuNhapRepository;
import com.example.jpa_04_phieuthu.repository.PhieuThuRepository;
import com.example.jpa_04_phieuthu.service.interfaceservice.iPhieuNhapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhieuNhapService implements iPhieuNhapService {
    @Autowired
    private PhieuNhapRepository _phieuNhapRepository;
    @Autowired
    private NhanVienRepository _nhanVienRepository;
    @Autowired
    private NguyenLieuRepository _nguyenLieuRepository;
    @Autowired
    public PhieuNhapConverter _converter;
    @Autowired
    public ResponseObject<PhieuNhapDTO> _phieuNhapDTOResponseObject;
    @Autowired
    public ChiTietPhieuNhapService _chiTietPhieuNhapService;
    public ResponseObject<PhieuNhapDTO> themPhieuNhap(PhieuNhapRequest request) {
        var checkNhanVien = _nhanVienRepository.findById(request.getNhanVienId());
        if (checkNhanVien.isEmpty()) {
            return _phieuNhapDTOResponseObject.responseError(HttpURLConnection.HTTP_NOT_FOUND, "Chua co nhan vien", null);
        }
        else {
            var phieuNhap = _converter.themPhieuNhap(request);
            _phieuNhapRepository.save(phieuNhap);
            List<ChiTietPhieuNhap> list = _chiTietPhieuNhapService.themChiTietPhieuNhap(phieuNhap.getPhieuNhapId(), request.getChiTietPhieuNhapRequestList());
            phieuNhap.setChiTietPhieuNhaps(list);
            phieuNhap.setTongTien(0);
            phieuNhap.getChiTietPhieuNhaps().forEach(x -> {
                var nguyenLieu = _nguyenLieuRepository.findById(x.getNguyenLieuId());
                phieuNhap.setTongTien(phieuNhap.getTongTien() + (x.getSoLuongNhap() *  nguyenLieu.get().getGiaNhap()));
                nguyenLieu.get().setSoLuongKho(nguyenLieu.get().getSoLuongKho() + x.getSoLuongNhap());
                _nguyenLieuRepository.save(nguyenLieu.get());
            });
            _phieuNhapRepository.save(phieuNhap);
            return _phieuNhapDTOResponseObject.responseSuccess("Them phieu nhap thanh cong", _converter.entityToDTO(phieuNhap));
        }
    }


    public ResponseObject<PhieuNhapDTO> suaPhieuNhap(int phieuNhapId, PhieuNhapRequest request) {
        var checkPhieuNhap = _phieuNhapRepository.findById(phieuNhapId);
        if (checkPhieuNhap.isEmpty()) {
            return _phieuNhapDTOResponseObject.responseError(HttpURLConnection.HTTP_NOT_FOUND, "Phieu nhap khong ton tai", null);
        }
        else {
            var phieuNhap = _converter.suaPhieuNhap(checkPhieuNhap.get(), request);
            var checkNhanVien = _nhanVienRepository.findAll()
                    .stream().filter(x -> x.getNhanVienId() == phieuNhap.getNhanVienId())
                    .findFirst()
                    .orElse(null);
            if (checkPhieuNhap.isEmpty()) {
                return _phieuNhapDTOResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Nhan vien khong trung khop", null);
            }
            else {
                _phieuNhapRepository.save(phieuNhap);
                return _phieuNhapDTOResponseObject.responseSuccess("Sua phieu nhap thanh cong", _converter.entityToDTO(phieuNhap));
            }
        }
    }

    public ResponseObject<PhieuNhapDTO> xoaPhieuNhap(int phieuNhapId) {
        var checkPhieuNhap = _phieuNhapRepository.findById(phieuNhapId);
        if (checkPhieuNhap.isEmpty()) {
            return _phieuNhapDTOResponseObject.responseError(HttpURLConnection.HTTP_NOT_FOUND, "Phieu nhap khong ton tai", null);
        }
        else {
            _phieuNhapRepository.delete(checkPhieuNhap.get());
            return _phieuNhapDTOResponseObject.responseSuccess("Xoa phieu nhap thanh cong", _converter.entityToDTO(checkPhieuNhap.get()));
        }
    }

    public List<PhieuNhapDTO> layTatCaPhieuNhap(int pageSize, int pageNumber) {
        return _phieuNhapRepository.findAll()
                .stream()
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize)
                .map(x -> _converter.entityToDTO(x))
                .collect(Collectors.toList());
    }

    public List<PhieuNhapDTO> layPhieuNhapTheoNgayTao(LocalDate date, int pageSize, int pageNumber) {
        return _phieuNhapRepository.findAll()
                .stream()
                .filter(x -> x.getNgayLap() == date)
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize)
                .map(x -> _converter.entityToDTO(x))
                .collect(Collectors.toList());
    }
}
