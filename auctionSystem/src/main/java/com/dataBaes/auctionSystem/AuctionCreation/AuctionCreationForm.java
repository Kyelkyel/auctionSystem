package com.dataBaes.auctionSystem.AuctionCreation;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AuctionCreationForm {

    private MultipartFile itemImage;      // For file upload
    private String itemTitle;
    private String itemDescription;
    private String itemCategory;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private BigDecimal startingBid;
    private String sellerInfoName;
    private String sellerInfoEmail;
    private String sellerInfoPhone;
    private String sellerInfoLocation;

    // Getters and Setters

    public MultipartFile getItemImage() {
        return itemImage;
    }

    public void setItemImage(MultipartFile itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getStartingBid() {
        return startingBid;
    }

    public void setStartingBid(BigDecimal startingBid) {
        this.startingBid = startingBid;
    }

    public String getSellerInfoName() {
        return sellerInfoName;
    }

    public void setSellerInfoName(String sellerInfoName) {
        this.sellerInfoName = sellerInfoName;
    }

    public String getSellerInfoEmail() {
        return sellerInfoEmail;
    }

    public void setSellerInfoEmail(String sellerInfoEmail) {
        this.sellerInfoEmail = sellerInfoEmail;
    }

    public String getSellerInfoPhone() {
        return sellerInfoPhone;
    }

    public void setSellerInfoPhone(String sellerInfoPhone) {
        this.sellerInfoPhone = sellerInfoPhone;
    }

    public String getSellerInfoLocation() {
        return sellerInfoLocation;
    }

    public void setSellerInfoLocation(String sellerInfoLocation) {
        this.sellerInfoLocation = sellerInfoLocation;
    }
}
