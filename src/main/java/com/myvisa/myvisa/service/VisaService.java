package com.myvisa.myvisa.service;

import com.myvisa.myvisa.dto.VisaDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;

public interface VisaService {
    VisaDto create(VisaDto visa);

    VisaDto read(Long id);

    @Transactional
    VisaDto update(VisaDto request);

    @Transactional
    VisaDto delete(Long id);

    List<VisaDto> readAll();

    ResponseEntity<String> createVisa(@RequestBody VisaDto visa);

    ResponseEntity<String> readVisa(@PathVariable("id") Long id);

    @Transactional
    ResponseEntity<String> updateVisa(@RequestBody VisaDto visa);

    @Transactional
    ResponseEntity<String> deleteVisa(@PathVariable("id") Long id);

    ResponseEntity<List<VisaDto>> getAllVisas();
}
