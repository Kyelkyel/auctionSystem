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
    	sqlMethods sqlObj;
    	
	   public AuctionCreationController(AuctionCreationRepository auctionCreationRepository, sqlMethods sqlObj) {
	        this.auctionCreationRepository = auctionCreationRepository;
	        this.sqlObj = sqlObj;
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
           entity.setUserID((Integer) session.getAttribute("userID"));
           entity.setIsVerified(false);
           entity.setAuctionItemID(auctionCreationForm.getAuctionItem_ID());
           
           // Handle file upload separately, save file and set image path
           String imagePath = saveFile(auctionCreationForm.getItemImage());
           System.out.println(imagePath);
           entity.setItemImage(imagePath);

           // Save entity to DB using your repository
           auctionCreationRepository.save(entity);
           
    	return "redirect:/";
    }
    
    
    
    private String saveFile(MultipartFile file) {
        if (file.isEmpty()) return null;

        try {
            // Get base upload directory
            String baseUploadDir = sqlObj.absolutePathUserUpload(); // e.g., "D:/.../userUploads"
            
            // Append userImages subfolder
            Path uploadDir = Paths.get(baseUploadDir, "userImages");
            
            // Create directories if they do not exist
            if (Files.notExists(uploadDir)) {
                Files.createDirectories(uploadDir);
            }

            // Generate unique file name with extension
            String extension = FilenameUtils.getExtension(file.getOriginalFilename());
            String uniqueFileName = UUID.randomUUID().toString() + "." + extension;

            // Full path to save file
            Path filePath = uploadDir.resolve(uniqueFileName);

            // Copy file to destination (overwrite if exists)
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // Return relative path for DB usage
            return "/userImages/" + uniqueFileName;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    

}
