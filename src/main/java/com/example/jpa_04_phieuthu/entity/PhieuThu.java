package com.example.jpa_04_phieuthu.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "phieuthus")
public class PhieuThu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int phieuThuId;
    @Column(name = "ngaylap")
    private LocalDate ngayLap = LocalDate.now();
    @ManyToOne
    @JoinColumn(name = "nhanvienid", insertable = false, updatable = false)
    @JsonBackReference
    private NhanVien nhanVien;
    @Column(name = "nhanvienid")
    private int nhanVienId;
    @Column(name = "ghichu")
    private String ghiChu;
    @Column(name = "tongtien")
    private double tongTien = 0;
    @OneToMany(mappedBy = "phieuThu")
    @JsonManagedReference
    private List<ChiTietPhieuThu> chiTietPhieuThus;

    public int getPhieuThuId() {
        return phieuThuId;
    }

    public void setPhieuThuId(int phieuThuId) {
        this.phieuThuId = phieuThuId;
    }

    public LocalDate getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(LocalDate ngayLap) {
        this.ngayLap = ngayLap;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
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

    public void setTongTien(double doanhThu) {
        this.tongTien = doanhThu;
    }

    public List<ChiTietPhieuThu> getChiTietPhieuThus() {
        return chiTietPhieuThus;
    }

    public void setChiTietPhieuThus(List<ChiTietPhieuThu> chiTietPhieuThus) {
        this.chiTietPhieuThus = chiTietPhieuThus;
    }

    public PhieuThu() {
    }
}
