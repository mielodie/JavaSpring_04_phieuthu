package com.example.jpa_04_phieuthu.payload.dto;

import java.time.LocalDate;

public class PhieuNhapDTO {
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

    public int getNhanVienId() {
        return nhanVienId;
    }

    public void setNhanVienId(int nhanVienId) {
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

    public void setTongTien(double tongChi) {
        this.tongTien = tongChi;
    }
}
