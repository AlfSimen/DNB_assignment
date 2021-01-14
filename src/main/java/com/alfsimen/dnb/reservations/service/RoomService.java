package com.alfsimen.dnb.reservations.service;

import com.alfsimen.dnb.reservations.converter.RoomConverter;
import com.alfsimen.dnb.reservations.dto.RoomDto;
import com.alfsimen.dnb.reservations.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoomConverter roomConverter;

    public RoomService(RoomRepository roomRepository, RoomConverter roomConverter) {
        this.roomRepository = roomRepository;
        this.roomConverter = roomConverter;
    }

    public List<RoomDto> getAllRooms() {
        return roomRepository.findAll()
                .stream()
                .map(roomConverter::convert)
                .collect(Collectors.toList());
    }

    public List<RoomDto> getRoomByFloorId(Long id) {
        return roomRepository.getAllByFloor_Id(id)
                .stream()
                .map(roomConverter::convert)
                .collect(Collectors.toList());
    }
}
