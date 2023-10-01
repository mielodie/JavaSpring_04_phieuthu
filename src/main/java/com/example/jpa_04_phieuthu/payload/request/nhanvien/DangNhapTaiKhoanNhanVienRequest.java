package com.example.jpa_04_phieuthu.payload.request.nhanvien;

public class DangNhapTaiKhoanNhanVienRequest {
    private String tenTaiKhoan;
    private String password;

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }
    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
