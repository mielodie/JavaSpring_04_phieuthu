package com.example.jpa_04_phieuthu.controller;

import com.example.jpa_04_phieuthu.payload.dto.PhieuThuDTO;
import com.example.jpa_04_phieuthu.payload.request.phieuthu.PhieuThuRequest;
import com.example.jpa_04_phieuthu.payload.response.ResponseObject;
import com.example.jpa_04_phieuthu.service.PhieuThuService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class PhieuThuController {
    private final PhieuThuService _phieuThuService;

    public PhieuThuController(PhieuThuService phieuThuService) {
        _phieuThuService = phieuThuService;
    }

    @PostMapping(value = "themphieuthu", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<PhieuThuDTO> themPhieuThu(@RequestBody PhieuThuRequest request) {
        return _phieuThuService.themPhieuThu(request);
    }

    @PutMapping(value = "suaphieuthu", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<PhieuThuDTO> suaPhieuThu(@RequestParam int phieuThuId, @RequestBody PhieuThuRequest request) {
        return _phieuThuService.suaPhieuThu(phieuThuId, request);
    }

    @DeleteMapping(value = "xoaphieuthu", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<PhieuThuDTO> xoaPhieuThu(@RequestParam int phieuThuId) {
        return _phieuThuService.xoaPhieuThu(phieuThuId);
    }

    @GetMapping(value = "laytatcaphieuthu", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PhieuThuDTO> layTatCaPhieuThu(@RequestParam int pageSize, @RequestParam int pageNumber) {
        return _phieuThuService.layTatCaPhieuThu(pageSize, pageNumber);
    }

    @GetMapping(value = "layphieuthutheongaytao", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PhieuThuDTO> layPhieuThuTheoNgayTao(@RequestParam LocalDate date, @RequestParam int pageSize, @RequestParam int pageNumber) {
        return _phieuThuService.layPhieuThuTheoNgayTao(date, pageSize, pageNumber);
    }
}
