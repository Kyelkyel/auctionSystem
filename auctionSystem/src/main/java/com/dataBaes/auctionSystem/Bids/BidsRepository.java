package com.dataBaes.auctionSystem.Bids;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dataBaes.auctionSystem.Auction.AuctionEntity;
import com.dataBaes.auctionSystem.AuctionCreation.AuctionCreationEntity;

public interface BidsRepository extends JpaRepository<BidsEntity, Integer> {
	
	
	@Query("SELECT a FROM BidsEntity a WHERE a.auctionID.auctionItem.userID = :userID")
	List<BidsEntity> findAllByUserID(@Param("userID") Integer userID);

}
