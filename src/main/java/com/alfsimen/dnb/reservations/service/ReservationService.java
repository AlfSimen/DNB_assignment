package com.alfsimen.dnb.reservations.service;

import com.alfsimen.dnb.reservations.domain.Reservation;
import com.alfsimen.dnb.reservations.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservations() {
        // TODO ALF: add dtos and converters
        return reservationRepository.findAllByActiveIsTrue();
    }
}
