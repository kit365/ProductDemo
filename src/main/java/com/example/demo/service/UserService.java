package com.example.demo.service;


import com.example.demo.entity.User;

import com.example.demo.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;




    public List<User> getUser() {
        return (List<User>) userRepository.findAll();
    }

    public User addUser(@Valid User user) {
        return userRepository.save(user);
    }

    public List<User> getUsersByName(String name) {
        return (List<User>) userRepository.findByUsernameLike("%" + name + "%");
    }

//    public User updateUser(@Valid User user) {
//
//
//    }

   
}
