package com.myvisa.myvisa.service;

import com.myvisa.myvisa.dto.AdminDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;

public interface AdminService {
    AdminDto create(AdminDto adminDto);

    AdminDto read(Long id);

    @Transactional
    AdminDto update(AdminDto adminDto);

    @Transactional
    AdminDto delete(Long id);

    List<AdminDto> readAll();

    ResponseEntity<String> createAdmin(@RequestBody AdminDto adminDto);

    ResponseEntity<String> readAdmin(@PathVariable("id") Long id);

    @Transactional
    ResponseEntity<String> updateAdmin(@RequestBody AdminDto adminDto);

    @Transactional
    ResponseEntity<String> deleteAdmin(@PathVariable("id") Long id);

    ResponseEntity<List<AdminDto>> getAllAdmins();

}

