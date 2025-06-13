package com.dataBaes.auctionSystem.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dataBaes.auctionSystem.Login.LoginForm;


@Controller
public class AdminController {

	@GetMapping("/admin")
    public String showLoginForm(Model model) {

        return "Admin"; // This refers to Admin.html
    }
}
