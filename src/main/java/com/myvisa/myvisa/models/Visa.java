package com.myvisa.myvisa.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
public class Visa {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String visa_type;
    private Integer visa_term;
    private String purpose;
    private String country;
    private Integer price;

    @OneToOne(fetch = FetchType.EAGER)
    private Admin admin;

    @OneToOne(fetch = FetchType.EAGER)
    private Center center;

    private String status;

}
