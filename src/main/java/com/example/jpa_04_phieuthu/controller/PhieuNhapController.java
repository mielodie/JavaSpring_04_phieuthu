package com.example.jpa_04_phieuthu.controller;

import com.example.jpa_04_phieuthu.payload.dto.PhieuNhapDTO;
import com.example.jpa_04_phieuthu.payload.dto.PhieuThuDTO;
import com.example.jpa_04_phieuthu.payload.request.phieunhap.PhieuNhapRequest;
import com.example.jpa_04_phieuthu.payload.request.phieuthu.PhieuThuRequest;
import com.example.jpa_04_phieuthu.payload.response.ResponseObject;
import com.example.jpa_04_phieuthu.service.PhieuNhapService;
import com.example.jpa_04_phieuthu.service.PhieuThuService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class PhieuNhapController {
    private final PhieuNhapService _phieuNhapService;

    public PhieuNhapController(PhieuNhapService phieuNhapService) {
        _phieuNhapService = phieuNhapService;
    }

    @PostMapping(value = "themphieunhap", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<PhieuNhapDTO> themPhieuNhap(@RequestBody PhieuNhapRequest request) {
        return _phieuNhapService.themPhieuNhap(request);
    }

    @PutMapping(value = "suaphieunhap", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<PhieuNhapDTO> suaPhieuNhap(@RequestParam int phieuNhapId, @RequestBody PhieuNhapRequest request) {
        return _phieuNhapService.suaPhieuNhap(phieuNhapId, request);
    }

    @DeleteMapping(value = "xoaphieunhap", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<PhieuNhapDTO> xoaPhieuNhap(@RequestParam int phieuNhapId) {
        return _phieuNhapService.xoaPhieuNhap(phieuNhapId);
    }

    @GetMapping(value = "laytatcaphieunhap", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PhieuNhapDTO> layTatCaPhieuNhap(@RequestParam int pageSize, @RequestParam int pageNumber) {
        return _phieuNhapService.layTatCaPhieuNhap(pageSize, pageNumber);
    }

    @GetMapping(value = "layphieunhaptheongaytao", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PhieuNhapDTO> layPhieuNhapTheoNgayTao(@RequestParam LocalDate date, @RequestParam int pageSize, @RequestParam int pageNumber) {
        return _phieuNhapService.layPhieuNhapTheoNgayTao(date, pageSize, pageNumber);
    }
}
