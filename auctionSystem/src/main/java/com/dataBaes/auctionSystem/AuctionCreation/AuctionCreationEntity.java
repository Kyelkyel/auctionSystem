package com.dataBaes.auctionSystem.AuctionCreation;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Table(name = "auction_items")
public class AuctionCreationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auctionItem_ID")
    private Integer auctionItemID;

    @Column(name = "userID", nullable = false, unique = true)
    private Integer userID;

    @Column(name = "item_image", length = 255)
    private String itemImage;

    @Column(name = "item_title", nullable = false, length = 255)
    private String itemTitle;

    @Column(name = "item_description", nullable = false, columnDefinition = "TEXT")
    private String itemDescription;

    @Column(name = "item_category", nullable = false, length = 100)
    private String itemCategory;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    @Column(name = "starting_bid", nullable = false, precision = 10, scale = 2)
    private BigDecimal startingBid;

    @Column(name = "seller_info_name", nullable = false, length = 255)
    private String sellerInfoName;

    @Column(name = "seller_info_email", nullable = false, length = 255)
    private String sellerInfoEmail;

    @Column(name = "seller_info_phone", nullable = false, length = 50)
    private String sellerInfoPhone;

    @Column(name = "seller_info_location", nullable = false, length = 255)
    private String sellerInfoLocation;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "isVerified", nullable = false)
    private Boolean isVerified;

    // No-arg constructor
    public AuctionCreationEntity() {}

    // Getters and setters

    public Integer getAuctionItemID() {
        return auctionItemID;
    }

    public void setAuctionItemID(Integer auctionItemID) {
        this.auctionItemID = auctionItemID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // no setter for createdAt since it's DB-generated

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }
}
