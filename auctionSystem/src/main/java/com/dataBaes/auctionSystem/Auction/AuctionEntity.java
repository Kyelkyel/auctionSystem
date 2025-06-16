package com.dataBaes.auctionSystem.Auction;

import com.dataBaes.auctionSystem.AuctionCreation.AuctionCreationEntity;

import jakarta.persistence.*;

@Entity
@Table(name = "Auction")
public class AuctionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auctionID")
    private Integer auctionID;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "auctionItem_ID", nullable = false, unique = true)
    private AuctionCreationEntity auctionItem;

    @Enumerated(EnumType.STRING)
    @Column(name = "auctionStatus")
    private AuctionStatus auctionStatus;

    @Column(name = "soldAt", nullable = false)
    private Integer soldAt;

    @Column(name = "current_price", nullable = false)
    private Double currentPrice = 0.0;

    // Getters and Setters

    public Integer getAuctionID() {
        return auctionID;
    }

    public void setAuctionID(Integer auctionID) {
        this.auctionID = auctionID;
    }

    public AuctionCreationEntity getAuctionItem() {
        return auctionItem;
    }

    public void setAuctionItem(AuctionCreationEntity auctionItem) {
        this.auctionItem = auctionItem;
    }

    public AuctionStatus getAuctionStatus() {
        return auctionStatus;
    }

    public void setAuctionStatus(AuctionStatus auctionStatus) {
        this.auctionStatus = auctionStatus;
    }

    public Integer getSoldAt() {
        return soldAt;
    }

    public void setSoldAt(Integer soldAt) {
        this.soldAt = soldAt;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    // Enum for auctionStatus

    public enum AuctionStatus {
        Ongoing,
        Inactive,
        Ended
    }
}
