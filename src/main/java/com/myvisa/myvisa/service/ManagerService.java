package com.myvisa.myvisa.service;

import com.myvisa.myvisa.dto.ManagerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;

public interface ManagerService {
    ManagerDto create(ManagerDto managerDto);

    ManagerDto read(Long id);

    @Transactional
    ManagerDto update(ManagerDto managerDto);

    @Transactional
    ManagerDto delete(Long id);

    List<ManagerDto> readAll();

    ResponseEntity<String> createManager(@RequestBody ManagerDto managerDto);

    ResponseEntity<String> readManager(@PathVariable("id") Long id);

    @Transactional
    ResponseEntity<String> updateManager(@RequestBody ManagerDto managerDto);

    @Transactional
    ResponseEntity<String> deleteManager(@PathVariable("id") Long id);

    ResponseEntity<List<ManagerDto>> getAllManagers();
}
