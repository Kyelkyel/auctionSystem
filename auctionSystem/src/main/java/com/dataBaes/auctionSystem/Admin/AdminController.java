package com.dataBaes.auctionSystem.Admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dataBaes.auctionSystem.AuctionCreation.AuctionCreationEntity;
import com.dataBaes.auctionSystem.AuctionCreation.AuctionCreationRepository;
import com.dataBaes.auctionSystem.Login.LoginForm;


@Controller
public class AdminController {

	AuctionCreationRepository auctionCreationRepository;
	
	public AdminController(AuctionCreationRepository auctionCreationRepository) 
	{
        this.auctionCreationRepository = auctionCreationRepository;
    }
	
	@GetMapping("/admin")
    public String showLoginForm(Model model) {
		List<AuctionCreationEntity> AuctionCreationEntityList = auctionCreationRepository.findAll();
		model.addAttribute("auctionCreationEntityList", AuctionCreationEntityList);
        return "Admin"; // This refers to Admin.html
    }
}
