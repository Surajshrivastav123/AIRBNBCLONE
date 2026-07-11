package com.example.AIRBNBCLONE.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AIRBNBCLONE.entity.Hotel;
import com.example.AIRBNBCLONE.entity.Room;

public interface RoomRepository extends JpaRepository<Room,Long>{
    List<Room> findByHotel(Hotel hotel);
}
