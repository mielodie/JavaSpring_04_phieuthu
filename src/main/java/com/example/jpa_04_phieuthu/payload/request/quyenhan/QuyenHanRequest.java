package com.example.jpa_04_phieuthu.payload.request.quyenhan;

import com.example.jpa_04_phieuthu.payload.dto.QuyenHanDTO;
import com.example.jpa_04_phieuthu.payload.response.ResponseObject;

import java.net.ResponseCache;

public class QuyenHanRequest {
    private String tenQuyenHan;

    public String getTenQuyenHan() {
        return tenQuyenHan;
    }

    public void setTenQuyenHan(String tenQuyenHan) {
        this.tenQuyenHan = tenQuyenHan;
    }
}
