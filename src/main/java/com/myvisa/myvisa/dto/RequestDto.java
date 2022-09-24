package com.myvisa.myvisa.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RequestDto {
    private Long id;

    private LocalDate visitDate;
    private LocalDate travelDate;
    private String status;
}
