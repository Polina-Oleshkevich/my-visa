package com.myvisa.myvisa.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@Entity
@Table(schema="public", name="center")
public class Center {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String address;
    private Integer phone;
    private String email;

    @Column(name = "open_data")
    private LocalDate open_data;

    @OneToOne(fetch = FetchType.EAGER)
    private Admin admin;

    private String status;
}

