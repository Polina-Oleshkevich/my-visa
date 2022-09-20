package com.myvisa.myvisa.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@Entity
@Table(schema="public", name="request")
public class Request {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "visit_date")
    private LocalDate visit_date;

    @Column(name = "travel_date")
    private LocalDate travel_date;

    @OneToOne(fetch = FetchType.EAGER)
    private Client client;

    @OneToOne(fetch = FetchType.EAGER)
    private Center center;

    @OneToOne(fetch = FetchType.EAGER)
    private Manager manager;

    private String status;

}
