package com.example.AIRBNBCLONE.dto;

import java.util.List;

import lombok.*;

@Data
@AllArgsConstructor
public class HotelInfoDto {
    private HotelDto hotel;
    private List<RoomPriceResponseDto> rooms;
}
