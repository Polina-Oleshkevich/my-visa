package com.myvisa.myvisa.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CenterDto {
    private Long id;
    private String city;
    private String address;
    private Integer phone;
    private String email;
    private LocalDate open_data;
    private String status;
}
