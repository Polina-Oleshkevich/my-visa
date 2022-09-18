package com.myvisa.myvisa.controller;

import com.myvisa.myvisa.dto.VisaDto;
import com.myvisa.myvisa.service.VisaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/visa")

public class VisaController {
    private final VisaService visaService;
    @PostMapping
    public ResponseEntity<String> createVisa(@RequestBody VisaDto visa) {
        return visaService.createVisa(visa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> readRequest(@PathVariable("id") Long id) {
        return visaService.readVisa(id);
    }

    @PutMapping
    public ResponseEntity<String> updateRequest(@RequestBody VisaDto visa) {
        return visaService.updateVisa(visa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRequest(@PathVariable("id") Long id) {
        return visaService.deleteVisa(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<VisaDto>> getAllVisas() {
        return visaService.getAllVisas();
    }
}