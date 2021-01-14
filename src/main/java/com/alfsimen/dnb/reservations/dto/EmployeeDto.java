package com.alfsimen.dnb.reservations.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class EmployeeDto {

    String username;
    TeamDto team;
}
