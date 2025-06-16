package com.dataBaes.auctionSystem.Auction;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dataBaes.auctionSystem.AuctionCreation.AuctionCreationEntity;

public interface AuctionRepository extends JpaRepository<AuctionEntity, Integer> {
	
}
