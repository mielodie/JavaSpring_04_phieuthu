package com.example.jpa_04_phieuthu.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "chitietphieunhaps")
public class ChiTietPhieuNhap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int chiTietPhieuNhapId;
    @ManyToOne
    @JoinColumn(name = "nguyenlieuid", insertable = false, updatable = false)
    @JsonBackReference
    private NguyenLieu nguyenLieu;
    @Column(name = "nguyenlieuid")
    private int nguyenLieuId;
    @ManyToOne
    @JoinColumn(name = "phieunhapid", insertable = false, updatable = false)
    @JsonBackReference
    private PhieuNhap phieuNhap;
    @Column(name = "phieunhapid")
    private int phieuNhapId;
    @Column(name = "soluongnhap")
    private int soLuongNhap;

    public int getChiTietPhieuNhapId() {
        return chiTietPhieuNhapId;
    }

    public void setChiTietPhieuNhapId(int chiTietPhieuNhapId) {
        this.chiTietPhieuNhapId = chiTietPhieuNhapId;
    }

    public NguyenLieu getNguyenLieu() {
        return nguyenLieu;
    }

    public void setNguyenLieu(NguyenLieu nguyenLieu) {
        this.nguyenLieu = nguyenLieu;
    }

    public int getNguyenLieuId() {
        return nguyenLieuId;
    }

    public void setNguyenLieuId(int nguyenLieuId) {
        this.nguyenLieuId = nguyenLieuId;
    }

    public PhieuNhap getPhieuNhap() {
        return phieuNhap;
    }

    public void setPhieuNhap(PhieuNhap phieuNhap) {
        this.phieuNhap = phieuNhap;
    }

    public int getPhieuNhapId() {
        return phieuNhapId;
    }

    public void setPhieuNhapId(int phieuNhapId) {
        this.phieuNhapId = phieuNhapId;
    }

    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }

    public ChiTietPhieuNhap() {
    }
}
