package com.myvisa.myvisa.dto;

import lombok.Data;

@Data
public class VisaDto {
    private Long id;
    private String visaType;
    private String visaTerm;
    private String purpose;
    private String country;
    private Integer price;
    private String status;
}
