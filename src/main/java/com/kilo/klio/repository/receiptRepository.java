package com.kilo.klio.repository;

import com.kilo.klio.entity.receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface receiptRepository extends JpaRepository<receipt, Long> {
    List<receipt> findByUserId(Long userId);
}
