package com.dataBaes.auctionSystem.Auction;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dataBaes.auctionSystem.timeMethods;
import com.dataBaes.auctionSystem.Auction.AuctionEntity.AuctionStatus;
import com.dataBaes.auctionSystem.AuctionCreation.AuctionCreationEntity;
import com.dataBaes.auctionSystem.Bids.BidsEntity;
import com.dataBaes.auctionSystem.Bids.BidsRepository;
import com.dataBaes.auctionSystem.User.UserEntity;
import com.dataBaes.auctionSystem.User.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuctionController {

	@Autowired
	AuctionRepository auctionRepository;
	
	@Autowired
	BidsRepository bidsRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public AuctionController(AuctionRepository auctionRepository, BidsRepository bidsRepository, UserRepository userRepository)
	{
		this.auctionRepository = auctionRepository;
		this.bidsRepository = bidsRepository;
		this.userRepository = userRepository;
	}
	
	
	@GetMapping("/auction/{auctionID}")
    public String getAuctionItemPage(@PathVariable("auctionID") Integer auctionID, Model model, HttpSession session) {
        // Fetch the auction item by id
        AuctionEntity auctionEntity = auctionRepository.getById(auctionID);
        List<BidsEntity> bidsEntityList = bidsRepository.findAll(); 
        model.addAttribute("auctionVar", auctionEntity);
        model.addAttribute("session", session);
        model.addAttribute("bidsEntityList", bidsEntityList);

        return "auction-detail"; // Thymeleaf template name
    }
	
	@PostMapping("/createBidID/{userID}/{auctionID}")
	public String approveAuction(@PathVariable("userID") Integer userID, @PathVariable("auctionID") Integer auctionID, @RequestParam("bidAmount") Integer bidAmount)
	{
		BidsEntity bidsEntity = new BidsEntity();
		UserEntity userEntity = userRepository.getById(userID);
		AuctionEntity auctionEntity = auctionRepository.getById(auctionID);
		
		
		bidsEntity.setUserID(userEntity);
		bidsEntity.setAuctionID(auctionEntity);
		bidsEntity.setBidAmount(bidAmount);
		bidsEntity.setBidderPlace(0);
		bidsEntity.setBidDateTime(timeMethods.getCurrentTime().toLocalDateTime());
		
		bidsRepository.save(bidsEntity);
		
		return "redirect:/auction/{auctionID}";	
	}
	
	
	
	
}
