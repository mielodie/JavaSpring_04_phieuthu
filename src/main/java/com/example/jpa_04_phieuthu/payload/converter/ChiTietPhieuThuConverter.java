package com.example.jpa_04_phieuthu.payload.converter;

import com.example.jpa_04_phieuthu.entity.ChiTietPhieuThu;
import com.example.jpa_04_phieuthu.payload.dto.ChiTietPhieuThuDTO;
import com.example.jpa_04_phieuthu.payload.request.chitietphieuthu.ChiTietPhieuThuRequest;
import org.springframework.stereotype.Component;

@Component
public class ChiTietPhieuThuConverter {
    public ChiTietPhieuThuDTO entityToDTO(ChiTietPhieuThu chiTietPhieuThu) {
        ChiTietPhieuThuDTO dto = new ChiTietPhieuThuDTO();
        dto.setPhieuThuId(chiTietPhieuThu.getPhieuThuId());
        dto.setNguyenLieuId(chiTietPhieuThu.getNguyenLieuId());
        dto.setSoLuongBan(chiTietPhieuThu.getSoLuongBan());
        return dto;
    }

    public ChiTietPhieuThu themChiTietPhieuThu(ChiTietPhieuThuRequest request) {
        ChiTietPhieuThu chiTietPhieuThu = new ChiTietPhieuThu();
        chiTietPhieuThu.setPhieuThuId(request.getPhieuThuId());
        chiTietPhieuThu.setNguyenLieuId(request.getNguyenLieuId());
        chiTietPhieuThu.setSoLuongBan(request.getSoLuongBan());
        return chiTietPhieuThu;
    }

    public ChiTietPhieuThu suaChiTietPhieuThu(ChiTietPhieuThu chiTietPhieuThu, ChiTietPhieuThuRequest request) {
        chiTietPhieuThu.setPhieuThuId(request.getPhieuThuId());
        chiTietPhieuThu.setNguyenLieuId(request.getNguyenLieuId());
        chiTietPhieuThu.setSoLuongBan(request.getSoLuongBan());
        return chiTietPhieuThu;
    }
}
