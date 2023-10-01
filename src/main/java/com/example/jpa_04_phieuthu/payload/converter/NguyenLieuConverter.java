package com.example.jpa_04_phieuthu.payload.converter;

import com.example.jpa_04_phieuthu.entity.NguyenLieu;
import com.example.jpa_04_phieuthu.payload.dto.NguyenLieuDTO;
import com.example.jpa_04_phieuthu.payload.request.nguyenlieu.NguyenLieuRequest;
import org.springframework.stereotype.Component;

@Component
public class NguyenLieuConverter {
    public NguyenLieuDTO entityToDTO(NguyenLieu nguyenLieu) {
        NguyenLieuDTO dto = new NguyenLieuDTO();
        dto.setTenNguyenLieu(nguyenLieu.getTenNguyenLieu());
        dto.setGiaBan(nguyenLieu.getGiaBan());
        dto.setGiaNhap(nguyenLieu.getGiaNhap());
        dto.setDonViTinh(nguyenLieu.getDonViTinh());
        dto.setSoLuongKho(nguyenLieu.getSoLuongKho());
        return dto;
    }

    public NguyenLieu themNguyenLieu(NguyenLieuRequest request) {
        NguyenLieu nguyenLieu = new NguyenLieu();
        nguyenLieu.setTenNguyenLieu(request.getTenNguyenLieu());
        nguyenLieu.setLoaiNguyenLieuId(request.getLoaiNguyenLieuId());
        nguyenLieu.setGiaBan(request.getGiaBan());
        nguyenLieu.setGiaNhap(request.getGiaNhap());
        nguyenLieu.setDonViTinh(request.getDonViTinh());
        return nguyenLieu;
    }

    public NguyenLieu suaNguyenLieu(NguyenLieu nguyenLieu, NguyenLieuRequest request) {
        nguyenLieu.setTenNguyenLieu(request.getTenNguyenLieu());
        nguyenLieu.setLoaiNguyenLieuId(request.getLoaiNguyenLieuId());
        nguyenLieu.setGiaBan(request.getGiaBan());
        nguyenLieu.setGiaNhap(request.getGiaNhap());
        nguyenLieu.setDonViTinh(request.getDonViTinh());
        return nguyenLieu;
    }
}
