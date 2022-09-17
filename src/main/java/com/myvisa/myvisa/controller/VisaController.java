package com.myvisa.myvisa.controller;
import com.myvisa.myvisa.repos.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class VisaController {
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/start")
    public String start(Model model) {
        Iterable<Message> messages = messageRepository.findAll();
        model.addAttribute("messages",messages);
        return "start";
    }
}