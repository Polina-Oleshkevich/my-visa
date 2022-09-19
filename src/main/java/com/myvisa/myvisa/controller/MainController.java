package com.myvisa.myvisa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");
        return "home";
    }
    @GetMapping("/account")
    public String account(Model model) {
        model.addAttribute("title", "Личный кабинет");
        return "account";
    }

        @GetMapping("/sign_in")
        public String sign_in(Model model) {
            model.addAttribute("title", "Подать заявку");
            return "sign_in";
        }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("title", "О визовом центре");
        return "contact";
    }
    @GetMapping("/price")
    public String price(Model model) {
        model.addAttribute("title", "Прайс");
        return "price";
    }
    @GetMapping("/visa-type")
    public String visaType(Model model) {
        model.addAttribute("title", "Информация о визах");
        return "visa-type";
    }
    @GetMapping("/info")
    public String info(Model model) {
        model.addAttribute("title", "Подробнее...");
        return "info";
    }
}