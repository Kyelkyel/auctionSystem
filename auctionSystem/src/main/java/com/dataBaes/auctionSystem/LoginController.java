package com.dataBaes.auctionSystem;

import com.dataBaes.auctionSystem.LoginForm;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.dataBaes.auctionSystem.sqlMethods;
@Controller
public class LoginController {
	sqlMethods sqlObj;
	
	
	public LoginController(sqlMethods sqlObj)
	{
		this.sqlObj = sqlObj;
	}
	
    @GetMapping("/login")
    public String showLoginForm(Model model) {
    	model.addAttribute("loginForm", new LoginForm());
        return "Log-in"; // This refers to login.html
    }
    
    // Handles POST request (form submission)
    @PostMapping("/submitLoginForm")
    public String handleLoginSubmit(
            @ModelAttribute("loginForm") LoginForm loginForm) {
    	String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        int userId = sqlObj.getUserIdByUsername(username);
        System.out.println("Userid: " + userId);
        // Access submitted data directly
//        System.out.println("Username: " + loginForm.getUsername());
//        System.out.println("Password: " + loginForm.getPassword());
        
        
        // Add login validation logic here. Check for username and password before redirecting
        // Redirect to home page but with user profile now
        
        if(sqlObj.confirmUserPassword(username, password, userId) == true)
        {
        	return "redirect:/"; 
        }
        
        else {
        	return "redirect:/login";
        }
    }
} 

