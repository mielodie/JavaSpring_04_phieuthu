package com.example.jpa_04_phieuthu.payload.converter;

import com.example.jpa_04_phieuthu.entity.LoaiNguyenLieu;
import com.example.jpa_04_phieuthu.payload.dto.LoaiNguyenLieuDTO;
import com.example.jpa_04_phieuthu.payload.request.loainguyenlieu.LoaiNguyenLieuRequest;
import org.springframework.stereotype.Component;

@Component
public class LoaiNguyenLieuConverter {
    public LoaiNguyenLieuDTO entityToDTO(LoaiNguyenLieu loaiNguyenLieu) {
        LoaiNguyenLieuDTO dto = new LoaiNguyenLieuDTO();
        dto.setTenLoaiNguyenLieu(loaiNguyenLieu.getTenLoaiNguyenLieu());
        dto.setMoTa(loaiNguyenLieu.getMoTa());
        return dto;
    }

    public LoaiNguyenLieu themLoaiNguyenLieu(LoaiNguyenLieuRequest request) {
        LoaiNguyenLieu loaiNguyenLieu = new LoaiNguyenLieu();
        loaiNguyenLieu.setTenLoaiNguyenLieu(request.getTenLoaiNguyenLieu());
        loaiNguyenLieu.setMoTa(request.getMoTa());
        return loaiNguyenLieu;
    }

    public LoaiNguyenLieu suaLoaiNguyenLieu(LoaiNguyenLieu loaiNguyenLieu, LoaiNguyenLieuRequest request) {
        loaiNguyenLieu.setTenLoaiNguyenLieu(request.getTenLoaiNguyenLieu());
        loaiNguyenLieu.setMoTa(request.getMoTa());
        return loaiNguyenLieu;
    }
}
