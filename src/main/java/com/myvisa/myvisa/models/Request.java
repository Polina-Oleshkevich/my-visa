package com.myvisa.myvisa.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@Entity

public class Request {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column (name = "visit_date")
    private LocalDate visitDate;

    @Column (name = "travel_date")
    private LocalDate travelDate;

    @OneToOne(fetch = FetchType.EAGER)
    private Client client;

    @OneToOne(fetch = FetchType.EAGER)
    private Center center;

    @OneToOne(fetch = FetchType.EAGER)
    private Manager manager;

    private String status;
}
