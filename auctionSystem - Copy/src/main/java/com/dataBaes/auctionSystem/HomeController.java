package com.dataBaes.auctionSystem;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String showLoginForm() {
        return "index"; // This refers to login.html
    }
} 

