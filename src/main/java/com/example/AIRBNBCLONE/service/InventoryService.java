package com.example.AIRBNBCLONE.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.AIRBNBCLONE.dto.HotelPriceResponseDto;
import com.example.AIRBNBCLONE.dto.HotelSearchRequest;
import com.example.AIRBNBCLONE.dto.InventoryDto;
import com.example.AIRBNBCLONE.dto.UpdateInventoryRequestDto;
import com.example.AIRBNBCLONE.entity.Room;

public interface InventoryService {
    void initializeRoomForAYear(Room room);
    void deleteAllInventory(Room room);
    List<InventoryDto> getAllInventoryByRoom(Long roomId);
    void updateInventory(Long roomId,UpdateInventoryRequestDto updateInventoryRequestDto);
    Page<HotelPriceResponseDto> searchHotels(HotelSearchRequest HotelSearchRequest);
}
