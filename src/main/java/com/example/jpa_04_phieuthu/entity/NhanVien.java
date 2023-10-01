package com.example.jpa_04_phieuthu.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "nhanviens")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int nhanVienId;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "hoten")
    private String hoTen;
    @ManyToOne
    @JoinColumn(name = "quyenhanid", insertable = false, updatable = false)
    @JsonBackReference
    private QuyenHan quyenHan;
    @Column(name = "quyenhanid")
    private int quyenHanId = 3;

    public int getNhanVienId() {
        return nhanVienId;
    }

    public void setNhanVienId(int nhanVienId) {
        this.nhanVienId = nhanVienId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public QuyenHan getQuyenHan() {
        return quyenHan;
    }

    public void setQuyenHan(QuyenHan quyenHan) {
        this.quyenHan = quyenHan;
    }

    public int getQuyenHanId() {
        return quyenHanId;
    }

    public void setQuyenHanId(int quyenHanId) {
        this.quyenHanId = quyenHanId;
    }

    public NhanVien() {
    }
}
