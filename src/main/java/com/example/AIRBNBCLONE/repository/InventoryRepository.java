package com.example.AIRBNBCLONE.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AIRBNBCLONE.entity.Inventory;
import com.example.AIRBNBCLONE.entity.Room;

public interface InventoryRepository extends JpaRepository<Inventory,Long>{
    void deleteByRoom(Room room);
}
