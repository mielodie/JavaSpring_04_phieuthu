package com.example.jpa_04_phieuthu.controller;

import com.example.jpa_04_phieuthu.payload.dto.ChiTietPhieuThuDTO;
import com.example.jpa_04_phieuthu.payload.request.chitietphieuthu.ChiTietPhieuThuRequest;
import com.example.jpa_04_phieuthu.payload.response.ResponseObject;
import com.example.jpa_04_phieuthu.service.ChiTietPhieuThuService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChiTietPhieuThuController {
    private final ChiTietPhieuThuService _chiTietPhieuThuService;

    public ChiTietPhieuThuController(ChiTietPhieuThuService chiTietPhieuThuService) {
        _chiTietPhieuThuService = chiTietPhieuThuService;
    }

    @PutMapping(value = "suachitietphieuthu", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<ChiTietPhieuThuDTO> suaChiTietPhieuThu(@RequestParam int chiTietPhieuThuId, @RequestBody ChiTietPhieuThuRequest request) {
        return _chiTietPhieuThuService.suaChiTietPhieuThu(chiTietPhieuThuId, request);
    }

    @DeleteMapping(value = "xoachitietphieuthu", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<ChiTietPhieuThuDTO> suaChiTietPhieuThu(@RequestParam int chiTietPhieuThuId) {
        return _chiTietPhieuThuService.xoaChiTietPhieuThu(chiTietPhieuThuId);
    }

    @GetMapping(value = "laychitiettheophieuthu", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ChiTietPhieuThuDTO> layChiTietTheoPhieuThu(@RequestParam int phieuThuId, @RequestParam int pageSize, @RequestParam int pageNumber){
        return _chiTietPhieuThuService.layChiTietTheoPhieuThu(phieuThuId, pageSize, pageNumber);
    }

    @GetMapping(value = "laychitietphieuthutheonguyenlieu", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ChiTietPhieuThuDTO> layChiTietTheoNguyenLieu(@RequestParam int nguyenLieuId, @RequestParam int pageSize, @RequestParam int pageNumber){
        return _chiTietPhieuThuService.layChiTietTheoNguyenLieu(nguyenLieuId, pageSize, pageNumber);
    }
}
