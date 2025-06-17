package com.dataBaes.auctionSystem.Bids;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dataBaes.auctionSystem.AuctionCreation.AuctionCreationEntity;

public interface BidsRepository extends JpaRepository<BidsEntity, Integer> {
	
}
