package com.myvisa.myvisa.repos;

import com.myvisa.myvisa.models.Visa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisaRepository extends JpaRepository<Visa, Long> {
}
