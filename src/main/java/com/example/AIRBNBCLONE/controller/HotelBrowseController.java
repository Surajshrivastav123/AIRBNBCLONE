package com.example.AIRBNBCLONE.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AIRBNBCLONE.dto.HotelPriceResponseDto;
import com.example.AIRBNBCLONE.dto.HotelSearchRequest;
import com.example.AIRBNBCLONE.service.HotelService;
import com.example.AIRBNBCLONE.service.InventoryService;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelBrowseController {
    private final InventoryService inventoryService;
    private final HotelService hotelService;

   @GetMapping("/search")
   public ResponseEntity<Page<HotelPriceResponseDto>> searchHotels(@RequestBody HotelSearchRequest HotelSearchRequest) {
    var page=inventoryService.searchHotels(HotelSearchRequest);
    return ResponseEntity.ok(page);
   }

//    @GetMapping("/{hotelId}/info")
//    public ResponseEntity<HotelInfoDto> getMethodName(@PathVariable Long hotelId ) {
//    }
   
   
    
}
