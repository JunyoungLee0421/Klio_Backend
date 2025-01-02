package com.kilo.klio.repository;

import com.kilo.klio.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface userRepository extends JpaRepository<User, Integer>{
    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}


