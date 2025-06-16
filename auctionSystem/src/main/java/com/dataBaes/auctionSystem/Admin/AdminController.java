package com.dataBaes.auctionSystem.Admin;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@PostMapping("/approveAuctionItem/{auctionItem_ID}")
	public String approveAuction(@PathVariable("auctionItem_ID") Integer auctionItem_ID)
	{
		AuctionCreationEntity approvedAuctionItemEntity= auctionCreationRepository.getById(auctionItem_ID);
		approvedAuctionItemEntity.setIsVerified(true);
		auctionCreationRepository.save(approvedAuctionItemEntity);
		
		return "redirect:/admin";
	}
	
}
