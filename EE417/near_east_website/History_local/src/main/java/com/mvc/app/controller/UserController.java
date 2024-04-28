package com.mvc.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.app.config.SecurityUtils;
import com.mvc.app.entity.UserEntity;
import com.mvc.app.mapper.UserMapper;
import com.mvc.app.model.ArticleModel;
import com.mvc.app.model.UserModel;
import com.mvc.app.repository.UserRepository;
import com.mvc.app.service.UserService;
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    private UserRepository userRepository;

public UserController(UserService userService, UserRepository userRepository){
	this.userService=userService;
	this.userRepository=userRepository;
	
	
}
    @GetMapping("/loggedInUser")
    public ResponseEntity<UserEntity> getUser() {
    	UserEntity user = userService.findByLogin(SecurityUtils.getCurrentLogin());
        if (user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.status(401).build();
        }

    }
    
    
    @PostMapping("/add/user")
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel user) {
        try {
            UserModel created = userService.addUser(user);
            return ResponseEntity.ok(created);
        } catch (Exception x) {
            x.printStackTrace();
            return ResponseEntity.badRequest().build();
		}

	}
    
    
    @GetMapping("/users")
	public ResponseEntity<List<UserModel>> listUsers() {
		System.out.println("Passed here");

		return ResponseEntity.ok(userService.listUsers());

	}
    
    
    
    
    @GetMapping("/users/{userId}")
	public ResponseEntity<UserEntity> listUsers(@PathVariable Long userId) {
		System.out.println(userId);
		UserEntity user=userRepository.findById(userId).orElse(null);
		return ResponseEntity.ok(user); 

	}
    
    
}
