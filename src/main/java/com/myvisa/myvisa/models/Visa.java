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

    @Column (name = "visa_type")
    private String visaType;

    @Column (name = "visa_term")
    private Integer visaTerm;
    private String purpose;
    private String country;
    private Integer price;

    @OneToOne(fetch = FetchType.EAGER)
    private Center center;

    private String status;

}
