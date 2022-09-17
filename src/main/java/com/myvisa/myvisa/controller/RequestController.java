package com.myvisa.myvisa.controller;

import com.myvisa.myvisa.dto.RequestDto;
import com.myvisa.myvisa.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/request")
public class RequestController {
    private final RequestService requestService;
    @PostMapping
    public ResponseEntity<String> createRequest(@RequestBody RequestDto request) {
        return requestService.createRequest(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> readRequest(@PathVariable("id") Long id) {
        return requestService.readRequest(id);
    }

    @PutMapping
    public ResponseEntity<String> updateRequest(@RequestBody RequestDto request) {
        return requestService.updateRequest(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRequest(@PathVariable("id") Long id) {
        return requestService.deleteRequest(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<RequestDto>> getAllRequests() {
        return requestService.getAllRequests();
    }
}
