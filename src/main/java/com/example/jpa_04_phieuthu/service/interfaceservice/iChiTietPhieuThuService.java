package com.example.jpa_04_phieuthu.service.interfaceservice;

import com.example.jpa_04_phieuthu.entity.ChiTietPhieuThu;
import com.example.jpa_04_phieuthu.payload.dto.ChiTietPhieuThuDTO;
import com.example.jpa_04_phieuthu.payload.request.chitietphieuthu.ChiTietPhieuThuRequest;
import com.example.jpa_04_phieuthu.payload.response.ResponseObject;

import java.util.List;

public interface iChiTietPhieuThuService {
    public List<ChiTietPhieuThu> themChiTietPhieuThu(int phieuThuId, List<ChiTietPhieuThuRequest> requests);

    public ResponseObject<ChiTietPhieuThuDTO> suaChiTietPhieuThu(int chiTietPhieuThuId, ChiTietPhieuThuRequest request);

    public ResponseObject<ChiTietPhieuThuDTO> xoaChiTietPhieuThu(int chiTietPhieuThuId);

    public List<ChiTietPhieuThuDTO> layChiTietTheoPhieuThu(int phieuThuId, int pageSize, int pageNumber);

    public List<ChiTietPhieuThuDTO> layChiTietTheoNguyenLieu(int nguyenLieuId, int pageSize, int pageNumber);
}
