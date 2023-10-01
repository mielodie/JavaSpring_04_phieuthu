package com.example.jpa_04_phieuthu.payload.dto;

public class LoaiNguyenLieuDTO {
    private String tenLoaiNguyenLieu;
    private String moTa;

    public String getTenLoaiNguyenLieu() {
        return tenLoaiNguyenLieu;
    }

    public void setTenLoaiNguyenLieu(String tenLoaiNguyenLieu) {
        this.tenLoaiNguyenLieu = tenLoaiNguyenLieu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
