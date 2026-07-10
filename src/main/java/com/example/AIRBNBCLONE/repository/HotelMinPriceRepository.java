package com.example.AIRBNBCLONE.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AIRBNBCLONE.entity.HotelMinPrice;

public interface HotelMinPriceRepository extends JpaRepository<HotelMinPrice,Long>{
    
}
