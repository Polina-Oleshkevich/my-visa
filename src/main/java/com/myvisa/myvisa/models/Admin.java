package com.myvisa.myvisa.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "first_name")
    private String firsName;

    @Column (name = "last_name")
    private String lastName;

    private String email;
    private String status;
}

