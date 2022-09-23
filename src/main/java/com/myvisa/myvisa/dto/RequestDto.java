package com.myvisa.myvisa.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RequestDto {
    private Long id;

    private LocalDate visit_date;
    private LocalDate travel_date;
    private String status;
}
