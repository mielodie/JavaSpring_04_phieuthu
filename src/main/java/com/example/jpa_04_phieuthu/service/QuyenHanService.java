package com.example.jpa_04_phieuthu.service;

import com.example.jpa_04_phieuthu.entity.QuyenHan;
import com.example.jpa_04_phieuthu.payload.converter.QuyenHanConverter;
import com.example.jpa_04_phieuthu.payload.dto.QuyenHanDTO;
import com.example.jpa_04_phieuthu.payload.request.quyenhan.QuyenHanRequest;
import com.example.jpa_04_phieuthu.payload.response.ResponseObject;
import com.example.jpa_04_phieuthu.repository.QuyenHanRepository;
import com.example.jpa_04_phieuthu.service.interfaceservice.iQuyenHanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuyenHanService implements iQuyenHanService {
    @Autowired
    private QuyenHanRepository _quyenHanRepository;

    @Autowired
    private QuyenHanConverter _converter;

    @Autowired
    public ResponseObject<QuyenHanDTO> _quyenHanDTOResponseObject;
    public ResponseObject<QuyenHanDTO> themQuyenHan(QuyenHanRequest request) {
        QuyenHan quyenHan = new QuyenHan();
        quyenHan.setTenQuyenHan(request.getTenQuyenHan());
        _quyenHanRepository.save(quyenHan);
        return _quyenHanDTOResponseObject.responseSuccess("Them quyen han thanh cong", _converter.entityToDTO(quyenHan));
    }

    public ResponseObject<QuyenHanDTO> suaQuyenHan(int quyenHanId, QuyenHanRequest request) {
        var quyenHan = _quyenHanRepository.findById(quyenHanId);
        if (quyenHan.isEmpty()) {
            return _quyenHanDTOResponseObject.responseError(HttpURLConnection.HTTP_NOT_FOUND, "Khong tim thay quyen han", null);
        } else {
            quyenHan.get().setTenQuyenHan(request.getTenQuyenHan());
            _quyenHanRepository.save(quyenHan.get());
            return _quyenHanDTOResponseObject.responseSuccess("Sua quyen han thanh cong", _converter.entityToDTO(quyenHan.get()));
        }
    }

    public ResponseObject<QuyenHanDTO> xoaQuyenHan(int quyenHanId) {
        var quyenHan = _quyenHanRepository.findById(quyenHanId);
        if (quyenHan.isEmpty()) {
            return _quyenHanDTOResponseObject.responseError(HttpURLConnection.HTTP_NOT_FOUND, "Khong tim thay quyen han", null);
        } else {
            _quyenHanRepository.delete(quyenHan.get());
            return _quyenHanDTOResponseObject.responseSuccess("Xoa quyen han thanh cong", null);
        }
    }

    public List<QuyenHanDTO> layTatCaQuyenHan() {
        return _quyenHanRepository.findAll()
                .stream()
                .map(x -> _converter.entityToDTO(x))
                .collect(Collectors.toList());
    }
}
