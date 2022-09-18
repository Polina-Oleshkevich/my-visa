package com.myvisa.myvisa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Visa {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String visa_type;
    private String visa_term;
    private String purpose;
    private String country;
    private Integer price;
    private String status;

    public Visa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVisa_type() {
        return visa_type;
    }

    public void setVisa_type(String visa_type) {
        this.visa_type = visa_type;
    }

    public String getVisa_term() {
        return visa_term;
    }

    public void setVisa_term(String visa_term) {
        this.visa_term = visa_term;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
