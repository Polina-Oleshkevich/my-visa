package com.myvisa.myvisa.controller;

import com.myvisa.myvisa.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
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
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("title", "Регистрация");
        return "registration";
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
    @RequestMapping("/users")
    public String showAllUsers(Model model, Pageable pageable) {
        model.addAttribute("users", userRepository.findAll(pageable));
        return "userreg";
    }
    @GetMapping("/login")
    public String toLoginPage() {
        return "login";
    }
}