package com.myvisa.myvisa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Request {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String country;
    private LocalDate travel_date;

    private String status;

    public Request() {
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getStatus() {

        return status;
    }
    public void setStatus(String status) {

        this.status = status;
    }

    public LocalDate getTravel_date() {

        return travel_date;
    }

    public void setTravel_date(LocalDate travel_date) {

        this.travel_date = travel_date;
    }


    @Override
    public String toString() {
        return super.toString();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
