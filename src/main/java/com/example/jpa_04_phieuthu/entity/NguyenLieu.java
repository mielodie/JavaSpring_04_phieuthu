package com.example.jpa_04_phieuthu.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "nguyenlieus")
public class NguyenLieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int nguyenLieuId;
    @ManyToOne
    @JoinColumn(name = "loainguyenlieuid", insertable = false, updatable = false)
    @JsonBackReference
    private LoaiNguyenLieu loaiNguyenLieu;
    @Column(name = "loainguyenlieuid")
    private int loaiNguyenLieuId;
    @Column(name = "tennguyenlieu")
    private String tenNguyenLieu;
    @Column(name = "giaban")
    private double giaBan;
    @Column(name = "gianhap")
    private double giaNhap;
    @Column(name = "donvitinh")
    private String donViTinh;
    @Column(name = "soluongkho")
    private int soLuongKho = 0;
    @OneToMany(mappedBy = "nguyenLieu")
    @JsonManagedReference
    private List<ChiTietPhieuThu> chiTietPhieuThus;

    public int getNguyenLieuId() {
        return nguyenLieuId;
    }

    public void setNguyenLieuId(int nguyenLieuId) {
        this.nguyenLieuId = nguyenLieuId;
    }

    public LoaiNguyenLieu getLoaiNguyenLieu() {
        return loaiNguyenLieu;
    }

    public void setLoaiNguyenLieu(LoaiNguyenLieu loaiNguyenLieu) {
        this.loaiNguyenLieu = loaiNguyenLieu;
    }

    public int getLoaiNguyenLieuId() {
        return loaiNguyenLieuId;
    }

    public void setLoaiNguyenLieuId(int loaiNguyenLieuId) {
        this.loaiNguyenLieuId = loaiNguyenLieuId;
    }

    public String getTenNguyenLieu() {
        return tenNguyenLieu;
    }

    public void setTenNguyenLieu(String tenNguyenLieu) {
        this.tenNguyenLieu = tenNguyenLieu;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public int getSoLuongKho() {
        return soLuongKho;
    }

    public void setSoLuongKho(int soLuongKho) {
        this.soLuongKho = soLuongKho;
    }

    public List<ChiTietPhieuThu> getChiTietPhieuThus() {
        return chiTietPhieuThus;
    }

    public void setChiTietPhieuThus(List<ChiTietPhieuThu> chiTietPhieuThus) {
        this.chiTietPhieuThus = chiTietPhieuThus;
    }

    public NguyenLieu() {
    }
}
