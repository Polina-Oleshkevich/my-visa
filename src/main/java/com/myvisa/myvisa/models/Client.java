package com.myvisa.myvisa.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Long id;
    @Column (name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

    @Column (name = "date_birth")
    private LocalDate dateBirth;

    private String email;
    private String status;
}
