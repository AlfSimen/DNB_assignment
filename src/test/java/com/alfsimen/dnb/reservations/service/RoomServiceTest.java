package com.alfsimen.dnb.reservations.service;

import com.alfsimen.dnb.reservations.converter.RoomConverter;
import com.alfsimen.dnb.reservations.domain.Floor;
import com.alfsimen.dnb.reservations.domain.Room;
import com.alfsimen.dnb.reservations.dto.RoomDto;
import com.alfsimen.dnb.reservations.repository.RoomRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class RoomServiceTest {

    @Mock
    private RoomRepository roomRepository;
    @Mock
    private RoomConverter roomConverter;

    @InjectMocks
    private RoomService roomService;

    @Test
    void getAllRooms() {
        ArrayList<Room> rooms = new ArrayList<>();
        Room room = Room.builder()
                .name("Room 42")
                .floor(Floor.builder()
                        .floorNumber(3)
                        .build())
                .reservations(new ArrayList<>())
                .capacity(10)
                .videoConference(false)
                .drawingBoard(false)
                .build();
        rooms.add(room);
        doReturn(rooms).when(roomRepository).findAll();

        RoomDto roomDto = RoomDto.builder().build();
        doReturn(roomDto).when(roomConverter).convert(room);

        List<RoomDto> result = roomService.getAllRooms();

        assertThat(result).containsExactly(roomDto);
    }

    @Test
    void getRoomByFloorId() {
        long floorId = 9001L;

        ArrayList<Room> rooms = new ArrayList<>();
        Room room = Room.builder()
                .name("Room 42")
                .floor(Floor.builder()
                        .floorNumber(3)
                        .build())
                .reservations(new ArrayList<>())
                .capacity(10)
                .videoConference(false)
                .drawingBoard(false)
                .build();
        rooms.add(room);
        doReturn(rooms).when(roomRepository).getAllByFloor_Id(floorId);

        RoomDto roomDto = RoomDto.builder().build();
        doReturn(roomDto).when(roomConverter).convert(room);

        List<RoomDto> result = roomService.getRoomByFloorId(floorId);

        assertThat(result).containsExactly(roomDto);
    }
}