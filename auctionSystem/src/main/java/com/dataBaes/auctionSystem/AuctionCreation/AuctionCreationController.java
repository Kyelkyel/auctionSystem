package com.dataBaes.auctionSystem.AuctionCreation;

import com.dataBaes.auctionSystem.sqlMethods;
import com.dataBaes.auctionSystem.Login.LoginForm;

import jakarta.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AuctionCreationController {
    	AuctionCreationRepository auctionCreationRepository;
    	
	   public AuctionCreationController(AuctionCreationRepository auctionCreationRepository) {
	        this.auctionCreationRepository = auctionCreationRepository;
	    }
	
	@GetMapping("/auctionCreation")
    public String showAuctionCreationForm(Model model) {
		model.addAttribute("auctionCreationForm", new AuctionCreationForm());
        return "sell-item"; // This refers to sell-item.html
    }
	
    // Handles POST request (form submission)
    @PostMapping("/submitAuctionCreationForm")
    public String handleLoginSubmit(@ModelAttribute("submitAuctionCreationForm") AuctionCreationForm auctionCreationForm, HttpSession session) 
    {
        // Map form data to your Entity
	       AuctionCreationEntity entity = new AuctionCreationEntity();

           entity.setItemTitle(auctionCreationForm.getItemTitle());
           entity.setItemDescription(auctionCreationForm.getItemDescription());
           entity.setItemCategory(auctionCreationForm.getItemCategory());
           entity.setStartTime(auctionCreationForm.getStartTime());
           entity.setEndTime(auctionCreationForm.getEndTime());
           entity.setStartingBid(auctionCreationForm.getStartingBid());
           entity.setSellerInfoName(auctionCreationForm.getSellerInfoName());
           entity.setSellerInfoEmail(auctionCreationForm.getSellerInfoEmail());
           entity.setSellerInfoPhone(auctionCreationForm.getSellerInfoPhone());
           entity.setSellerInfoLocation(auctionCreationForm.getSellerInfoLocation());

           // Handle file upload separately, save file and set image path
           String imagePath = saveFile(auctionCreationForm.getItemImage());
           entity.setItemImage(imagePath);

           // Save entity to DB using your repository
           auctionCreationRepository.save(entity);
           
    	return "redirect:/";
    }
    
    
    
    private String saveFile(MultipartFile file) {
        if (file.isEmpty()) return null;

        try {
            String uploadDir = "/path/to/uploads/";
            String extension = FilenameUtils.getExtension(file.getOriginalFilename());
            String uniqueFileName = UUID.randomUUID().toString() + "." + extension;
            Path filePath = Paths.get(uploadDir, uniqueFileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            return "/uploads/" + uniqueFileName; // return relative path for DB
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    

}
