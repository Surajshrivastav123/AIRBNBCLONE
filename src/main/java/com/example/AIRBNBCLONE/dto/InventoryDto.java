package com.example.AIRBNBCLONE.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.AIRBNBCLONE.entity.Hotel;
import com.example.AIRBNBCLONE.entity.Room;

import lombok.Data;

@Data
public class InventoryDto {
    private Long id;
    private Hotel hotel;
    private Room room;
    private LocalDate date;
    private Integer bookedCount;
    private Integer reservedCount;
    private Integer totalCount;
    private BigDecimal surgeFactor;
    private BigDecimal price;
    private String city;
    private Boolean closed;
}
