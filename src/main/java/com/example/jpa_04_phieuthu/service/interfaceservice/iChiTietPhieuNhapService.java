package com.example.jpa_04_phieuthu.service.interfaceservice;

import com.example.jpa_04_phieuthu.entity.ChiTietPhieuNhap;
import com.example.jpa_04_phieuthu.entity.ChiTietPhieuThu;
import com.example.jpa_04_phieuthu.payload.dto.ChiTietPhieuNhapDTO;
import com.example.jpa_04_phieuthu.payload.dto.ChiTietPhieuThuDTO;
import com.example.jpa_04_phieuthu.payload.request.chitietphieunhap.ChiTietPhieuNhapRequest;
import com.example.jpa_04_phieuthu.payload.request.chitietphieuthu.ChiTietPhieuThuRequest;
import com.example.jpa_04_phieuthu.payload.response.ResponseObject;

import java.util.List;

public interface iChiTietPhieuNhapService {
    public List<ChiTietPhieuNhap> themChiTietPhieuNhap(int phieuNhapId, List<ChiTietPhieuNhapRequest> requests);
    public ResponseObject<ChiTietPhieuNhapDTO> suaChiTietPhieuNhap(int chiTietPhieuNhapId, ChiTietPhieuNhapRequest request);

    public ResponseObject<ChiTietPhieuNhapDTO> xoaChiTietPhieuNhap(int chiTietPhieuNhapId);

    public List<ChiTietPhieuNhapDTO> layChiTietTheoPhieuNhap(int phieuNhapId, int pageSize, int pageNumber);

    public List<ChiTietPhieuNhapDTO> layChiTietTheoNguyenLieu(int nguyenLieuId, int pageSize, int pageNumber);
}
