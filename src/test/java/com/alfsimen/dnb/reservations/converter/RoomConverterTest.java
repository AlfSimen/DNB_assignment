package com.alfsimen.dnb.reservations.converter;

import com.alfsimen.dnb.reservations.domain.Floor;
import com.alfsimen.dnb.reservations.domain.Reservation;
import com.alfsimen.dnb.reservations.domain.Room;
import com.alfsimen.dnb.reservations.dto.ReservationDto;
import com.alfsimen.dnb.reservations.dto.RoomDto;
import org.assertj.core.api.SoftAssertions;
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
class RoomConverterTest {

    @Mock
    private ReservationConverter reservationConverter;

    @InjectMocks
    private RoomConverter roomConverter;

    @Test
    void convertNull() {
        RoomDto result = roomConverter.convert(null);

        assertThat(result).isNull();
    }

    @Test
    void convert() {
        List<Reservation> reservations = new ArrayList<>();
        Reservation reservation = Reservation.builder().build();
        reservations.add(reservation);

        String name = "Room 1337";
        int floorNumber = 42;
        int capacity = 4;
        boolean videoConference = false;
        boolean drawingBoard = true;
        Room room = Room.builder()
                .name(name)
                .floor(Floor.builder()
                        .floorNumber(floorNumber)
                        .build())
                .reservations(reservations)
                .capacity(capacity)
                .videoConference(videoConference)
                .drawingBoard(drawingBoard)
                .build();

        ReservationDto reservationDto = ReservationDto.builder().build();
        doReturn(reservationDto).when(reservationConverter).convert(reservation);

        RoomDto result = roomConverter.convert(room);

        assertThat(result).isNotNull();

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(result.getName()).isEqualTo(name);
            softly.assertThat(result.getFloorNumber()).isEqualTo(floorNumber);
            softly.assertThat(result.getReservations()).containsExactly(reservationDto);
            softly.assertThat(result.getCapacity()).isEqualTo(capacity);
            softly.assertThat(result.isVideoConference()).isEqualTo(videoConference);
            softly.assertThat(result.isDrawingBoard()).isEqualTo(drawingBoard);
        });
    }
}