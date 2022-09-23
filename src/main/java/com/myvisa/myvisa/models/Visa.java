package com.myvisa.myvisa.models;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
//@Table(schema="public", name="visa")
public class Visa {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String visa_type;
    private Integer visa_term;

    @Column(name = "purpose")
    private String purpose;
    @Column(name = "country")
    private String country;

    private Integer price;

    @OneToOne(fetch = FetchType.EAGER)
    private Admin admin;

    @OneToOne(fetch = FetchType.EAGER)
    private Center center;

    private String status;

}
