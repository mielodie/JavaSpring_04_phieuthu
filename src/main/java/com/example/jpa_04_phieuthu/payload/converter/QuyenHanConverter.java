package com.example.jpa_04_phieuthu.payload.converter;

import com.example.jpa_04_phieuthu.entity.QuyenHan;
import com.example.jpa_04_phieuthu.payload.dto.QuyenHanDTO;
import org.springframework.stereotype.Component;

@Component
public class QuyenHanConverter {
    public QuyenHanDTO entityToDTO(QuyenHan quyenHan) {
        QuyenHanDTO dto = new QuyenHanDTO();
        dto.setTenQuyenHan(quyenHan.getTenQuyenHan());
        return dto;
    }
}
