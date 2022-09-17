package com.myvisa.myvisa.repos;

import com.myvisa.myvisa.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
