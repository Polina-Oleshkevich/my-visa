package com.myvisa.myvisa.repos;

import com.myvisa.myvisa.models.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Integer> {
}
