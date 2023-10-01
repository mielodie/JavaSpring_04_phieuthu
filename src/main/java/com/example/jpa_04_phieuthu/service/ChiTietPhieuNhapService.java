package com.example.jpa_04_phieuthu.service;

import com.example.jpa_04_phieuthu.entity.ChiTietPhieuNhap;
import com.example.jpa_04_phieuthu.entity.ChiTietPhieuThu;
import com.example.jpa_04_phieuthu.payload.converter.ChiTietPhieuNhapConverter;
import com.example.jpa_04_phieuthu.payload.converter.ChiTietPhieuThuConverter;
import com.example.jpa_04_phieuthu.payload.dto.ChiTietPhieuNhapDTO;
import com.example.jpa_04_phieuthu.payload.dto.ChiTietPhieuThuDTO;
import com.example.jpa_04_phieuthu.payload.request.chitietphieunhap.ChiTietPhieuNhapRequest;
import com.example.jpa_04_phieuthu.payload.response.ResponseObject;
import com.example.jpa_04_phieuthu.repository.*;
import com.example.jpa_04_phieuthu.service.interfaceservice.iChiTietPhieuNhapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChiTietPhieuNhapService implements iChiTietPhieuNhapService {
    @Autowired
    private ChiTietPhieuNhapRepository _chiTietPhieuNhapRepository;
    @Autowired
    private PhieuNhapRepository _phieuNhapRepository;
    @Autowired
    private NguyenLieuRepository _nguyenLieuRepository;
    @Autowired
    public ChiTietPhieuNhapConverter _converter;
    @Autowired
    public ResponseObject<ChiTietPhieuNhapDTO> _chiTietPhieuNhapDTOResponseObject;

    //    public List<ChiTietPhieuNhap> themChiTietPhieuNhap(int phieuNhapId) {
//        var phieuNhap = _phieuNhapRepository.findById(phieuNhapId);
//        if (phieuNhap.isEmpty()) {
//            return null;
//        } else {
//            List<ChiTietPhieuNhap> list = new ArrayList<>();
//            for (int i = 0; i < list.size(); i++) {
//                ChiTietPhieuNhap ct = new ChiTietPhieuNhap();
//                var nguyenLieu = _nguyenLieuRepository.findById(ct.getNguyenLieuId());
//                if (nguyenLieu.isEmpty()) {
//                    return null;
//                } else {
//                    ct.setPhieuNhapId(phieuNhapId);
//                    list.add(ct);
//                    phieuNhap.get().setTongTien(ct.getSoLuongNhap() * nguyenLieu.get().getGiaNhap());
//                    nguyenLieu.get().setSoLuongKho(nguyenLieu.get().getSoLuongKho() + ct.getSoLuongNhap());
//                    _nguyenLieuRepository.save(nguyenLieu.get());
//                }
//            }
//            _chiTietPhieuNhapRepository.saveAll(list);
//            _phieuNhapRepository.save(phieuNhap.get());
//            return list;
//        }
//    }
    public List<ChiTietPhieuNhap> themChiTietPhieuNhap(int phieuNhapId, List<ChiTietPhieuNhapRequest> requests) {
        var phieuNhap = _phieuNhapRepository.findById(phieuNhapId);
        if (phieuNhap.isEmpty()) {
            return null;
        } else {
            List<ChiTietPhieuNhap> list = new ArrayList<>();
            for (var x: requests) {
                var nguyenLieu = _nguyenLieuRepository.findById(x.getNguyenLieuId());
                if (nguyenLieu.isEmpty()) {
                    throw new IllegalArgumentException("Nguyen lieu khong ton tai");
                } else {
                    var ct = new ChiTietPhieuNhap();
                    ct.setPhieuNhapId(phieuNhapId);
                    ct.setSoLuongNhap(x.getSoLuongNhap());
                    ct.setNguyenLieuId(x.getNguyenLieuId());
                    list.add(ct);
                    _chiTietPhieuNhapRepository.save(ct);
                }
            }
            return list;
        }
    }

    public ResponseObject<ChiTietPhieuNhapDTO> suaChiTietPhieuNhap(int chiTietPhieuNhapId, ChiTietPhieuNhapRequest request) {
        var chiTiet = _chiTietPhieuNhapRepository.findById(chiTietPhieuNhapId);
        if (chiTiet.isEmpty()) {
            return _chiTietPhieuNhapDTOResponseObject.responseError(HttpURLConnection.HTTP_NOT_FOUND, "Khong tim thay chi tiet phieu nhap", null);
        } else {
            var chiTietSua = _converter.suaChiTietPhieuNhap(chiTiet.get(), request);
            _chiTietPhieuNhapRepository.save(chiTietSua);
            return _chiTietPhieuNhapDTOResponseObject.responseSuccess("Sua chi tiet phieu nhap thanh cong", _converter.entityToDTO(chiTietSua));
        }
    }

    public ResponseObject<ChiTietPhieuNhapDTO> xoaChiTietPhieuNhap(int chiTietPhieuNhapId) {
        var chiTiet = _chiTietPhieuNhapRepository.findById(chiTietPhieuNhapId);
        if (chiTiet.isEmpty()) {
            return _chiTietPhieuNhapDTOResponseObject.responseError(HttpURLConnection.HTTP_NOT_FOUND, "Khong tim thay chi tiet phieu nhap", null);
        } else {
            _chiTietPhieuNhapRepository.delete(chiTiet.get());
            return _chiTietPhieuNhapDTOResponseObject.responseSuccess("Sua chi tiet phieu nhap thanh cong", _converter.entityToDTO(chiTiet.get()));
        }
    }

    public List<ChiTietPhieuNhapDTO> layChiTietTheoPhieuNhap(int phieuNhapId, int pageSize, int pageNumber) {
        return _chiTietPhieuNhapRepository.findAll()
                .stream()
                .filter(x -> x.getPhieuNhapId() == phieuNhapId)
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize)
                .map(x -> _converter.entityToDTO(x))
                .collect(Collectors.toList());
    }

    public List<ChiTietPhieuNhapDTO> layChiTietTheoNguyenLieu(int nguyenLieuId, int pageSize, int pageNumber) {
        return _chiTietPhieuNhapRepository.findAll()
                .stream()
                .filter(x -> x.getNguyenLieuId() == nguyenLieuId)
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize)
                .map(x -> _converter.entityToDTO(x))
                .collect(Collectors.toList());
    }
}
