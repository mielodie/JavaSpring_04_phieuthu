package com.example.jpa_04_phieuthu.service.interfaceservice;

import com.example.jpa_04_phieuthu.payload.dto.QuyenHanDTO;
import com.example.jpa_04_phieuthu.payload.request.quyenhan.QuyenHanRequest;
import com.example.jpa_04_phieuthu.payload.response.ResponseObject;

import java.util.List;

public interface iQuyenHanService {
    public ResponseObject<QuyenHanDTO> themQuyenHan(QuyenHanRequest request);

    public ResponseObject<QuyenHanDTO> suaQuyenHan(int quyenHanId, QuyenHanRequest request);

    public ResponseObject<QuyenHanDTO> xoaQuyenHan(int quyenHanId);

    public List<QuyenHanDTO> layTatCaQuyenHan();
}
