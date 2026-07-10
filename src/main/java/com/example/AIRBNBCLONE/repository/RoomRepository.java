package com.example.AIRBNBCLONE.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AIRBNBCLONE.entity.Room;

public interface RoomRepository extends JpaRepository<Room,Long>{
    
}
