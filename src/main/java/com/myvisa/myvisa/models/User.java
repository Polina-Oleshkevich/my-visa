package com.myvisa.myvisa.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
        public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

}
