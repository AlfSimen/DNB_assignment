package com.alfsimen.dnb.reservations.converter;

import com.alfsimen.dnb.reservations.domain.Floor;
import com.alfsimen.dnb.reservations.domain.Room;
import com.alfsimen.dnb.reservations.dto.ReservationDto;
import com.alfsimen.dnb.reservations.dto.RoomDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class RoomConverter {

    private final ReservationConverter reservationConverter;

    public RoomConverter(ReservationConverter reservationConverter) {
        this.reservationConverter = reservationConverter;
    }

    public RoomDto convert(Room room) {
        if (room == null) {
            return null;
        }

        List<ReservationDto> reservationDtoList = room.getReservations()
                .stream()
                .map(reservationConverter::convert)
                .collect(Collectors.toList());

        return RoomDto.builder()
                .name(room.getName())
                .floorNumber(Optional.ofNullable(room.getFloor()).map(Floor::getFloorNumber).orElse(null))
                .reservations(reservationDtoList)
                .capacity(room.getCapacity())
                .videoConference(room.isVideoConference())
                .drawingBoard(room.isDrawingBoard())
                .build();
    }
}
