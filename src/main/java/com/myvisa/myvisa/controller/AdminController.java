package com.myvisa.myvisa.controller;

import com.myvisa.myvisa.dto.AdminDto;
import com.myvisa.myvisa.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @PostMapping
    public ResponseEntity<String> createManager(@RequestBody AdminDto adminDto) {
        return adminService.createAdmin(adminDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> read(@PathVariable("id") Long id) {
        return adminService.readAdmin(id);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody AdminDto adminDto) {
        return adminService.updateAdmin(adminDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        return adminService.deleteAdmin(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AdminDto>> getAllAdmins() {
        return adminService.getAllAdmins();
    }

}
