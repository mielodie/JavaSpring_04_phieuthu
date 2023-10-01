package com.example.jpa_04_phieuthu.payload.request.chitietphieunhap;

public class ChiTietPhieuNhapRequest {
    private int nguyenLieuId;
    private int soLuongNhap;

    public int getNguyenLieuId() {
        return nguyenLieuId;
    }

    public void setNguyenLieuId(int nguyenLieuId) {
        this.nguyenLieuId = nguyenLieuId;
    }

    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }
}
