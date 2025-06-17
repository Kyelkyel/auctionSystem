package com.dataBaes.auctionSystem.Bids;

import jakarta.persistence.*;
import com.dataBaes.auctionSystem.User.UserEntity;
import com.dataBaes.auctionSystem.Auction.AuctionEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "Bids")
public class BidsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bidID")
    private Integer bidID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userID", nullable = false)
    private UserEntity userID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "auctionID", nullable = false)
    private AuctionEntity auctionID;

    @Column(name = "bidAmount", nullable = false)
    private Integer bidAmount;

    @Column(name = "bidderPlace", nullable = false)
    private Integer bidderPlace;

    @Column(name = "bidDateTime")
    private LocalDateTime bidDateTime;

    // Getters and setters

    public Integer getBidID() {
        return bidID;
    }

    public void setBidID(Integer bidID) {
        this.bidID = bidID;
    }

    public UserEntity getUserID() {
        return userID;
    }

    public void setUserID(UserEntity userID) {
        this.userID = userID;
    }

    public AuctionEntity getAuctionID() {
        return auctionID;
    }

    public void setAuctionID(AuctionEntity auctionID) {
        this.auctionID = auctionID;
    }

    public Integer getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(Integer bidAmount) {
        this.bidAmount = bidAmount;
    }

    public Integer getBidderPlace() {
        return bidderPlace;
    }

    public void setBidderPlace(Integer bidderPlace) {
        this.bidderPlace = bidderPlace;
    }

    public LocalDateTime getBidDateTime() {
        return bidDateTime;
    }

    public void setBidDateTime(LocalDateTime bidDateTime) {
        this.bidDateTime = bidDateTime;
    }
}
