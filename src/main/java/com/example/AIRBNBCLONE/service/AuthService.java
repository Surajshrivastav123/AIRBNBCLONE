package com.example.AIRBNBCLONE.service;

import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.AIRBNBCLONE.dto.LoginDto;
import com.example.AIRBNBCLONE.dto.LoginResponseDto;
import com.example.AIRBNBCLONE.dto.SignUpDto;
import com.example.AIRBNBCLONE.dto.UserDto;
import com.example.AIRBNBCLONE.entity.User;
import com.example.AIRBNBCLONE.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService{
    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }
   
    

    
    
}
