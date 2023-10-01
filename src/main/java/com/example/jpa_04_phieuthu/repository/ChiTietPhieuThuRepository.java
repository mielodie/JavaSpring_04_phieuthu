package com.example.jpa_04_phieuthu.repository;

import com.example.jpa_04_phieuthu.entity.ChiTietPhieuThu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietPhieuThuRepository extends JpaRepository<ChiTietPhieuThu, Integer> {
}
