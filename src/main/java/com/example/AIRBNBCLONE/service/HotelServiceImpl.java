package com.example.AIRBNBCLONE.service;

import com.example.AIRBNBCLONE.controller.UserController;
import com.example.AIRBNBCLONE.repository.InventoryRepository;
import com.example.AIRBNBCLONE.repository.RoomRepository;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import com.example.AIRBNBCLONE.dto.HotelDto;
import com.example.AIRBNBCLONE.entity.Hotel;
import com.example.AIRBNBCLONE.entity.Room;
import com.example.AIRBNBCLONE.entity.User;
import com.example.AIRBNBCLONE.exception.ResourceNotFoundException;
import com.example.AIRBNBCLONE.exception.UnAuthorisedException;
import com.example.AIRBNBCLONE.repository.HotelRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService{

    private final RoomRepository roomRepository;
    private final InventoryRepository inventoryRepository;
    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;
    private final InventoryService inventoryService;


    


    @Override
    public HotelDto createNewHotel(HotelDto hotelDto) {
        
         Hotel hotel=modelMapper.map(hotelDto, Hotel.class);
         User currentUser = (User) SecurityContextHolder.getContext()
            .getAuthentication().getPrincipal();
            System.out.println("Current User: " + currentUser);
         hotel.setOwner(currentUser);
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
    @Transactional
    public void deleteHotelById(Long Id) {
       Hotel hotel= hotelRepository.findById(Id).orElseThrow(()->new ResourceNotFoundException("Hotel Not Found With ID: "+Id));
       User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       if(!user.equals(hotel.getOwner())){
        throw new UnAuthorisedException("This user does not own this hotel with id: "+Id);
       }
       for(Room room:hotel.getRooms()){
         inventoryService.deleteAllInventory(room);
         roomRepository.deleteById(room.getId());
       }
        hotelRepository.deleteById(Id);
    }

    @Override
    @Transactional
    public void activateHotel(Long hotelId) {
        Hotel hotel=hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("Hotel Not found with this Id "+hotelId));
        User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(!user.equals(hotel.getOwner())){
          throw new UnAuthorisedException("This user does not own this hotel with id: "+hotelId);
        }
        hotel.setActive(true);
        for(Room room:hotel.getRooms()){
            inventoryService.initializeRoomForAYear(room);
        }
    }

    @Override
    public List<HotelDto> getAllHotels() {
       User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       List<Hotel> hotels=hotelRepository.findByOwner(user);
       return hotels
              .stream()
              .map((element)->modelMapper.map(element, HotelDto.class))
              .collect(Collectors.toList());
    }
    
}
