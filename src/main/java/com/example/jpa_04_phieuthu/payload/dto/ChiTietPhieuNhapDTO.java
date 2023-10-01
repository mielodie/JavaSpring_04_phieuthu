package com.example.jpa_04_phieuthu.payload.dto;

public class ChiTietPhieuNhapDTO {
    private int nguyenLieuId;
    private int phieuNhapId;
    private int soLuongNhap;

    public int getNguyenLieuId() {
        return nguyenLieuId;
    }

    public void setNguyenLieuId(int nguyenLieuId) {
        this.nguyenLieuId = nguyenLieuId;
    }

    public int getPhieuNhapId() {
        return phieuNhapId;
    }

    public void setPhieuNhapId(int phieuThuId) {
        this.phieuNhapId = phieuThuId;
    }

    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }
}
