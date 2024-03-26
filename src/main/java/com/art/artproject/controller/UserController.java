package com.art.artproject.controller;

import com.art.artproject.dto.NewUserRequest;
import com.art.artproject.domain.TalentResponse;
import com.art.artproject.dto.UserResponse;
import com.art.artproject.dto.UserValidateRequest;
import com.art.artproject.entity.User;
import com.art.artproject.entity.UserInfo;
import com.art.artproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<TalentResponse<UserResponse>> registerUser(@RequestBody NewUserRequest request){
        TalentResponse<UserResponse> response=
                new TalentResponse<>(userService.registerUser(request), "Successfully registered", HttpStatus.CREATED );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PostMapping("/validate")
    public ResponseEntity<UserInfo> validateUser(@RequestBody UserValidateRequest request){
        return ResponseEntity.ok(userService.validateUser(request));
    }

    @GetMapping
    public ResponseEntity<List<User>> showUser(){
        List<User> users=userService.showAll();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
}
