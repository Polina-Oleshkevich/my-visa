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
    private LocalDate visit_date;
    private LocalDate travel_date;
    private Integer client_id;
    private Integer center_id;
    private Integer manager_id;
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

    public LocalDate getVisit_date() {
        return visit_date;
    }

    public void setVisit_date(LocalDate visit_date) {
        this.visit_date = visit_date;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public Integer getCenter_id() {
        return center_id;
    }

    public void setCenter_id(Integer center_id) {
        this.center_id = center_id;
    }

    public Integer getManager_id() {
        return manager_id;
    }

    public void setManager_id(Integer manager_id) {
        this.manager_id = manager_id;
    }
}
