package com.example.AIRBNBCLONE.service;

import java.util.List;

import com.example.AIRBNBCLONE.dto.RoomDto;

public interface RoomService {
    RoomDto createRoom(RoomDto roomDto, Long hotelId);

    RoomDto getRoomById(Long roomId);

    void deleteRoomById(Long roomId);

    RoomDto updateRoomById(Long roomId, RoomDto roomDto);

    List<RoomDto> getAllRoomsByHotelId(Long hotelId);
}
