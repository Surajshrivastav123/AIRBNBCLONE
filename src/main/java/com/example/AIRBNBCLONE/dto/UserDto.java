package com.example.AIRBNBCLONE.dto;


import lombok.Data;

@Data
public class UserDto {
    private Long Id;
    private String email;
    private String name;
    private String gender;
    private String DateOfBirth;
}
