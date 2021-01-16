package com.alfsimen.dnb.reservations.controller;

import com.alfsimen.dnb.reservations.dto.RoomDto;
import com.alfsimen.dnb.reservations.service.RoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {

    private final RoomService roomService;

    public AdminController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping(path = "/admin/room")
    public List<RoomDto> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping(path = "/admin/floor/{id}")
    public List<RoomDto> getRoomByFloorId(@PathVariable("id") Long id) {
        return roomService.getRoomByFloorId(id);
    }
}
