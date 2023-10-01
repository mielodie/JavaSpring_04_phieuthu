package com.example.jpa_04_phieuthu.payload.dto;

import java.time.LocalDate;

public class PhieuThuDTO {
    private LocalDate ngayLap = LocalDate.now();
    private int nhanVienId;
    private String ghiChu;
    private double tongTien = 0;

    public LocalDate getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(LocalDate ngayLap) {
        this.ngayLap = ngayLap;
    }

    public int getNhanVienLap() {
        return nhanVienId;
    }

    public void setNhanVienLap(int nhanVienId) {
        this.nhanVienId = nhanVienId;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double thanhTien) {
        this.tongTien = thanhTien;
    }
}
