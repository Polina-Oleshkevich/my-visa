package com.myvisa.myvisa.dto;

import lombok.*;
@Data
public class ClientDto {
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String status;
}
