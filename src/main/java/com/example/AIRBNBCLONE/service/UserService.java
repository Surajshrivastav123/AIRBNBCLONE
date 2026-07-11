package com.example.AIRBNBCLONE.service;

import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.AIRBNBCLONE.dto.LoginDto;
import com.example.AIRBNBCLONE.dto.SignUpDto;
import com.example.AIRBNBCLONE.dto.UserDto;
import com.example.AIRBNBCLONE.entity.User;
import com.example.AIRBNBCLONE.entity.enums.Role;
import com.example.AIRBNBCLONE.exception.ResourceNotFoundException;
import com.example.AIRBNBCLONE.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
     private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

     public UserDto createAccount(SignUpDto signUpDto){
        Optional<User> existingUser=userRepository.findByEmail(signUpDto.getEmail());
        if(existingUser.isPresent()){
            throw new IllegalArgumentException("User already exists with email: " + signUpDto.getEmail());
        }   
        
       
        User usercreate=modelMapper.map(signUpDto, User.class);
        usercreate.setRoles(Set.of(Role.GUEST));
        usercreate.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        userRepository.save(usercreate);
        return modelMapper.map(usercreate,UserDto.class);
    }
    public String[] loginUser(LoginDto loginDto){
        Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
            loginDto.getEmail(), loginDto.getPassword()));
            User user=(User) authentication.getPrincipal();

        String[] arr = new String[2];
        arr[0] = jwtService.generateAccessToken(user);
        arr[1] = jwtService.generateRefreshToken(user);

        return arr;
    }
    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found with Id: "+id));
    }
    
    
}
