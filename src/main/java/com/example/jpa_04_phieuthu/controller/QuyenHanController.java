package com.example.jpa_04_phieuthu.controller;

import com.example.jpa_04_phieuthu.payload.dto.QuyenHanDTO;
import com.example.jpa_04_phieuthu.payload.request.quyenhan.QuyenHanRequest;
import com.example.jpa_04_phieuthu.payload.response.ResponseObject;
import com.example.jpa_04_phieuthu.service.QuyenHanService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuyenHanController {
    private final QuyenHanService _quyenHanService;

    public QuyenHanController(QuyenHanService quyenHanService) {
        _quyenHanService = quyenHanService;
    }

    @PostMapping(value = "themquyenhan", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<QuyenHanDTO> themQuyenHan(@RequestBody QuyenHanRequest request) {
        return _quyenHanService.themQuyenHan(request);
    }

    @PutMapping(value = "suaquyenhan", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<QuyenHanDTO> suaQuyenHan(@RequestParam int quyenHanId, @RequestBody QuyenHanRequest request) {
        return _quyenHanService.suaQuyenHan(quyenHanId, request);
    }

    @DeleteMapping(value = "xoaquyenhan", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<QuyenHanDTO> xoaQuyenHan(@RequestParam int quyenHanId) {
        return _quyenHanService.xoaQuyenHan(quyenHanId);
    }

    @GetMapping(value = "laytatcaquyenhan", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<QuyenHanDTO> layTatCaQuyenHan() {
        return _quyenHanService.layTatCaQuyenHan();
    }
}
