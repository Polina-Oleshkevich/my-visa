package com.myvisa.myvisa.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@Entity
//@Table(schema="public", name="manager")
public class Manager {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String first_name;
    private String last_name;
    private LocalDate date_birth;
    private LocalDate employment_date;

    @Column(name = "phone")
    private Integer phone;

    @Column(name = "email")
    private String email;

    @OneToOne(fetch = FetchType.EAGER)
    private Center center;

    private String status;


}
