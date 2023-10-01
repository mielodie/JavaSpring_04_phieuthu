package com.example.jpa_04_phieuthu.payload.converter;

import com.example.jpa_04_phieuthu.entity.PhieuNhap;
import com.example.jpa_04_phieuthu.entity.PhieuThu;
import com.example.jpa_04_phieuthu.payload.dto.PhieuNhapDTO;
import com.example.jpa_04_phieuthu.payload.dto.PhieuThuDTO;
import com.example.jpa_04_phieuthu.payload.request.phieunhap.PhieuNhapRequest;
import com.example.jpa_04_phieuthu.payload.request.phieuthu.PhieuThuRequest;
import org.springframework.stereotype.Component;

@Component
public class PhieuNhapConverter {
    public PhieuNhapDTO entityToDTO(PhieuNhap phieuNhap) {
        PhieuNhapDTO dto = new PhieuNhapDTO();
        dto.setNgayLap(phieuNhap.getNgayLap());
        dto.setGhiChu(phieuNhap.getGhiChu());
        dto.setNhanVienId(phieuNhap.getNhanVienId());
        dto.setTongTien(phieuNhap.getTongTien());
        return dto;
    }

    public PhieuNhap themPhieuNhap(PhieuNhapRequest request) {
        PhieuNhap phieuNhap = new PhieuNhap();
        phieuNhap.setNhanVienId(request.getNhanVienId());
        phieuNhap.setGhiChu(request.getGhiChu());
        phieuNhap.setNgayLap(request.getNgayLap());
        return phieuNhap;
    }

    public PhieuNhap suaPhieuNhap(PhieuNhap phieuNhap, PhieuNhapRequest request) {
        phieuNhap.setNhanVienId(request.getNhanVienId());
        phieuNhap.setGhiChu(request.getGhiChu());
        phieuNhap.setNgayLap(request.getNgayLap());
        return phieuNhap;
    }
}
