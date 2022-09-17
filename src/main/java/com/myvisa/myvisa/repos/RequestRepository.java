package com.myvisa.myvisa.repos;

import com.myvisa.myvisa.models.Request;
import org.springframework.data.repository.CrudRepository;

public interface RequestRepository extends CrudRepository<Request, Long> {
}
