package com.dataBaes.auctionSystem.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dataBaes.auctionSystem.Auction.AuctionEntity;
import com.dataBaes.auctionSystem.Auction.AuctionRepository;
import com.dataBaes.auctionSystem.Bids.BidsEntity;
import com.dataBaes.auctionSystem.Bids.BidsRepository;
import com.dataBaes.auctionSystem.Login.LoginForm;
import com.dataBaes.auctionSystem.Signup.SignupForm;
import com.dataBaes.auctionSystem.User.UserEntity.UserStatus;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	AuctionRepository auctionRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BidsRepository bidsRepository;
	
	public UserController(AuctionRepository auctionRepository, UserRepository userRepository, BidsRepository bidsRepository)
	{
		this.auctionRepository = auctionRepository;
		this.userRepository = userRepository;
		this.bidsRepository = bidsRepository;
	}
	
	
	@GetMapping("/user")
    public String showSignupController(Model model) {
		List<AuctionEntity> auctionEntity = auctionRepository.findAll(); 
		model.addAttribute(auctionEntity);
        return "User"; // This refers to user.html
    }
	
	@GetMapping("/userProfile")
	public String userProfileController(Model model, HttpSession session)
	{
		UserEntity userEntity = userRepository.getById((Integer) session.getAttribute("userID"));
		List<BidsEntity> bidsEntityList = bidsRepository.findAllByUserID((Integer) session.getAttribute("userID"));
		List<AuctionEntity> auctionEntityList = auctionRepository.findAllByUserID((Integer) session.getAttribute("userID"));
		model.addAttribute("userEntityVar", userEntity);
		model.addAttribute("auctionEntityListVar", auctionEntityList);
		model.addAttribute("bidsEntityListVar", bidsEntityList);
		
		return "yourProfile";
	}
	
	@GetMapping("/userSettings")
	public String userSettingsController(Model model, HttpSession session)
	{
		UserEntity userEntity = userRepository.getById((Integer) session.getAttribute("userID"));
		model.addAttribute("userEntityVar", userEntity);
		
		return "Settings";
	}
	
	@PostMapping("/userProfile/saveUserProfile")
	public String saveUserProfile(@ModelAttribute("userForm") UserForm userForm, HttpSession session)
	{
		UserEntity userEntity = userRepository.getById((Integer) session.getAttribute("userID"));

		if (userForm.getUsername() != null) {
		    userEntity.setUsername(userForm.getUsername());
		}

		if (userForm.getPassword() != null) {
		    userEntity.setPassword(userForm.getPassword());
		}

		if (userForm.getEmail() != null) {
		    userEntity.setEmail(userForm.getEmail());
		}

		if (userForm.getUserStatus() != null) {
		    userEntity.setUserStatus(userForm.getUserStatus());
		}

		if (userForm.getIfAdmin() != null) {
		    userEntity.setIfAdmin(userForm.getIfAdmin());
		}

		if (userForm.getAddress() != null) {
		    userEntity.setAddress(userForm.getAddress());
		}

		if (userForm.getContactNo() != null) {
		    userEntity.setContactNo(userForm.getContactNo());
		}

		if (userForm.getName() != null) {
		    userEntity.setName(userForm.getName());
		}

		if (userForm.getSchoolName() != null) {
		    userEntity.setSchoolName(userForm.getSchoolName());
		}

		if (userForm.getStudentID() != null) {
		    userEntity.setStudentID(userForm.getStudentID());
		}

		if (userForm.getAge() != null) {
		    userEntity.setAge(userForm.getAge());
		}

		if (userForm.getSex() != null) {
		    userEntity.setSex(userForm.getSex());
		}

		
		return "redirect:/user";
			
	}

	@PostMapping("/userSettings/saveUserSettings")
	public String saveUserSettings(@ModelAttribute("userForm") UserForm userForm, HttpSession session)
	{
		UserEntity userEntity = userRepository.getById((Integer) session.getAttribute("userID"));

		if (userForm.getUsername() != null) {
		    userEntity.setUsername(userForm.getUsername());
		}

		if (userForm.getPassword() != null) {
		    userEntity.setPassword(userForm.getPassword());
		}

		if (userForm.getEmail() != null) {
		    userEntity.setEmail(userForm.getEmail());
		}

		if (userForm.getUserStatus() != null) {
		    userEntity.setUserStatus(userForm.getUserStatus());
		}

		if (userForm.getIfAdmin() != null) {
		    userEntity.setIfAdmin(userForm.getIfAdmin());
		}

		if (userForm.getAddress() != null) {
		    userEntity.setAddress(userForm.getAddress());
		}

		if (userForm.getContactNo() != null) {
		    userEntity.setContactNo(userForm.getContactNo());
		}

		if (userForm.getName() != null) {
		    userEntity.setName(userForm.getName());
		}

		if (userForm.getSchoolName() != null) {
		    userEntity.setSchoolName(userForm.getSchoolName());
		}

		if (userForm.getStudentID() != null) {
		    userEntity.setStudentID(userForm.getStudentID());
		}

		if (userForm.getAge() != null) {
		    userEntity.setAge(userForm.getAge());
		}

		if (userForm.getSex() != null) {
		    userEntity.setSex(userForm.getSex());
		}

		
		return "redirect:/user";
			
	}

	
}
