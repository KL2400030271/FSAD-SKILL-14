package com.klu.backend_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klu.backend_1.model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}