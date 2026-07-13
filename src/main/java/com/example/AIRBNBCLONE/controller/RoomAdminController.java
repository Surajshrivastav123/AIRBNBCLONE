package com.example.AIRBNBCLONE.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AIRBNBCLONE.dto.RoomDto;
import com.example.AIRBNBCLONE.service.RoomService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




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
    public ResponseEntity<RoomDto> getRoomById(@PathVariable Long roomId) {
        RoomDto room = roomService.getRoomById(roomId);
        return ResponseEntity.ok(room);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomDto> putMethodName(@PathVariable Long id, @RequestBody RoomDto entity) {
        RoomDto updatedRoom = roomService.updateRoomById(id, entity);
        return ResponseEntity.ok(updatedRoom);
    }
    @DeleteMapping("/{roomId}")
    public ResponseEntity<Void> deleteRoomById(@PathVariable Long roomId) {
        roomService.deleteRoomById(roomId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<RoomDto>> getAllRoomsByHotelId(@PathVariable Long hotelId) {
        List<RoomDto> rooms = roomService.getAllRoomsByHotelId(hotelId);
        return ResponseEntity.ok(rooms);
    }
    

}