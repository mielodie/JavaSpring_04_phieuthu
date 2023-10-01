package com.example.jpa_04_phieuthu.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "phieunhaps")
public class PhieuNhap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int phieuNhapId;
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
    @OneToMany(mappedBy = "phieuNhap")
    @JsonManagedReference
    private List<ChiTietPhieuNhap> chiTietPhieuNhaps;

    public int getPhieuNhapId() {
        return phieuNhapId;
    }

    public void setPhieuNhapId(int phieuNhapId) {
        this.phieuNhapId = phieuNhapId;
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

    public void setTongTien(double tongChi) {
        this.tongTien = tongChi;
    }

    public List<ChiTietPhieuNhap> getChiTietPhieuNhaps() {
        return chiTietPhieuNhaps;
    }

    public void setChiTietPhieuNhaps(List<ChiTietPhieuNhap> chiTietPhieuNhaps) {
        this.chiTietPhieuNhaps = chiTietPhieuNhaps;
    }

    public PhieuNhap() {
    }
}
