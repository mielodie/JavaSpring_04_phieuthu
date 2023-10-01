package com.example.jpa_04_phieuthu.service.interfaceservice;

import com.example.jpa_04_phieuthu.payload.dto.NguyenLieuDTO;
import com.example.jpa_04_phieuthu.payload.request.nguyenlieu.NguyenLieuRequest;
import com.example.jpa_04_phieuthu.payload.response.ResponseObject;

import java.util.List;

public interface iNguyenLieuService {
    public ResponseObject<NguyenLieuDTO> themNguyenLieu(int loaiNguyenLieuId, NguyenLieuRequest request);

    public ResponseObject<NguyenLieuDTO> suaNguyenLieu(int nguyenLieuId, NguyenLieuRequest request);

    public ResponseObject<NguyenLieuDTO> xoaNguyenLieu(int nguyenLieuId);

    public List<NguyenLieuDTO> layTatCaNguyenLieu(int pageSize, int pageNumber);

    public List<NguyenLieuDTO> layNguyenLieuTheoTen(String tenNguyenLieu, int pageSize, int pageNumber);
}
