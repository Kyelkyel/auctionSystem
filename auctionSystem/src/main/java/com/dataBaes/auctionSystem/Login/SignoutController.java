package com.dataBaes.auctionSystem.Login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dataBaes.auctionSystem.Signup.SignupForm;

import jakarta.servlet.http.HttpSession;

@Controller
public class SignoutController {
	
	   @GetMapping("/sign-out")
	    public String showSignupController(HttpSession session) {
		    session.invalidate(); 
	        return "redirect:/"; // This refers to index.html
	    }
	    
}
