package com.example.AIRBNBCLONE.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AIRBNBCLONE.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory,Long>{
    
}
