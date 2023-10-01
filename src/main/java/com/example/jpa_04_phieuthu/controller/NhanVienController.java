package com.example.jpa_04_phieuthu.controller;

import com.example.jpa_04_phieuthu.payload.dto.NhanVienDTO;
import com.example.jpa_04_phieuthu.payload.request.nhanvien.DangNhapTaiKhoanNhanVienRequest;
import com.example.jpa_04_phieuthu.payload.request.nhanvien.DoiMatKhauRequest;
import com.example.jpa_04_phieuthu.payload.request.nhanvien.DoiTenNguoiDungRequest;
import com.example.jpa_04_phieuthu.payload.request.nhanvien.TaoMoiTaiKhoanNhanVienRequest;
import com.example.jpa_04_phieuthu.payload.response.ResponseObject;
import com.example.jpa_04_phieuthu.service.NhanVienService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NhanVienController {
    private final NhanVienService _nhanVienService;

    public NhanVienController(NhanVienService nhanVienService) {
        _nhanVienService = nhanVienService;
    }

    @PostMapping(value = "taomoitaikhoan", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<NhanVienDTO> taoMoiTaiKhoanNhanVien(@RequestBody TaoMoiTaiKhoanNhanVienRequest request) {
        return _nhanVienService.taoMoiTaiKhoanNhanVien(request);
    }

    @PostMapping(value = "dangnhap", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<NhanVienDTO> dangNhapTaiKhoanNhanVien(@RequestBody DangNhapTaiKhoanNhanVienRequest request) {
        return _nhanVienService.dangNhapTaiKhoanNhanVien(request);
    }

    @PutMapping(value = "doimatkhau", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<NhanVienDTO> doiMatKhauTaiKhoanNhanVien(@RequestBody DoiMatKhauRequest request) {
        return _nhanVienService.doiMatKhauTaiKhoanNhanVien(request);
    }

    @PutMapping(value = "doitentaikhoan", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<NhanVienDTO> doiThongTinTaiKhoan(@RequestParam int nhanVienId, @RequestBody DoiTenNguoiDungRequest request) {
        return _nhanVienService.doiThongTinTaiKhoan(nhanVienId, request);
    }

    @GetMapping(value = "laytatcanhanvien", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NhanVienDTO> layTatCaNhanVien(@RequestParam int pageSize, @RequestParam int pageNumber) {
        return _nhanVienService.layTatCaNhanVien(pageSize, pageNumber);
    }

    @GetMapping(value = "laynhanvientheoten", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NhanVienDTO> layNhanVienTheoTen(@RequestParam String tenTaiKhoan, @RequestParam int pageSize, @RequestParam int pageNumber) {
        return _nhanVienService.layNhanVienTheoTen(tenTaiKhoan, pageSize, pageNumber);
    }
}
