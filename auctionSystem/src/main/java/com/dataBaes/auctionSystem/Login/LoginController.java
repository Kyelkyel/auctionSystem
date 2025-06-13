package com.dataBaes.auctionSystem.Login;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.dataBaes.auctionSystem.sqlMethods;
import com.dataBaes.auctionSystem.Login.LoginForm;

import jakarta.servlet.http.HttpSession;
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
            @ModelAttribute("loginForm") LoginForm loginForm, HttpSession session) {
    	String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        int userId = sqlObj.getUserIdByUsername(username);
        
        
        session.setAttribute("userID", userId); // save userID to session when user logs in. Remember to clear it when user logs out.
        session.setAttribute("username", username);
        session.setAttribute("password", password);
        
        boolean ifAdmin = sqlObj.checkIfAdmin(userId);
        System.out.println("Userid: " + userId);
        // Access submitted data directly
//        System.out.println("Username: " + loginForm.getUsername());
//        System.out.println("Password: " + loginForm.getPassword());
        
        
        // Add login validation logic here. Check for username and password before redirecting
        // Redirect to home page but with user profile now
        
        if (ifAdmin == true)
        {
        	sqlObj.setUserData(userId);
        	System.out.println("Sample data: " + session.getAttribute("profile_location"));
        	return "redirect:/admin";
        }
        
        else if (sqlObj.confirmUserPassword(username, password, userId) == true)
        {
        	sqlObj.setUserData(userId);
        	System.out.println("Sample data: " + session.getAttribute("profile_location"));
        	return "redirect:/user"; 
        }
        
        else {
        	return "redirect:/login";
        }
    }
} 

