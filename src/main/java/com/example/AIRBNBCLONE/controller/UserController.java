package com.example.AIRBNBCLONE.controller;

import com.example.AIRBNBCLONE.service.UserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AIRBNBCLONE.dto.LoginDto;
import com.example.AIRBNBCLONE.dto.LoginResponseDto;
import com.example.AIRBNBCLONE.dto.SignUpDto;
import com.example.AIRBNBCLONE.dto.UserDto;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<UserDto> createAccount(@RequestBody SignUpDto signUpDto) {
       UserDto userDto= userService.createAccount(signUpDto);
       return new ResponseEntity<>(userDto,HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto loginDto){
       String[] tokens=userService.loginUser(loginDto);
       return ResponseEntity.ok(new LoginResponseDto(tokens[0]));
    }
    
    
}
