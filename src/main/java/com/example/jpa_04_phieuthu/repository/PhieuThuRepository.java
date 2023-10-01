package com.example.jpa_04_phieuthu.repository;

import com.example.jpa_04_phieuthu.entity.PhieuThu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhieuThuRepository extends JpaRepository<PhieuThu, Integer> {
}
