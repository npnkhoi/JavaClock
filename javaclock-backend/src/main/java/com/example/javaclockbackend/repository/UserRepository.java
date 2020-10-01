package com.example.javaclockbackend.repository;

import com.example.javaclockbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("SELECT s FROM User s WHERE s.username = :username and s.password = :password")
    List<User> findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
    List<User> findByUsername(String username);
}
