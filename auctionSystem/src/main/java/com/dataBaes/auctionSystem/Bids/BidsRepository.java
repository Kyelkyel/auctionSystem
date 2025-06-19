package com.dataBaes.auctionSystem.Bids;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dataBaes.auctionSystem.Auction.AuctionEntity;
import com.dataBaes.auctionSystem.AuctionCreation.AuctionCreationEntity;
import com.dataBaes.auctionSystem.User.UserEntity;

public interface BidsRepository extends JpaRepository<BidsEntity, Integer> {
	
	
	@Query("SELECT a FROM BidsEntity a WHERE a.auctionID.auctionItem.userID = :userID")
	List<BidsEntity> findAllByUserID(@Param("userID") Integer userID);
	
	@Query("SELECT b.userID FROM BidsEntity b WHERE b.auctionID.auctionID = :auctionId ORDER BY b.bidDateTime DESC")
	Optional<UserEntity> findLastBidUserByAuctionId(@Param("auctionId") Integer auctionId);

	@Query("SELECT b.bidID FROM BidsEntity b WHERE b.auctionID.auctionID = :auctionId ORDER BY b.bidDateTime DESC LIMIT 1")
    Optional<Integer> findMostRecentBidIdByAuctionId(@Param("auctionId") Integer auctionId);
}
