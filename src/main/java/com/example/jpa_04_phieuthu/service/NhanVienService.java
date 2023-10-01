package com.example.jpa_04_phieuthu.service;

import com.example.jpa_04_phieuthu.payload.converter.NhanVienConverter;
import com.example.jpa_04_phieuthu.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpa_04_phieuthu.payload.dto.NhanVienDTO;
import com.example.jpa_04_phieuthu.payload.request.nhanvien.DangNhapTaiKhoanNhanVienRequest;
import com.example.jpa_04_phieuthu.payload.request.nhanvien.DoiMatKhauRequest;
import com.example.jpa_04_phieuthu.payload.request.nhanvien.DoiTenNguoiDungRequest;
import com.example.jpa_04_phieuthu.payload.request.nhanvien.TaoMoiTaiKhoanNhanVienRequest;
import com.example.jpa_04_phieuthu.payload.response.ResponseObject;
import com.example.jpa_04_phieuthu.service.interfaceservice.iNhanVienService;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NhanVienService implements iNhanVienService {
    @Autowired
    private NhanVienRepository _nhanVienRepository;
    @Autowired
    public NhanVienConverter _converter;
    @Autowired
    public ResponseObject<NhanVienDTO> _nhanVienDTOResponseObject;

    public ResponseObject<NhanVienDTO> taoMoiTaiKhoanNhanVien(TaoMoiTaiKhoanNhanVienRequest request) {
        var taiKhoanTao = _converter.taoMoiTaiKhoanNhanVien(request);
        _nhanVienRepository.save(taiKhoanTao);
        return _nhanVienDTOResponseObject.responseSuccess("Tao tai khoan thanh cong", _converter.entityToDTO(taiKhoanTao));
    }

    public ResponseObject<NhanVienDTO> dangNhapTaiKhoanNhanVien(DangNhapTaiKhoanNhanVienRequest request) {
        var checkTaiKhoan = _nhanVienRepository.findAll()
                .stream().filter(x -> x.getHoTen().equals(request.getTenTaiKhoan()) && x.getPassword().equals(request.getPassword()))
                .findFirst()
                .orElse(null);
        if (checkTaiKhoan == null) {
            return _nhanVienDTOResponseObject.responseError(HttpURLConnection.HTTP_NOT_FOUND, "Tai khoan khong dung", null);
        } else {
            return _nhanVienDTOResponseObject.responseSuccess("Dang nhan thanh cong", _converter.entityToDTO(checkTaiKhoan));
        }
    }

    public ResponseObject<NhanVienDTO> doiMatKhauTaiKhoanNhanVien(DoiMatKhauRequest request) {
        var checkTaiKhoan = _nhanVienRepository.findAll()
                .stream().filter(x -> x.getHoTen().equals(request.getTenTaiKhoan()))
                .findFirst()
                .orElse(null);
        if (checkTaiKhoan == null) {
            return _nhanVienDTOResponseObject.responseError(HttpURLConnection.HTTP_NOT_FOUND, "Tai khoan nay khong ton tai", null);
        } else {
            var checkMatKhau = _nhanVienRepository.findAll()
                    .stream().filter(x -> x.getPassword().equals(request.getOldPassword()))
                    .findFirst()
                    .orElse(null);
            if (checkMatKhau == null) {
                return _nhanVienDTOResponseObject.responseError(HttpURLConnection.HTTP_NOT_FOUND, "Mat khau khong trung khop", null);
            } else {
                checkTaiKhoan.setPassword(request.getNewPassword());
                _nhanVienRepository.save(checkTaiKhoan);
                return _nhanVienDTOResponseObject.responseSuccess("Doi mat khau thanh cong", _converter.entityToDTO(checkTaiKhoan));
            }
        }
    }

    public ResponseObject<NhanVienDTO> doiThongTinTaiKhoan(int nhanVienId, DoiTenNguoiDungRequest request) {
        var checkTaiKhoan = _nhanVienRepository.findAll()
                .stream().filter(x -> x.getNhanVienId() == nhanVienId)
                .findFirst()
                .orElse(null);
        if (checkTaiKhoan == null) {
            return _nhanVienDTOResponseObject.responseError(HttpURLConnection.HTTP_NOT_FOUND, "Khong tim thay tai khoan nay", null);
        } else {
            var taiKhoan = _converter.doiTenNguoiDung(checkTaiKhoan, request);
            _nhanVienRepository.save(taiKhoan);
            return _nhanVienDTOResponseObject.responseSuccess("Doi thong tin tai khoan thanh cong", _converter.entityToDTO(taiKhoan));
        }
    }

    public List<NhanVienDTO> layTatCaNhanVien(int pageSize, int pageNumber) {
        return _nhanVienRepository.findAll()
                .stream()
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize)
                .map(x -> _converter.entityToDTO(x))
                .collect(Collectors.toList());
    }

    public List<NhanVienDTO> layNhanVienTheoTen(String tenTaiKhoan, int pageSize, int pageNumber) {
        return _nhanVienRepository.findAll()
                .stream().filter(x -> x.getHoTen().trim().toLowerCase().contains(tenTaiKhoan.trim().toLowerCase()))
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize)
                .map(x -> _converter.entityToDTO(x))
                .collect(Collectors.toList());
    }

}
