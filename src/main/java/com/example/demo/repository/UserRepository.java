package com.example.demo.repository;


import com.example.demo.entity.User;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByUsernameLike(@NotBlank(message = "Username cannot be empty") String username);
}
