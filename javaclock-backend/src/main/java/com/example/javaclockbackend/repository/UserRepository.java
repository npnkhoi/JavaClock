package com.example.javaclockbackend.repository;

import com.example.javaclockbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
