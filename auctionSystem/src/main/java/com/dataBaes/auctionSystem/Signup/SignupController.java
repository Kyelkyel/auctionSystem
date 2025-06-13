package com.dataBaes.auctionSystem.Signup;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dataBaes.auctionSystem.sqlMethods;
import com.dataBaes.auctionSystem.Login.LoginForm;

@Controller
public class SignupController {
	sqlMethods sqlObj;
	
	public SignupController(sqlMethods sqlObj)
	{
		this.sqlObj = sqlObj;
	}
	
    @GetMapping("/sign-up")
    public String showSignupController(Model model) {
    	model.addAttribute("signupForm", new SignupForm());
        return "Sign-up"; // This refers to Sign-up.html
    }
    
    @PostMapping("/submitSignupForm")
    public String handleSignupSubmit(@ModelAttribute ("signupForm") SignupForm signupForm, Model model)
    {
    	String firstName = signupForm.getFirstName();
    	String lastName = signupForm.getLastName();
    	String username = signupForm.getUsername();
    	String email = signupForm.getEmail();
    	String password = signupForm.getPassword();
    	String confirmPassword = signupForm.getConfirmPassword();
    	boolean usernameExists = sqlObj.checkUsernameDuplicate(username);
    	boolean emailExists = sqlObj.checkEmailDuplicate(email);
    	
    	String popUpUsername = "Username already in use.";
    	String popUpEmail = "Email already in use.";
    	
    	System.out.println(usernameExists);
    	System.out.println(emailExists);
    	
    	if(sqlObj.checkUsernameDuplicate(username) == false)
    	{
    		return "redirect:/";
    	}
    	
    	else
    	{
    		model.addAttribute("usernameExists", usernameExists);
            model.addAttribute("emailExists", emailExists);
            model.addAttribute("popUpUsername", popUpUsername);
            model.addAttribute("popUpEmail", popUpEmail);
    		return "Sign-up";
    	}
    }
    
}
