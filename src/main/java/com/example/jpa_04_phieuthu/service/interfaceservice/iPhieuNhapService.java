package com.example.jpa_04_phieuthu.service.interfaceservice;

import com.example.jpa_04_phieuthu.payload.dto.PhieuNhapDTO;
import com.example.jpa_04_phieuthu.payload.dto.PhieuThuDTO;
import com.example.jpa_04_phieuthu.payload.request.phieunhap.PhieuNhapRequest;
import com.example.jpa_04_phieuthu.payload.request.phieuthu.PhieuThuRequest;
import com.example.jpa_04_phieuthu.payload.response.ResponseObject;

import java.time.LocalDate;
import java.util.List;

public interface iPhieuNhapService {
    public ResponseObject<PhieuNhapDTO> themPhieuNhap(PhieuNhapRequest request);

    public ResponseObject<PhieuNhapDTO> suaPhieuNhap(int phieuNhapId, PhieuNhapRequest request);

    public ResponseObject<PhieuNhapDTO> xoaPhieuNhap(int phieuNhapId);

    public List<PhieuNhapDTO> layTatCaPhieuNhap(int pageSize, int pageNumber);

    public List<PhieuNhapDTO> layPhieuNhapTheoNgayTao(LocalDate date, int pageSize, int pageNumber);
}
