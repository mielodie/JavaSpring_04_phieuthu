package com.example.jpa_04_phieuthu.controller;

import com.example.jpa_04_phieuthu.payload.dto.LoaiNguyenLieuDTO;
import com.example.jpa_04_phieuthu.payload.request.loainguyenlieu.LoaiNguyenLieuRequest;
import com.example.jpa_04_phieuthu.payload.response.ResponseObject;
import com.example.jpa_04_phieuthu.service.LoaiNguyenLieuService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoaiNguyenLieuController {
    private final LoaiNguyenLieuService _loaiNguyenLieuService;

    public LoaiNguyenLieuController(LoaiNguyenLieuService loaiNguyenLieuService) {
        _loaiNguyenLieuService = loaiNguyenLieuService;
    }

    @RequestMapping(value = "themloainguyenlieu", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<LoaiNguyenLieuDTO> themLoaiNguyenLieu(@RequestBody LoaiNguyenLieuRequest request) {
        return _loaiNguyenLieuService.themLoaiNguyenLieu(request);
    }

    @RequestMapping(value = "sualoainguyenlieu", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<LoaiNguyenLieuDTO> suaLoaiNguyenLieu(@RequestParam int loaiNguyenLieuId, @RequestBody LoaiNguyenLieuRequest request) {
        return _loaiNguyenLieuService.suaLoaiNguyenLieu(loaiNguyenLieuId, request);
    }

    @RequestMapping(value = "xoaloainguyenlieu", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<LoaiNguyenLieuDTO> xoaLoaiNguyenLieu(@RequestParam int loaiNguyenLieuId) {
        return _loaiNguyenLieuService.xoaLoaiNguyenLieu(loaiNguyenLieuId);
    }

    @RequestMapping(value = "laytatcaloainguyenlieu", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LoaiNguyenLieuDTO> layTatCaLoaiNguyenLieu(@RequestParam int pageSize, @RequestParam int pageNumber) {
        return _loaiNguyenLieuService.layTatCaLoaiNguyenLieu(pageSize, pageNumber);
    }

    @RequestMapping(value = "layloainguyenlieutheoten", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LoaiNguyenLieuDTO> layLoaiNguyenLieuTheoTen(@RequestParam String tenLoai, @RequestParam int pageSize, @RequestParam int pageNumber) {
        return _loaiNguyenLieuService.layLoaiNguyenLieuTheoTen(tenLoai, pageSize, pageNumber);
    }
}

