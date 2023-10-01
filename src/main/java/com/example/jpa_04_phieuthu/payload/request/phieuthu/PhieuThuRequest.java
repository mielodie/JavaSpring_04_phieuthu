package com.example.jpa_04_phieuthu.payload.request.phieuthu;

import com.example.jpa_04_phieuthu.entity.ChiTietPhieuThu;
import com.example.jpa_04_phieuthu.payload.request.chitietphieuthu.ChiTietPhieuThuRequest;

import java.time.LocalDate;
import java.util.List;

public class PhieuThuRequest {
    private LocalDate ngayLap = LocalDate.now();
    private int nhanVienId;
    private String ghiChu;
    private List<ChiTietPhieuThuRequest> chiTietPhieuThuRequestList;

    public List<ChiTietPhieuThuRequest> getChiTietPhieuThuRequestList() {
        return chiTietPhieuThuRequestList;
    }

    public void setChiTietPhieuThuRequestList(List<ChiTietPhieuThuRequest> chiTietPhieuThuRequestList) {
        this.chiTietPhieuThuRequestList = chiTietPhieuThuRequestList;
    }

    public LocalDate getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(LocalDate ngayLap) {
        this.ngayLap = ngayLap;
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
}
