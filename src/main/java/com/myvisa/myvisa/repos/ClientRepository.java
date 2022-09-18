package com.myvisa.myvisa.repos;

import com.myvisa.myvisa.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
