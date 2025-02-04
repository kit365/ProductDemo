package com.example.demo.controller;


import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin/users")
public class UserController {

    @Autowired
    private UserService userService;

    //create new User
    @PostMapping("create")
    public ResponseEntity create(@Valid @RequestBody UserDTO user) {
        userService.addUser(user);
        return ResponseEntity.ok(user);
    }

    //show user
    @GetMapping("show")
    public ResponseEntity showUsers() {
       return ResponseEntity.ok(userService.getUser());
    }

    //show user
    @GetMapping("showall")
    public ResponseEntity showUserss() {
        return ResponseEntity.ok(userService.getUserDTO());
    }


    //show user
    @GetMapping
    public ResponseEntity showUsersbyId(@RequestParam("keyword") int id) {
        return ResponseEntity.ok(userService.getUserMap(id));
    }

    //bo sung
}
