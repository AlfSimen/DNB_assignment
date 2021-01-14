package com.alfsimen.dnb.reservations.converter;

import com.alfsimen.dnb.reservations.domain.Employee;
import com.alfsimen.dnb.reservations.domain.Reservation;
import com.alfsimen.dnb.reservations.domain.Team;
import com.alfsimen.dnb.reservations.dto.ReservationDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ReservationConverter {

    public ReservationDto convert(Reservation reservation) {
        if (reservation == null) {
            return null;
        }

        return ReservationDto.builder()
                .employee(Optional.ofNullable(reservation.getEmployee()).map(Employee::getUsername).orElse(null))
                .teamName(Optional.ofNullable(reservation.getEmployee()).map(Employee::getTeam).map(Team::getName).orElse(null))
                .reservedFrom(reservation.getReservedFrom())
                .reservedTo(reservation.getReservedTo())
                .confirmedArrival(reservation.isConfirmedArrival())
                .build();
    }
}
