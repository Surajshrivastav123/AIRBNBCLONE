package com.example.AIRBNBCLONE.dto;

import java.time.LocalDate;

import com.example.AIRBNBCLONE.entity.enums.Gender;

import lombok.Data;

@Data
public class GuestDto {
    private Long id;
    private String name;
    private Gender gender;
    private LocalDate dateOfBirth;
}
