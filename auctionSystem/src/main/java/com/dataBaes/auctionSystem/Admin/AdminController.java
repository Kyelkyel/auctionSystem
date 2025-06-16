package com.dataBaes.auctionSystem.Admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dataBaes.auctionSystem.Auction.AuctionEntity;
import com.dataBaes.auctionSystem.Auction.AuctionEntity.AuctionStatus;
import com.dataBaes.auctionSystem.Auction.AuctionRepository;
import com.dataBaes.auctionSystem.AuctionCreation.AuctionCreationEntity;
import com.dataBaes.auctionSystem.AuctionCreation.AuctionCreationRepository;
import com.dataBaes.auctionSystem.Login.LoginForm;


@Controller
public class AdminController {

	@Autowired
	AuctionCreationRepository auctionCreationRepository;
	
	@Autowired
	AuctionRepository auctionRepository;
	
	public AdminController(AuctionCreationRepository auctionCreationRepository, AuctionRepository auctionRepository) 
	{
        this.auctionCreationRepository = auctionCreationRepository;
        this.auctionRepository = auctionRepository;
    }
	
	@GetMapping("/admin")
	public String showLoginForm(Model model) {
		List<AuctionCreationEntity> auctionCreationEntityList = auctionCreationRepository.findAll(); 
		model.addAttribute("auctionCreationEntityList", auctionCreationEntityList);
		
		List<AuctionEntity> auctionEntityList = auctionRepository.findAll(); 
		model.addAttribute("auctionList", auctionEntityList);

	    return "Admin"; 
	}
	
	
	@PostMapping("/approveAuctionItem/{auctionItem_ID}")
	public String approveAuction(@PathVariable("auctionItem_ID") Integer auctionItem_ID)
	{
		AuctionCreationEntity approvedAuctionItemEntity= auctionCreationRepository.getById(auctionItem_ID);
		approvedAuctionItemEntity.setIsVerified(true);
		auctionCreationRepository.save(approvedAuctionItemEntity);
		
		AuctionEntity auctionEntity = new AuctionEntity();
		auctionEntity.setAuctionItem(approvedAuctionItemEntity);
		auctionEntity.setCurrentPrice((double)0);
		auctionEntity.setAuctionStatus(AuctionStatus.Inactive);
		auctionEntity.setSoldAt(0);
		
		auctionCreationRepository.save(approvedAuctionItemEntity);
		auctionRepository.save(auctionEntity);   
		return "redirect:/admin";	
	}
	
	@PostMapping("/rejectAuctionItem/{auctionItem_ID}")
	public String rejectAuction(@PathVariable("auctionItem_ID") Integer auctionItem_ID)
	{
		auctionCreationRepository.deleteById(auctionItem_ID);
		
		return "redirect:/admin";
	}
	
	@PostMapping("/deleteAuctionItem/{auctionItem_ID}")
	public String deleteAuction(@PathVariable("auctionItem_ID") Integer auctionItem_ID)
	{
		auctionCreationRepository.deleteById(auctionItem_ID);
		
		return "redirect:/admin";
	}
	
	
}
