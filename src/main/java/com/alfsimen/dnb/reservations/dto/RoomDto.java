package com.alfsimen.dnb.reservations.dto;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class RoomDto {

    String name;
    Integer floorNumber;
    List<ReservationDto> reservations;
    Integer capacity;
    boolean videoConference;
    boolean drawingBoard;
}
