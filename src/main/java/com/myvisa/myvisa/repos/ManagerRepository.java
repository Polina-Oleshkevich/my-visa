package com.myvisa.myvisa.repos;

import com.myvisa.myvisa.models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
