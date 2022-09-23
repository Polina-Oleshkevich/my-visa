package com.myvisa.myvisa.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@Entity
public class Manager {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String first_name;
    private String last_name;
    private LocalDate date_birth;
    private LocalDate employment_date;
    private Integer phone;
    private String email;

    @OneToOne(fetch = FetchType.EAGER)
    private Center center;

    private String status;


}
