package com.example.jpa_04_phieuthu.service;

import com.example.jpa_04_phieuthu.entity.ChiTietPhieuThu;
import com.example.jpa_04_phieuthu.payload.converter.ChiTietPhieuThuConverter;
import com.example.jpa_04_phieuthu.payload.dto.ChiTietPhieuThuDTO;
import com.example.jpa_04_phieuthu.payload.request.chitietphieuthu.ChiTietPhieuThuRequest;
import com.example.jpa_04_phieuthu.payload.response.ResponseObject;
import com.example.jpa_04_phieuthu.repository.ChiTietPhieuThuRepository;
import com.example.jpa_04_phieuthu.repository.NguyenLieuRepository;
import com.example.jpa_04_phieuthu.repository.PhieuThuRepository;
import com.example.jpa_04_phieuthu.service.interfaceservice.iChiTietPhieuThuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChiTietPhieuThuService implements iChiTietPhieuThuService {
    @Autowired
    private ChiTietPhieuThuRepository _chiTietPhieuThuRepository;
    @Autowired
    private PhieuThuRepository _phieuThuRepository;
    @Autowired
    private NguyenLieuRepository _nguyenLieuRepository;
    @Autowired
    public ChiTietPhieuThuConverter _converter;
    @Autowired
    public ResponseObject<ChiTietPhieuThuDTO> _chiTietPhieuThuDTOResponseObject;

    public List<ChiTietPhieuThu> themChiTietPhieuThu(int phieuThuId, List<ChiTietPhieuThuRequest> requests) {
        var phieuThu = _phieuThuRepository.findById(phieuThuId);
        if (phieuThu.isEmpty()) {
            return null;
        } else {
            List<ChiTietPhieuThu> list = new ArrayList<>();
            requests.forEach(x ->{
                var nguyenLieu = _nguyenLieuRepository.findById(x.getNguyenLieuId());
                if(nguyenLieu.isEmpty()){
                    throw new IllegalArgumentException("Nguyen lieu khong ton tai");
                }
                else{
                    var ct = _converter.themChiTietPhieuThu(x);
                    ct.setPhieuThuId(phieuThuId);
                    list.add(ct);
                    _chiTietPhieuThuRepository.save(ct);
                }
            });
            return list;
        }
    }

    public ResponseObject<ChiTietPhieuThuDTO> suaChiTietPhieuThu(int chiTietPhieuThuId, ChiTietPhieuThuRequest request) {
        var chiTiet = _chiTietPhieuThuRepository.findById(chiTietPhieuThuId);
        if (chiTiet.isEmpty()) {
            return _chiTietPhieuThuDTOResponseObject.responseError(HttpURLConnection.HTTP_NOT_FOUND, "Khong tim thay chi tiet phieu thu", null);
        } else {
            var chiTietSua = _converter.suaChiTietPhieuThu(chiTiet.get(), request);
            _chiTietPhieuThuRepository.save(chiTietSua);
            return _chiTietPhieuThuDTOResponseObject.responseSuccess("Sua chi tiet phieu thu thanh cong", _converter.entityToDTO(chiTietSua));
        }
    }

    public ResponseObject<ChiTietPhieuThuDTO> xoaChiTietPhieuThu(int chiTietPhieuThuId) {
        var chiTiet = _chiTietPhieuThuRepository.findById(chiTietPhieuThuId);
        if (chiTiet.isEmpty()) {
            return _chiTietPhieuThuDTOResponseObject.responseError(HttpURLConnection.HTTP_NOT_FOUND, "Khong tim thay chi tiet phieu thu", null);
        } else {
            _chiTietPhieuThuRepository.delete(chiTiet.get());
            return _chiTietPhieuThuDTOResponseObject.responseSuccess("Sua chi tiet phieu thu thanh cong", _converter.entityToDTO(chiTiet.get()));
        }
    }

    public List<ChiTietPhieuThuDTO> layChiTietTheoPhieuThu(int phieuThuId, int pageSize, int pageNumber) {
        return _chiTietPhieuThuRepository.findAll()
                .stream()
                .filter(x -> x.getPhieuThuId() == phieuThuId)
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize)
                .map(x -> _converter.entityToDTO(x))
                .collect(Collectors.toList());
    }

    public List<ChiTietPhieuThuDTO> layChiTietTheoNguyenLieu(int nguyenLieuId, int pageSize, int pageNumber) {
        return _chiTietPhieuThuRepository.findAll()
                .stream()
                .filter(x -> x.getNguyenLieuId() == nguyenLieuId)
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize)
                .map(x -> _converter.entityToDTO(x))
                .collect(Collectors.toList());
    }
}
