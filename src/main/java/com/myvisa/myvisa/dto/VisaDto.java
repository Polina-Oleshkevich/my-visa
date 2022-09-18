package com.myvisa.myvisa.dto;

import lombok.Data;

@Data
public class VisaDto {
    private Long id;
    private String visa_type;
    private String visa_term;
    private String purpose;
    private String country;
    private Integer price;
    private String status;
}
