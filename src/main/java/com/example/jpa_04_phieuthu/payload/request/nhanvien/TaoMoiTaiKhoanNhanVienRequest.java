package com.example.jpa_04_phieuthu.payload.request.nhanvien;

public class TaoMoiTaiKhoanNhanVienRequest {
    private int quyenHanId;
    private String tenTaiKhoan;
    private String email;
    private String password;

    public int getQuyenHanId() {
        return quyenHanId;
    }

    public void setQuyenHanId(int quyenHanId) {
        this.quyenHanId = quyenHanId;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
