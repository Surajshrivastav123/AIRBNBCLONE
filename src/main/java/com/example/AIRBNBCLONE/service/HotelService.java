package com.example.AIRBNBCLONE.service;

import java.util.List;

import com.example.AIRBNBCLONE.dto.HotelDto;

public interface HotelService {
    HotelDto createNewHotel(HotelDto hotelDto);
    HotelDto getHotelById(Long Id);
    HotelDto updateHotelById(Long Id,HotelDto hotelDto);
    void deleteHotelById(Long Id);
    void activateHotel(Long hotelId);
    List<HotelDto> getAllHotels();
}
