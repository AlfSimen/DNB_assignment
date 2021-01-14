package com.alfsimen.dnb.reservations.dto;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class ReservationDto {

    String employee;
    String teamName;
    LocalDateTime reservedFrom;
    LocalDateTime reservedTo;
    boolean confirmedArrival;
}
