package com.example.AIRBNBCLONE.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.AIRBNBCLONE.dto.RoomDto;
import com.example.AIRBNBCLONE.entity.Hotel;
import com.example.AIRBNBCLONE.entity.Room;
import com.example.AIRBNBCLONE.repository.HotelRepository;
import com.example.AIRBNBCLONE.repository.RoomRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final ModelMapper modelMapper;
    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    @Override
    public RoomDto createRoom(RoomDto roomDto, Long hotelId) {
       Hotel hotel=hotelRepository.findById(hotelId).orElseThrow(()->new IllegalArgumentException("Hotel not found with Id: "+hotelId));
       Room room=modelMapper.map(roomDto, Room.class);
       room.setHotel(hotel);
       Room savedRoom = roomRepository.save(room);
       return modelMapper.map(savedRoom, RoomDto.class);
    }

    @Override
    public RoomDto getRoomById(Long roomId) {
        Room room=roomRepository.findById(roomId).orElseThrow(()->new IllegalArgumentException("Room not found with Id: "+roomId));
        return modelMapper.map(room, RoomDto.class);
    }

    @Override
    public void deleteRoomById(Long roomId) {
        Room room=roomRepository.findById(roomId).orElseThrow(()->new IllegalArgumentException("Room not found with Id: "+roomId));
         roomRepository.delete(room);
    }

    @Override
    public RoomDto updateRoomById(Long roomId, RoomDto roomDto) {
        Room existingRoom=roomRepository.findById(roomId).orElseThrow(()->new IllegalArgumentException("Room not found with Id: "+roomId));
        modelMapper.map(roomDto, existingRoom);
        existingRoom.setId(roomId);
        Room updatedRoom=roomRepository.save(existingRoom);
        return modelMapper.map(updatedRoom, RoomDto.class);
    }

    @Override
    public List<RoomDto> getAllRoomsByHotelId(Long hotelId) {
        Hotel hotel=hotelRepository.findById(hotelId).orElseThrow(()->new IllegalArgumentException("Hotel not found with Id: "+hotelId));
        List<Room> rooms=roomRepository.findByHotel(hotel);
        return rooms.stream().map(room->modelMapper.map(room, RoomDto.class)).collect(java.util.stream.Collectors.toList());
    }
    }
    

