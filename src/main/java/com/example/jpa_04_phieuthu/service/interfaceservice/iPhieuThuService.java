package com.example.jpa_04_phieuthu.service.interfaceservice;

import com.example.jpa_04_phieuthu.payload.dto.PhieuThuDTO;
import com.example.jpa_04_phieuthu.payload.request.phieuthu.PhieuThuRequest;
import com.example.jpa_04_phieuthu.payload.response.ResponseObject;

import java.time.LocalDate;
import java.util.List;

public interface iPhieuThuService {
    public ResponseObject<PhieuThuDTO> themPhieuThu(PhieuThuRequest request);

    public ResponseObject<PhieuThuDTO> suaPhieuThu(int phieuThuId, PhieuThuRequest request);

    public ResponseObject<PhieuThuDTO> xoaPhieuThu(int phieuThuId);

    public List<PhieuThuDTO> layTatCaPhieuThu(int pageSize, int pageNumber);

    public List<PhieuThuDTO> layPhieuThuTheoNgayTao(LocalDate date, int pageSize, int pageNumber);
}
