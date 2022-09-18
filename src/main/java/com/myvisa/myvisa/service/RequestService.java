package com.myvisa.myvisa.service;

import com.myvisa.myvisa.dto.RequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;

public interface RequestService {
    RequestDto create(RequestDto procedure);

    RequestDto read(Long id);

    @Transactional
    RequestDto update(RequestDto request);

    @Transactional
    RequestDto delete(Long id);

    List<RequestDto> readAll();

    ResponseEntity<String> createRequest(@RequestBody RequestDto request);

    ResponseEntity<String> readRequest(@PathVariable("id") Long id);

    @Transactional
    ResponseEntity<String> updateRequest(@RequestBody RequestDto request);

    @Transactional
    ResponseEntity<String> deleteRequest(@PathVariable("id") Long id);

    ResponseEntity<String> deleteARequest(Long id);

    ResponseEntity<List<RequestDto>> getAllRequests();
}
