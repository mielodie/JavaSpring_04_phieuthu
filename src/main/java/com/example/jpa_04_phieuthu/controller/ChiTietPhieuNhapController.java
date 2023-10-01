package com.example.jpa_04_phieuthu.controller;

import com.example.jpa_04_phieuthu.payload.dto.ChiTietPhieuNhapDTO;
import com.example.jpa_04_phieuthu.payload.request.chitietphieunhap.ChiTietPhieuNhapRequest;
import com.example.jpa_04_phieuthu.payload.response.ResponseObject;
import com.example.jpa_04_phieuthu.service.ChiTietPhieuNhapService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChiTietPhieuNhapController {
    private final ChiTietPhieuNhapService _chiTietPhieuNhapService;

    public ChiTietPhieuNhapController(ChiTietPhieuNhapService chiTietPhieuNhapService) {
        _chiTietPhieuNhapService = chiTietPhieuNhapService;
    }

    @PutMapping(value = "suachitietphieunhap", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<ChiTietPhieuNhapDTO> suaChiTietPhieuNhap(@RequestParam int chiTietPhieuNhapId, @RequestBody ChiTietPhieuNhapRequest request) {
        return _chiTietPhieuNhapService.suaChiTietPhieuNhap(chiTietPhieuNhapId, request);
    }

    @DeleteMapping(value = "xoachitietphieunhap", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<ChiTietPhieuNhapDTO> suaChiTietPhieuNhap(@RequestParam int chiTietPhieuNhapId) {
        return _chiTietPhieuNhapService.xoaChiTietPhieuNhap(chiTietPhieuNhapId);
    }

    @GetMapping(value = "laychitiettheophieunhap", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ChiTietPhieuNhapDTO> layChiTietTheoPhieuNhap(@RequestParam int phieuNhapId, @RequestParam int pageSize, @RequestParam int pageNumber) {
        return _chiTietPhieuNhapService.layChiTietTheoPhieuNhap(phieuNhapId, pageSize, pageNumber);
    }

    @GetMapping(value = "laychitietphieunhaptheonguyenlieu", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ChiTietPhieuNhapDTO> layChiTietTheoNguyenLieu(@RequestParam int nguyenLieuId, @RequestParam int pageSize, @RequestParam int pageNumber) {
        return _chiTietPhieuNhapService.layChiTietTheoNguyenLieu(nguyenLieuId, pageSize, pageNumber);
    }
}
