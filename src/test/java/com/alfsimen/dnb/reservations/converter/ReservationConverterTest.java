package com.alfsimen.dnb.reservations.converter;

import com.alfsimen.dnb.reservations.domain.Employee;
import com.alfsimen.dnb.reservations.domain.Floor;
import com.alfsimen.dnb.reservations.domain.Reservation;
import com.alfsimen.dnb.reservations.domain.Room;
import com.alfsimen.dnb.reservations.domain.Team;
import com.alfsimen.dnb.reservations.dto.ReservationDto;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ReservationConverterTest {

    @InjectMocks
    private ReservationConverter reservationConverter;

    @Test
    void convertNull() {
        ReservationDto result = reservationConverter.convert(null);

        assertThat(result).isNull();
    }

    @Test
    void convert() {
        String username = "alfsimen";
        String teamName = "SuperTeam";
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime reservedFrom = now.minusHours(1);
        boolean confirmedArrival = true;
        Reservation reservation = Reservation.builder()
                .room(Room.builder()
                        .name("Some Room")
                        .floor(Floor.builder()
                                .floorNumber(42)
                                .build())
                        .build())
                .employee(Employee.builder()
                        .username(username)
                        .team(Team.builder()
                                .name(teamName)
                                .build())
                        .build())
                .reservedFrom(reservedFrom)
                .reservedTo(now)
                .confirmedArrival(confirmedArrival)
                .active(true)
                .build();

        ReservationDto result = reservationConverter.convert(reservation);

        assertThat(result).isNotNull();

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(result.getEmployee()).isEqualTo(username);
            softly.assertThat(result.getTeamName()).isEqualTo(teamName);
            softly.assertThat(result.getReservedFrom()).isEqualTo(reservedFrom);
            softly.assertThat(result.getReservedTo()).isEqualTo(now);
            softly.assertThat(result.isConfirmedArrival()).isEqualTo(confirmedArrival);
        });
    }
}