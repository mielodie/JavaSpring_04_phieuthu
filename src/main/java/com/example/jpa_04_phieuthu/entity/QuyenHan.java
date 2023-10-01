package com.example.jpa_04_phieuthu.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Entity
@Table(name = "quyenhans")
public class QuyenHan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int quyenHanId;
    @Column(name = "tenquyenhan")
    private String tenQuyenHan;
    @OneToMany(mappedBy = "quyenHan")
    @JsonManagedReference
    private List<NhanVien> nhanViens;

    public int getQuyenHanId() {
        return quyenHanId;
    }

    public void setQuyenHanId(int quyenHanId) {
        this.quyenHanId = quyenHanId;
    }

    public String getTenQuyenHan() {
        return tenQuyenHan;
    }

    public void setTenQuyenHan(String tenQuyenHan) {
        this.tenQuyenHan = tenQuyenHan;
    }

    public List<NhanVien> getNhanViens() {
        return nhanViens;
    }

    public void setNhanViens(List<NhanVien> nhanViens) {
        this.nhanViens = nhanViens;
    }

    public QuyenHan() {
    }
}
