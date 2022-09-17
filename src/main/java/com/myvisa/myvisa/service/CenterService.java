package com.myvisa.myvisa.service;

import com.myvisa.myvisa.dto.CenterDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;

public interface CenterService {

    CenterDto create(CenterDto centerDto);

    CenterDto read(Long id);

    @Transactional
    CenterDto update(CenterDto centerDto);

    @Transactional
    CenterDto delete(Long id);

    List<CenterDto> readAll();

    ResponseEntity<String> createCenter(@RequestBody CenterDto centerDto);

    ResponseEntity<String> readCenter(@PathVariable("id") Long id);

    @Transactional
    ResponseEntity<String> updateCenter(@RequestBody CenterDto centerDto);

    @Transactional
    ResponseEntity<String> deleteCenter(@PathVariable("id") Long id);

    ResponseEntity<List<CenterDto>> getAllCenters();
}
