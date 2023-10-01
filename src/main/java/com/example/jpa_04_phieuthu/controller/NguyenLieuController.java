package com.example.jpa_04_phieuthu.controller;

import com.example.jpa_04_phieuthu.payload.dto.NguyenLieuDTO;
import com.example.jpa_04_phieuthu.payload.request.nguyenlieu.NguyenLieuRequest;
import com.example.jpa_04_phieuthu.payload.response.ResponseObject;
import com.example.jpa_04_phieuthu.service.NguyenLieuService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NguyenLieuController {
    private final NguyenLieuService _nguyenLieuService;

    public NguyenLieuController(NguyenLieuService nguyenLieuService){
        _nguyenLieuService = nguyenLieuService;
    }

    @PostMapping(value = "themnguyenlieu", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<NguyenLieuDTO> themNguyenLieu(@RequestParam int loaiNguyenLieuId, @RequestBody NguyenLieuRequest request) {
        return _nguyenLieuService.themNguyenLieu(loaiNguyenLieuId, request);
    }

    @PutMapping(value = "suanguyenlieu", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<NguyenLieuDTO> suaNguyenLieu(@RequestParam int nguyenLieuId, @RequestBody NguyenLieuRequest request) {
        return _nguyenLieuService.suaNguyenLieu(nguyenLieuId, request);
    }

    @DeleteMapping(value = "xoanguyenlieu", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<NguyenLieuDTO> xoaNguyenLieu(@RequestParam int nguyenLieuId) {
        return _nguyenLieuService.xoaNguyenLieu(nguyenLieuId);
    }

    @GetMapping(value = "laytatcanguyenlieu", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NguyenLieuDTO> layTatCaNguyenLieu(@RequestParam int pageSize, @RequestParam int pageNumber) {
        return _nguyenLieuService.layTatCaNguyenLieu(pageSize, pageNumber);
    }

    @GetMapping(value = "laynguyenlieutheoten", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NguyenLieuDTO> layNguyenLieuTheoTen(@RequestParam String tenNguyenLieu, @RequestParam int pageSize, @RequestParam int pageNumber) {
        return _nguyenLieuService.layNguyenLieuTheoTen(tenNguyenLieu, pageSize, pageNumber);
    }
}
