package com.example.demo.service;


import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;

import com.example.demo.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<UserDTO> getUser() {
        List<User> user = userRepository.findAll();

        List<UserDTO> userDTOs = new ArrayList<>();
        for(int i = 0; i < user.size(); i++) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUsername(user.get(i).getUsername());
            userDTO.setEmail(user.get(i).getEmail());
            userDTO.setPhoneNumber(user.get(i).getPhoneNumber());
            userDTO.setCode(user.get(i).getCode());
            userDTO.setEnabled(user.get(i).isEnabled());
            userDTOs.add(userDTO);
        }
        return userDTOs;
    }

    public User addUser(@Valid UserDTO request) {
            User user = new User();
            user.setUsername(request.getUsername());
            user.setPassword(request.getPassword());
            user.setEmail(request.getEmail());
            user.setCode(request.getCode());
            user.setPhoneNumber(request.getPhoneNumber());
            user.setEnabled(true);
        return userRepository.save(user);
    }

    public List<User> getUsersByName(String name) {
        return (List<User>) userRepository.findByUsernameLike("%" + name + "%");
    }

    public User updateUser(int id,@Valid UserDTO request) {
        User user = userRepository.findById(id).get();

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setCode(request.getCode());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setEnabled(request.isEnabled());

        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }


    public Map<String,Object> getUserMap(int id) {
        Map<String,Object> map = new HashMap<>();
        User user = userRepository.findById(id).get();
        map.put("phoneNumber",user.getPhoneNumber());
        map.put("username",user.getUsername());
        map.put("email",user.getEmail());
        return map;
    }

    public List<User> getUserDTO() {
        return userRepository.findAll();
    }



}
