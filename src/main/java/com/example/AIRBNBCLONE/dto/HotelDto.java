package com.example.AIRBNBCLONE.dto;

import com.example.AIRBNBCLONE.entity.HotelContactInfo;

import lombok.Data;

@Data
public class HotelDto {
    private Long Id;
    private String name;
    private String city;
    private String[] photos;
    private String[] amenities;
    private Boolean active;
    private HotelContactInfo hotelContactInfo;
}
