package com.kilo.klio.repository;

import com.kilo.klio.entity.item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface itemRepository extends JpaRepository<item, Long> {
}
