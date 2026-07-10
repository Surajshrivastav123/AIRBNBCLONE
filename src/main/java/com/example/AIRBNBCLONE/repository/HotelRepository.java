package com.example.AIRBNBCLONE.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AIRBNBCLONE.entity.Hotel;
import com.example.AIRBNBCLONE.entity.User;

public interface HotelRepository extends JpaRepository<Hotel,Long>{
    List<Hotel> findByOwner(User user);
    
}
