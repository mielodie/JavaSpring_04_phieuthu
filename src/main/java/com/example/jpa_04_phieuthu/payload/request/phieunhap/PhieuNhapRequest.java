package com.example.jpa_04_phieuthu.payload.request.phieunhap;

import com.example.jpa_04_phieuthu.payload.request.chitietphieunhap.ChiTietPhieuNhapRequest;

import java.time.LocalDate;
import java.util.List;

public class PhieuNhapRequest {
    private LocalDate ngayLap = LocalDate.now();
    private int nhanVienId;
    private String ghiChu;
    private List<ChiTietPhieuNhapRequest> chiTietPhieuNhapRequestList;

    public List<ChiTietPhieuNhapRequest> getChiTietPhieuNhapRequestList() {
        return chiTietPhieuNhapRequestList;
    }

    public void setChiTietPhieuNhapRequestList(List<ChiTietPhieuNhapRequest> chiTietPhieuNhapRequestList) {
        this.chiTietPhieuNhapRequestList = chiTietPhieuNhapRequestList;
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
