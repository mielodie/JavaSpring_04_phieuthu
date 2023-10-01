package com.example.jpa_04_phieuthu.service;

import com.example.jpa_04_phieuthu.entity.NguyenLieu;
import com.example.jpa_04_phieuthu.payload.converter.NguyenLieuConverter;
import com.example.jpa_04_phieuthu.payload.dto.NguyenLieuDTO;
import com.example.jpa_04_phieuthu.payload.request.nguyenlieu.NguyenLieuRequest;
import com.example.jpa_04_phieuthu.payload.response.ResponseObject;
import com.example.jpa_04_phieuthu.repository.LoaiNguyenLieuRepository;
import com.example.jpa_04_phieuthu.repository.NguyenLieuRepository;
import com.example.jpa_04_phieuthu.service.interfaceservice.iNguyenLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NguyenLieuService implements iNguyenLieuService {
    @Autowired
    private NguyenLieuRepository _nguyenLieuRepository;
    @Autowired
    private LoaiNguyenLieuRepository _loaiNguyenLieuRepository;
    @Autowired
    public NguyenLieuConverter _converter;
    @Autowired
    public ResponseObject<NguyenLieuDTO> _nguyenLieuDTOResponseObject;

    public ResponseObject<NguyenLieuDTO> themNguyenLieu(int loaiNguyenLieuId, NguyenLieuRequest request) {
        var checkLoaiNguyenLieu = _loaiNguyenLieuRepository.findById(loaiNguyenLieuId);
        if (checkLoaiNguyenLieu.isEmpty()) {
            return _nguyenLieuDTOResponseObject.responseError(HttpURLConnection.HTTP_NOT_FOUND, "Loai nguyen lieu khong ton tai", null);
        } else {
            var nguyenLieu = new NguyenLieu();
            nguyenLieu.setLoaiNguyenLieuId(loaiNguyenLieuId);
            nguyenLieu = _converter.themNguyenLieu(request);
            _nguyenLieuRepository.save(nguyenLieu);
            return _nguyenLieuDTOResponseObject.responseSuccess("Them nguyen lieu thanh cong", _converter.entityToDTO(nguyenLieu));
        }
    }

    public ResponseObject<NguyenLieuDTO> suaNguyenLieu(int nguyenLieuId, NguyenLieuRequest request) {
        var nguyenLieu = _nguyenLieuRepository.findById(nguyenLieuId);
        if (nguyenLieu.isEmpty()) {
            return _nguyenLieuDTOResponseObject.responseError(HttpURLConnection.HTTP_NOT_FOUND, "Khong tim thay nguyen lieu", null);
        } else {
            var nguyenLieuSua = _converter.suaNguyenLieu(nguyenLieu.get(), request);
            _nguyenLieuRepository.save(nguyenLieuSua);
            return _nguyenLieuDTOResponseObject.responseSuccess("Sua nguyen lieu thanh cong", _converter.entityToDTO(nguyenLieuSua));
        }
    }

    public ResponseObject<NguyenLieuDTO> xoaNguyenLieu(int nguyenLieuId) {
        var nguyenLieu = _nguyenLieuRepository.findById(nguyenLieuId);
        if (nguyenLieu.isEmpty()) {
            return _nguyenLieuDTOResponseObject.responseError(HttpURLConnection.HTTP_NOT_FOUND, "Khong tim thay nguyen lieu", null);
        } else {
            _nguyenLieuRepository.delete(nguyenLieu.get());
            return _nguyenLieuDTOResponseObject.responseSuccess("Sua nguyen lieu thanh cong", _converter.entityToDTO(nguyenLieu.get()));
        }
    }

    public List<NguyenLieuDTO> layTatCaNguyenLieu(int pageSize, int pageNumber) {
        return _nguyenLieuRepository
                .findAll()
                .stream()
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize)
                .map(x -> _converter.entityToDTO(x))
                .collect(Collectors.toList());
    }

    public List<NguyenLieuDTO> layNguyenLieuTheoTen(String tenNguyenLieu, int pageSize, int pageNumber) {
        return _nguyenLieuRepository
                .findAll()
                .stream().filter(x -> x.getTenNguyenLieu().trim().toLowerCase().contains(tenNguyenLieu.trim().toLowerCase()))
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize)
                .map(x -> _converter.entityToDTO(x))
                .collect(Collectors.toList());
    }
}
