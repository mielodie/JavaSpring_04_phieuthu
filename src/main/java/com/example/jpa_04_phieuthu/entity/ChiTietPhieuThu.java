package com.example.jpa_04_phieuthu.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "chitietphieuthus")
public class ChiTietPhieuThu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int chiTietPhieuThuId;
    @ManyToOne
    @JoinColumn(name = "nguyenlieuid", insertable = false, updatable = false)
    @JsonBackReference
    private NguyenLieu nguyenLieu;
    @Column(name = "nguyenlieuid")
    private int nguyenLieuId;
    @ManyToOne
    @JoinColumn(name = "phieuthuid", insertable = false, updatable = false)
    @JsonBackReference
    private PhieuThu phieuThu;
    @Column(name = "phieuthuid")
    private int phieuThuId;
    @Column(name = "soluongban")
    private int soLuongBan;

    public int getChiTietPhieuThuId() {
        return chiTietPhieuThuId;
    }

    public void setChiTietPhieuThuId(int chiTietPhieuThuId) {
        this.chiTietPhieuThuId = chiTietPhieuThuId;
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

    public PhieuThu getPhieuThu() {
        return phieuThu;
    }

    public void setPhieuThu(PhieuThu phieuThu) {
        this.phieuThu = phieuThu;
    }

    public int getPhieuThuId() {
        return phieuThuId;
    }

    public void setPhieuThuId(int phieuThuId) {
        this.phieuThuId = phieuThuId;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public ChiTietPhieuThu() {
    }
}
