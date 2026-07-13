package com.example.AIRBNBCLONE.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AIRBNBCLONE.dto.InventoryDto;
import com.example.AIRBNBCLONE.dto.UpdateInventoryRequestDto;
import com.example.AIRBNBCLONE.entity.Inventory;
import com.example.AIRBNBCLONE.entity.Room;
import com.example.AIRBNBCLONE.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;

    @Override
    public void initializeRoomForAYear(Room room) {
        LocalDate today=LocalDate.now();
        LocalDate enDate=today.plusYears(1);
        for(;!today.isAfter(enDate);today=today.plusDays(1)){
            Inventory inventory=Inventory.builder()
                                   .hotel(room.getHotel())
                                   .room(room)
                                   .bookedCount(0)
                                   .totalCount(0)
                                   .city(room.getHotel().getCity())
                                   .date(today)
                                   .price(room.getBasePrice())
                                   .surgeFactor(BigDecimal.ONE)
                                   .totalCount(room.getTotalCount())
                                   .closed(false)
                                   .build();
            inventoryRepository.save(inventory);
        }
    }

    @Override
    public void deleteAllInventory(Room room) {
      inventoryRepository.deleteByRoom(room);
    }

  

    @Override
    public List<InventoryDto> getAllInventoryByRoom(Long roomId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllInventoryByRoom'");
    }


    @Override
    public void updateInventory(Long roomId, UpdateInventoryRequestDto updateInventoryRequestDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateInventory'");
    }
    
}
