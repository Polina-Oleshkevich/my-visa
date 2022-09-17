package com.myvisa.myvisa.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReguestDto {
    private Long id;
    private String status;
    private LocalDate travel_date;
    private String documents;
    private LocalDate payment_date;
}
