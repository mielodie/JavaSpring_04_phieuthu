package com.example.jpa_04_phieuthu.service.interfaceservice;

import com.example.jpa_04_phieuthu.payload.dto.LoaiNguyenLieuDTO;
import com.example.jpa_04_phieuthu.payload.request.loainguyenlieu.LoaiNguyenLieuRequest;
import com.example.jpa_04_phieuthu.payload.response.ResponseObject;

import java.util.List;

public interface iLoaiNguyenLieuService {
    public ResponseObject<LoaiNguyenLieuDTO> themLoaiNguyenLieu(LoaiNguyenLieuRequest request);

    public ResponseObject<LoaiNguyenLieuDTO> suaLoaiNguyenLieu(int loaiNguyenLieuId, LoaiNguyenLieuRequest request);

    public ResponseObject<LoaiNguyenLieuDTO> xoaLoaiNguyenLieu(int loaiNguyenLieuId);

    public List<LoaiNguyenLieuDTO> layTatCaLoaiNguyenLieu(int pageSize, int pageNumber);

    public List<LoaiNguyenLieuDTO> layLoaiNguyenLieuTheoTen(String tenLoai, int pageSize, int pageNumber);
}
