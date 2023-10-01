package com.example.jpa_04_phieuthu.service.interfaceservice;

import com.example.jpa_04_phieuthu.payload.dto.NhanVienDTO;
import com.example.jpa_04_phieuthu.payload.request.nhanvien.DangNhapTaiKhoanNhanVienRequest;
import com.example.jpa_04_phieuthu.payload.request.nhanvien.DoiMatKhauRequest;
import com.example.jpa_04_phieuthu.payload.request.nhanvien.DoiTenNguoiDungRequest;
import com.example.jpa_04_phieuthu.payload.request.nhanvien.TaoMoiTaiKhoanNhanVienRequest;
import com.example.jpa_04_phieuthu.payload.response.ResponseObject;

import java.util.List;

public interface iNhanVienService {
    public ResponseObject<NhanVienDTO> taoMoiTaiKhoanNhanVien(TaoMoiTaiKhoanNhanVienRequest request);

    public ResponseObject<NhanVienDTO> dangNhapTaiKhoanNhanVien(DangNhapTaiKhoanNhanVienRequest request);

    public ResponseObject<NhanVienDTO> doiMatKhauTaiKhoanNhanVien(DoiMatKhauRequest request);

    public ResponseObject<NhanVienDTO> doiThongTinTaiKhoan(int nhanVienId, DoiTenNguoiDungRequest request);

    public List<NhanVienDTO> layTatCaNhanVien(int pageSize, int pageNumber);

    public List<NhanVienDTO> layNhanVienTheoTen(String tenTaiKhoan, int pageSize, int pageNumber);
}
