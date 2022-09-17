package com.myvisa.myvisa.service;

import com.myvisa.myvisa.dto.ClientDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;

public interface ClientService {
    ClientDto create(ClientDto clientDto);

    ClientDto read(Long id);

    @Transactional
    ClientDto update(ClientDto clientDto);

    @Transactional
    ClientDto delete(Long id);

    List<ClientDto> readAll();

    ResponseEntity<String> createClient(@RequestBody ClientDto clientDto);

    ResponseEntity<String> readClient(@PathVariable("id") Long id);

    @Transactional
    ResponseEntity<String> updateClient(@RequestBody ClientDto clientDto);

    @Transactional
    ResponseEntity<String> deleteClient(@PathVariable("id") Long id);

    ResponseEntity<List<ClientDto>> getAllClients();

}
