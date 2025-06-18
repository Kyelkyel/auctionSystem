package com.dataBaes.auctionSystem.Signup;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dataBaes.auctionSystem.sqlMethods;
import com.dataBaes.auctionSystem.Login.LoginForm;
import com.dataBaes.auctionSystem.User.UserEntity;
import com.dataBaes.auctionSystem.User.UserRepository;

@Controller
public class SignupController {
	sqlMethods sqlObj;
	UserRepository userRepository;
	public SignupController(sqlMethods sqlObj, UserRepository userRepository)
	{
		this.sqlObj = sqlObj;
		this.userRepository = userRepository;
	}
	
    @GetMapping("/sign-up")
    public String showSignupController(Model model) {
    	model.addAttribute("signupForm", new SignupForm());
        return "Sign-up"; // This refers to Sign-up.html
    }
    
    @PostMapping("/submitSignupForm")
    public String handleSignupSubmit(@ModelAttribute("signupForm") SignupForm signupForm, Model model) {
        String firstName = signupForm.getFirstName();
        String lastName = signupForm.getLastName();
        String username = signupForm.getUsername();
        String email = signupForm.getEmail();
        String password = signupForm.getPassword();
        String confirmPassword = signupForm.getConfirmPassword();
        String address = signupForm.getAddress();
        String contactNo = signupForm.getContactNo();
        String schoolName = signupForm.getSchoolName();
        String studentID = signupForm.getStudentID();
        Integer age = signupForm.getAge();
        String sexStr = signupForm.getSex();

        boolean usernameExists = sqlObj.checkUsernameDuplicate(username);
        boolean emailExists = sqlObj.checkEmailDuplicate(email);

        String popUpUsername = "Username already in use.";
        String popUpEmail = "Email already in use.";

        if (usernameExists || emailExists) {
            model.addAttribute("usernameExists", usernameExists);
            model.addAttribute("emailExists", emailExists);
            model.addAttribute("popUpUsername", popUpUsername);
            model.addAttribute("popUpEmail", popUpEmail);
            return "Sign-up"; // return to signup page with errors
        }

        // Validate password confirmation (optional)
        if (!password.equals(confirmPassword)) {
            model.addAttribute("passwordMismatch", true);
            return "Sign-up";
        }

        // Create new UserEntity and set fields
        UserEntity newUser = new UserEntity();
        newUser.setName(firstName + " " + lastName); // assuming full name stored in name
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(password); // consider encoding password before saving
        newUser.setAddress(address);
        newUser.setContactNo(contactNo);
        newUser.setSchoolName(schoolName);
        newUser.setStudentID(studentID);
        newUser.setAge(age);

//        newUser.setSex(UserEntity.Sex.Prefer_Not_To_Say);
        // Convert sex string to enum
        if (sexStr != null) {
            switch (sexStr.toLowerCase()) {
                case "male":
                    newUser.setSex(UserEntity.Sex.Male);
                    break;
                case "female":
                    newUser.setSex(UserEntity.Sex.Female);
                    break;
                case "prefer not to say":
                case "prefernottosay":
                case "prefer_not_to_say":
                    newUser.setSex(UserEntity.Sex.Prefer_Not_To_Say);
                    break;
                default:
                    // handle invalid input or set default
                    newUser.setSex(UserEntity.Sex.Prefer_Not_To_Say);
            }
        } else {
            newUser.setSex(UserEntity.Sex.Prefer_Not_To_Say);
        }

        newUser.setUserStatus(UserEntity.UserStatus.ONLINE); // default status
        newUser.setIfAdmin(false); // default to non-admin
        newUser.setProfile_location(null); // or default profile image path

        // Save user to database
        userRepository.save(newUser);

        // Redirect to home or login page after successful signup
        return "redirect:/";
    }
    
}
