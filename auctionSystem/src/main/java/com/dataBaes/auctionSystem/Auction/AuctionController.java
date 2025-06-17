package com.dataBaes.auctionSystem.Auction;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AuctionController {

	AuctionRepository auctionRepository;
	
	public AuctionController(AuctionRepository auctionRepository)
	{
		this.auctionRepository = auctionRepository;
	}
	
	
	@GetMapping("/auction/{id}")
    public String getAuctionItemPage(@PathVariable("id") Integer id, Model model) {
        // Fetch the auction item by id
        AuctionEntity auctionEntity = auctionRepository.getById(id);
       
        model.addAttribute("auctionVar", auctionEntity);
        return "auction-detail"; // Thymeleaf template name
    }
	
}
