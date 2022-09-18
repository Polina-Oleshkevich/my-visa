package com.myvisa.myvisa.repos;

import com.myvisa.myvisa.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
