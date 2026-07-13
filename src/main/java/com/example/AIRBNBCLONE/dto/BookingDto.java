package com.example.AIRBNBCLONE.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import com.example.AIRBNBCLONE.entity.enums.BookingStatus;

import lombok.Data;

@Data
public class BookingDto {
    private Long id;
    private Integer roomsCount;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private BookingStatus bookingStatus;
    private Set<GuestDto> guests;
    private BigDecimal amount;
}
