package com.myvisa.myvisa.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ManagerDto {
    private Long id;
    private String first_name;
    private String last_name;
    private String fathers_name;
    private LocalDate date_birth;
    private LocalDate employment_date;
    private Integer phone;
    private String email;
    private String login;
    private String password;

}
