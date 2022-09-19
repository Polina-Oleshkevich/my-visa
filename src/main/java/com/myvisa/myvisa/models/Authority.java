package com.myvisa.myvisa.models;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    @Column(name = "authority")
    private String authority;

    @ManyToOne
    @JoinColumn(name = "username")
    private Client client;

    public Authority() {
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Client getUser() {
        return client;
    }

    public void setUser(Client user) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "authority= " + authority ;
    }
}