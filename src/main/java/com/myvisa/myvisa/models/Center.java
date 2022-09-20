package com.myvisa.myvisa.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(schema="public", name="center")
public class Center {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String city;
    private String address;
    private Integer phone;
    private String email;
    private LocalDate open_data;
       private String admin_id;
    private String status;

    public Center() {
    }

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

    public LocalDate getOpen_data() {
        return open_data;
    }

    public void setOpen_data(LocalDate open_data) {
        this.open_data = open_data;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return super.toString();
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }
}
