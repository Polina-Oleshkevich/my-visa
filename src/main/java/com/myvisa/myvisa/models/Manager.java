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
    @Column (name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

    @Column (name = "date_birth")
    private LocalDate dateBirth;

    @Column (name = "employment_date")
    private LocalDate employmentDate;

    private String phone;
    private String email;

    @OneToOne(fetch = FetchType.EAGER)
    private Center center;

    private String status;


}
