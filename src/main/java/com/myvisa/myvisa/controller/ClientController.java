package com.myvisa.myvisa.controller;

import com.myvisa.myvisa.dto.ClientDto;
import com.myvisa.myvisa.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")

public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<String> createManager(@RequestBody ClientDto clientDto) {
        return clientService.createClient(clientDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> read(@PathVariable("id") Long id) {
        return clientService.readClient(id);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody ClientDto clientDto) {
        return clientService.updateClient(clientDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        return clientService.deleteClient(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClientDto>> getAllClients() {
        return clientService.getAllClients();
    }
}
