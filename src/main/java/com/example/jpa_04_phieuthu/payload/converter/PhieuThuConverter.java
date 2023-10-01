package com.example.jpa_04_phieuthu.payload.converter;

import com.example.jpa_04_phieuthu.entity.PhieuThu;
import com.example.jpa_04_phieuthu.payload.dto.PhieuThuDTO;
import com.example.jpa_04_phieuthu.payload.request.phieuthu.PhieuThuRequest;
import org.springframework.stereotype.Component;

@Component
public class PhieuThuConverter {
    public PhieuThuDTO entityToDTO(PhieuThu phieuThu) {
        PhieuThuDTO dto = new PhieuThuDTO();
        dto.setNgayLap(phieuThu.getNgayLap());
        dto.setGhiChu(phieuThu.getGhiChu());
        dto.setNhanVienLap(phieuThu.getNhanVienId());
        dto.setTongTien(phieuThu.getTongTien());
        return dto;
    }

    public PhieuThu themPhieuThu(PhieuThuRequest request) {
        PhieuThu phieuThu = new PhieuThu();
        phieuThu.setNhanVienId(request.getNhanVienId());
        phieuThu.setGhiChu(request.getGhiChu());
        phieuThu.setNgayLap(request.getNgayLap());
        return phieuThu;
    }

    public PhieuThu suaPhieuThu(PhieuThu phieuThu, PhieuThuRequest request) {
        phieuThu.setNhanVienId(request.getNhanVienId());
        phieuThu.setGhiChu(request.getGhiChu());
        phieuThu.setNgayLap(request.getNgayLap());
        return phieuThu;
    }
}
