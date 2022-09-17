package com.myvisa.myvisa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Center {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String city;
    private String address;
    private Integer phone;
    private String email;
    private Date open_data;
    private Date close_data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getOpen_data() {
        return open_data;
    }

    public void setOpen_data(Date open_data) {
        this.open_data = open_data;
    }

    public Date getClose_data() {
        return close_data;
    }

    public void setClose_data(Date close_data) {
        this.close_data = close_data;
    }
}
