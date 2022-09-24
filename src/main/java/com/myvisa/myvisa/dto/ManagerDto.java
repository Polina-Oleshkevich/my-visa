package com.myvisa.myvisa.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ManagerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateBirth;
    private LocalDate employmentDate;
    private String phone;
    private String email;
    private String status;
}
