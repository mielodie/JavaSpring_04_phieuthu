package com.example.jpa_04_phieuthu.service;

import com.example.jpa_04_phieuthu.entity.LoaiNguyenLieu;
import com.example.jpa_04_phieuthu.payload.converter.LoaiNguyenLieuConverter;
import com.example.jpa_04_phieuthu.payload.dto.LoaiNguyenLieuDTO;
import com.example.jpa_04_phieuthu.payload.request.loainguyenlieu.LoaiNguyenLieuRequest;
import com.example.jpa_04_phieuthu.payload.response.ResponseObject;
import com.example.jpa_04_phieuthu.repository.LoaiNguyenLieuRepository;
import com.example.jpa_04_phieuthu.service.interfaceservice.iLoaiNguyenLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoaiNguyenLieuService implements iLoaiNguyenLieuService {
    @Autowired
    private LoaiNguyenLieuRepository _loaiNguyenLieuRepository;
    @Autowired
    public LoaiNguyenLieuConverter _converter;
    @Autowired
    public ResponseObject<LoaiNguyenLieuDTO> _loaiNguyenLieuDTOResponseObject;

    public ResponseObject<LoaiNguyenLieuDTO> themLoaiNguyenLieu(LoaiNguyenLieuRequest request) {
        var loaiNguyenLieu = _converter.themLoaiNguyenLieu(request);
        _loaiNguyenLieuRepository.save(loaiNguyenLieu);
        return _loaiNguyenLieuDTOResponseObject.responseSuccess("Them loai nguyen lieu thanh cong", _converter.entityToDTO(loaiNguyenLieu));
    }

    public ResponseObject<LoaiNguyenLieuDTO> suaLoaiNguyenLieu(int loaiNguyenLieuId, LoaiNguyenLieuRequest request) {
        var loaiNguyenLieu = _loaiNguyenLieuRepository.findById(loaiNguyenLieuId);
        if (loaiNguyenLieu == null) {
            return _loaiNguyenLieuDTOResponseObject.responseError(HttpURLConnection.HTTP_NOT_FOUND, "Khong tim thay loai nguyen lieu", null);
        } else {
            var loaiNguyenLieuSua = _converter.suaLoaiNguyenLieu(loaiNguyenLieu.get(), request);
            _loaiNguyenLieuRepository.save(loaiNguyenLieuSua);
            return _loaiNguyenLieuDTOResponseObject.responseSuccess("Sua loai nguyen lieu thanh cong", _converter.entityToDTO(loaiNguyenLieuSua));
        }
    }

    public ResponseObject<LoaiNguyenLieuDTO> xoaLoaiNguyenLieu(int loaiNguyenLieuId) {
        var loaiNguyenLieu = _loaiNguyenLieuRepository.findById(loaiNguyenLieuId);
        if (loaiNguyenLieu == null) {
            return _loaiNguyenLieuDTOResponseObject.responseError(HttpURLConnection.HTTP_NOT_FOUND, "Khong tim thay loai nguyen lieu", null);
        } else {
            _loaiNguyenLieuRepository.delete(loaiNguyenLieu.get());
            return _loaiNguyenLieuDTOResponseObject.responseSuccess("Xoa loai nguyen lieu thanh cong", null);
        }
    }

    public List<LoaiNguyenLieuDTO> layTatCaLoaiNguyenLieu(int pageSize, int pageNumber) {
        return _loaiNguyenLieuRepository
                .findAll()
                .stream()
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize)
                .map(x -> _converter.entityToDTO(x))
                .collect(Collectors.toList());
    }

    public List<LoaiNguyenLieuDTO> layLoaiNguyenLieuTheoTen(String tenLoai, int pageSize, int pageNumber) {
        return _loaiNguyenLieuRepository
                .findAll()
                .stream().filter(x -> x.getTenLoaiNguyenLieu().trim().toLowerCase().contains(tenLoai.trim().toLowerCase()))
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize)
                .map(x -> _converter.entityToDTO(x))
                .collect(Collectors.toList());
    }
}
