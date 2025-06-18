package com.dataBaes.auctionSystem.User;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dataBaes.auctionSystem.Auction.AuctionEntity;
import com.dataBaes.auctionSystem.Auction.AuctionRepository;
import com.dataBaes.auctionSystem.Signup.SignupForm;

@Controller
public class UserController {
	AuctionRepository auctionRepository;
	
	public UserController(AuctionRepository auctionRepository)
	{
		this.auctionRepository = auctionRepository;
	}
	
	
	@GetMapping("/user")
    public String showSignupController(Model model) {
		List<AuctionEntity> auctionEntity = auctionRepository.findAll(); 
		model.addAttribute(auctionEntity);
        return "User"; // This refers to user.html
    }
	
}
