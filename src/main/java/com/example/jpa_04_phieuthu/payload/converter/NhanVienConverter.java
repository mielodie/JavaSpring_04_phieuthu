package com.example.jpa_04_phieuthu.payload.converter;

import com.example.jpa_04_phieuthu.entity.NhanVien;
import com.example.jpa_04_phieuthu.payload.dto.NhanVienDTO;
import com.example.jpa_04_phieuthu.payload.request.nhanvien.DoiTenNguoiDungRequest;
import com.example.jpa_04_phieuthu.payload.request.nhanvien.TaoMoiTaiKhoanNhanVienRequest;
import org.springframework.stereotype.Component;

@Component
public class NhanVienConverter {
    public NhanVienDTO entityToDTO(NhanVien nhanVien) {
        NhanVienDTO dto = new NhanVienDTO();
        dto.setQuyenHanId(nhanVien.getQuyenHanId());
        dto.setHoTen(nhanVien.getHoTen());
        dto.setEmail(nhanVien.getEmail());
        dto.setPassword(nhanVien.getPassword());
        return dto;
    }

    public NhanVien taoMoiTaiKhoanNhanVien(TaoMoiTaiKhoanNhanVienRequest request) {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setQuyenHanId(request.getQuyenHanId());
        nhanVien.setHoTen(request.getTenTaiKhoan());
        nhanVien.setEmail(request.getEmail());
        nhanVien.setPassword(request.getPassword());
        return nhanVien;
    }
    public NhanVien doiTenNguoiDung(NhanVien nhanVien, DoiTenNguoiDungRequest request){
        nhanVien.setHoTen(request.getTenNguoiDung());
        return nhanVien;
    }
}
