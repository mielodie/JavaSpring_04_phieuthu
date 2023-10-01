package com.example.jpa_04_phieuthu.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "loainguyenlieus")
public class LoaiNguyenLieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int loaiNguyenLieuId;
    @Column(name = "tenloainguyenlieu")
    private String tenLoaiNguyenLieu;
    @Column(name = "mota")
    private String moTa;
    @OneToMany(mappedBy = "loaiNguyenLieu")
    @JsonManagedReference
    private List<NguyenLieu> nguyenLieus;

    public int getLoaiNguyenLieuId() {
        return loaiNguyenLieuId;
    }

    public void setLoaiNguyenLieuId(int loaiNguyenLieuId) {
        this.loaiNguyenLieuId = loaiNguyenLieuId;
    }

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

    public List<NguyenLieu> getNguyenLieus() {
        return nguyenLieus;
    }

    public void setNguyenLieus(List<NguyenLieu> nguyenLieus) {
        this.nguyenLieus = nguyenLieus;
    }

    public LoaiNguyenLieu() {
    }
}
