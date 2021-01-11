package com.alfsimen.dnb.reservations.controller;

import com.alfsimen.dnb.reservations.domain.Reservation;
import com.alfsimen.dnb.reservations.service.ReservationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping(path = "/reservation")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }
}
