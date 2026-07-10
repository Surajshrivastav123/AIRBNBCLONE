package com.example.AIRBNBCLONE.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AIRBNBCLONE.entity.Booking;
import com.example.AIRBNBCLONE.entity.Hotel;
import com.example.AIRBNBCLONE.entity.User;

public interface BookingRepository extends JpaRepository<Booking,Long>{
    Optional<Booking> findByPaymentSessionId(String sessionId);
    List<Booking> findByHotel(Hotel hotel);
    List<Booking> findByUser(User user);
    List<Booking> findByHotelAndCreatedAtBetween(Hotel hotel, LocalDateTime startDateTime, LocalDateTime endDateTime);
}
