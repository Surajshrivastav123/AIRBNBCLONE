package com.example.AIRBNBCLONE.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AIRBNBCLONE.dto.RoomDto;
import com.example.AIRBNBCLONE.service.RoomService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/admin/rooms")
@RequiredArgsConstructor
public class RoomAdminController {
    
    private final RoomService roomService;

    @PostMapping("/create?hotelId={hotelId}")
    public ResponseEntity<RoomDto> createRoom(@RequestBody RoomDto roomDto, @RequestParam Long hotelId) {
        RoomDto createdRoom = roomService.createRoom(roomDto, hotelId);
        return ResponseEntity.ok(createdRoom);
    }
    @GetMapping("/{roomId}")
    public String getMethodName(@PathVariable String roomId) {
        return new String();
    }
    
    
    
    
}
