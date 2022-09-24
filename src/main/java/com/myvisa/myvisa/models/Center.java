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
    private String phone;
    private String email;

    @Column(name = "open_data")
    private LocalDate openData;

    @OneToOne(fetch = FetchType.EAGER)
    private Admin admin;

    private String status;
}

