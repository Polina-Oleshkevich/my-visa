package com.myvisa.myvisa.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@Entity
@Table(schema="public", name="client")
public class Client {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Long id;
    private String first_name;
    private String last_name;
    private LocalDate date_birth;

    @Column(name = "email")
    private String email;

    private String status;

}
