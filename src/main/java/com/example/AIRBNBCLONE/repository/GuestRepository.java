package com.example.AIRBNBCLONE.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AIRBNBCLONE.entity.Guest;
import com.example.AIRBNBCLONE.entity.User;

public interface GuestRepository extends JpaRepository<Guest,Long>{

    List<Guest> findByUser(User user);

    
}
