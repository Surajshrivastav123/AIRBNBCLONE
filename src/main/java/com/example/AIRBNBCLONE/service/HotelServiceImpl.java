package com.example.AIRBNBCLONE.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.AIRBNBCLONE.dto.HotelDto;
import com.example.AIRBNBCLONE.entity.Hotel;
import com.example.AIRBNBCLONE.exception.ResourceNotFoundException;
import com.example.AIRBNBCLONE.repository.HotelRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService{
    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;

    @Override
    public HotelDto createNewHotel(HotelDto hotelDto) {
        
         Hotel hotel=modelMapper.map(hotelDto, Hotel.class);
         Hotel saveHotel=hotelRepository.save(hotel);
         return modelMapper.map(saveHotel, HotelDto.class);
    }

    @Override
    public HotelDto getHotelById(Long Id) {
        Hotel hotel=hotelRepository
        .findById(Id)
        .orElseThrow(()->new ResourceNotFoundException("Hotel Not found"));
        return modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    public HotelDto updateHotelById(Long Id, HotelDto hotelDto) {
      Hotel hotel=hotelRepository.findById(Id).orElseThrow(()->new ResourceNotFoundException("Hotel Not Found"));
      modelMapper.map(hotelDto, hotel);
      hotel.setId(Id);
      hotel=hotelRepository.save(hotel);
      return modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    public void deleteHotelById(Long Id) {
        hotelRepository.findById(Id).orElseThrow(()->new ResourceNotFoundException("Hotel Not Found With ID: "+Id));
        hotelRepository.deleteById(Id);
    }

    @Override
    public void activateHotel(Long hotelId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'activateHotel'");
    }

    @Override
    public List<HotelDto> getAllHotels() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllHotels'");
    }
    
}
