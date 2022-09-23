package com.myvisa.myvisa.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Center {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String address;
    private Integer phone;
    private String email;
    private LocalDate open_data;

    @OneToOne(fetch = FetchType.EAGER)
    private Admin admin;

    private String status;
}

