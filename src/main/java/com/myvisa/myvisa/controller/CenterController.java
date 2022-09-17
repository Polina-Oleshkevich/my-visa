package com.myvisa.myvisa.controller;

import com.myvisa.myvisa.dto.CenterDto;
import com.myvisa.myvisa.service.CenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/center")
public class CenterController {
    private final CenterService centerService;
    @PostMapping
    public ResponseEntity<String> createManager(@RequestBody CenterDto centerDto) {
        return centerService.createCenter(centerDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> read(@PathVariable("id") Long id) {
        return centerService.readCenter(id);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody CenterDto centerDto) {
        return centerService.updateCenter(centerDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        return centerService.deleteCenter(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CenterDto>> getAllCenters() {
        return centerService.getAllCenters();
    }
}
