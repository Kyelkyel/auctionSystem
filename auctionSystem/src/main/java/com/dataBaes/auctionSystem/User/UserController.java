package com.dataBaes.auctionSystem.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dataBaes.auctionSystem.Signup.SignupForm;

@Controller
public class UserController {
	
	@GetMapping("/user")
    public String showSignupController(Model model) {

        return "User"; // This refers to user.html
    }
    
}
