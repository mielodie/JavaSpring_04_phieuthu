package com.example.jpa_04_phieuthu.payload.converter;

import com.example.jpa_04_phieuthu.entity.ChiTietPhieuNhap;
import com.example.jpa_04_phieuthu.payload.dto.ChiTietPhieuNhapDTO;
import com.example.jpa_04_phieuthu.payload.request.chitietphieunhap.ChiTietPhieuNhapRequest;
import org.springframework.stereotype.Component;

@Component
public class ChiTietPhieuNhapConverter {
    public ChiTietPhieuNhapDTO entityToDTO(ChiTietPhieuNhap chiTietPhieuNhap) {
        ChiTietPhieuNhapDTO dto = new ChiTietPhieuNhapDTO();
        dto.setPhieuNhapId(chiTietPhieuNhap.getPhieuNhapId());
        dto.setNguyenLieuId(chiTietPhieuNhap.getNguyenLieuId());
        dto.setSoLuongNhap(chiTietPhieuNhap.getSoLuongNhap());
        return dto;
    }

    public ChiTietPhieuNhap themChiTietPhieuNhap(ChiTietPhieuNhapRequest request) {
        ChiTietPhieuNhap chiTietPhieuNhap = new ChiTietPhieuNhap();
        chiTietPhieuNhap.setNguyenLieuId(request.getNguyenLieuId());
        chiTietPhieuNhap.setSoLuongNhap(request.getSoLuongNhap());
        return chiTietPhieuNhap;
    }

    public ChiTietPhieuNhap suaChiTietPhieuNhap(ChiTietPhieuNhap chiTietPhieuNhap, ChiTietPhieuNhapRequest request) {
        chiTietPhieuNhap.setNguyenLieuId(request.getNguyenLieuId());
        chiTietPhieuNhap.setSoLuongNhap(request.getSoLuongNhap());
        return chiTietPhieuNhap;
    }
}
