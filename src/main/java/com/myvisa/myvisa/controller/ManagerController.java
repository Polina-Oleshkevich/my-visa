package com.myvisa.myvisa.controller;

import com.myvisa.myvisa.dto.ManagerDto;
import com.myvisa.myvisa.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/manager")
public class ManagerController {

    private final ManagerService managerService;

    @PostMapping
    public ResponseEntity<String> createManager(@RequestBody ManagerDto managerDto) {
        return managerService.createManager(managerDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> read(@PathVariable("id") Long id) {
        return managerService.readManager(id);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody ManagerDto managerDto) {
        return managerService.updateManager(managerDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        return managerService.deleteManager(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ManagerDto>> getAllManagers() {
        return managerService.getAllManagers();
    }
}
