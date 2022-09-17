package com.myvisa.myvisa.controller;
import com.myvisa.myvisa.models.Admin;
import com.myvisa.myvisa.repos.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class VisaController {
    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/start")
    public String start(Model model) {
        Iterable<Admin> admins = adminRepository.findAll();
        model.addAttribute("admins",admins);
        return "start";
    }
}