package com.alfsimen.dnb.reservations.dto;

import lombok.Builder;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
@Builder
public class RoomDto {

    String name;
    Integer floorNumber;
    @Builder.Default
    List<ReservationDto> reservations = new ArrayList<>();
    Integer capacity;
    boolean videoConference;
    boolean drawingBoard;
}
