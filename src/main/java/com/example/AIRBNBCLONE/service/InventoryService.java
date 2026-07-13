package com.example.AIRBNBCLONE.service;

import java.util.List;

import com.example.AIRBNBCLONE.dto.InventoryDto;
import com.example.AIRBNBCLONE.entity.Room;

public interface InventoryService {
    void initializeRoomForAYear(Room room);
    void deleteAllInventory(Room room);
    List<InventoryDto> getAllInventoryByRoom(Long roomId);
}
