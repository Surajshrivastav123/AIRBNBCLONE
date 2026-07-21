package com.example.AIRBNBCLONE.dto;

import com.example.AIRBNBCLONE.entity.HotelContactInfo;

import lombok.Data;

@Data
public class HotelPriceResponseDto {
    private Long Id;
    private String name;
    private String city;
    private String[] amenities;
    private String[] photos;
    private HotelContactInfo hotelContactInfo;
    private Double price;
}
