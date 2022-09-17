package com.myvisa.myvisa.repos;

import com.myvisa.myvisa.models.Admin;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Admin, Integer> {
}
