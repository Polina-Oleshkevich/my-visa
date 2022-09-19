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
    private LocalDate travel_date;
    private String documents;
    private LocalDate payment_date;
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

    public String getDocuments() {

        return documents;
    }

    public void setDocuments(String documents) {

        this.documents = documents;
    }

    public LocalDate getPayment_date() {

        return payment_date;
    }

    public void setPayment_date(LocalDate payment_date) {

        this.payment_date = payment_date;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
