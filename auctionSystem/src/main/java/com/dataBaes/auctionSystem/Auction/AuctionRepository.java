package com.dataBaes.auctionSystem.Auction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface AuctionRepository extends JpaRepository<AuctionEntity, Integer> {

	@Query("SELECT a FROM AuctionEntity a WHERE a.auctionStatus <> 'Ongoing' " +
		       "AND a.auctionItem.startTime <= :now")
		List<AuctionEntity> findAuctionsToStart(@Param("now") LocalDateTime now);

    
	@Query("SELECT a FROM AuctionEntity a WHERE a.auctionStatus <> 'Ended' " +
		       "AND a.auctionItem.endTime <= :now")
		List<AuctionEntity> findAuctionsToEnd(@Param("now") LocalDateTime now);

    @Query("SELECT a FROM AuctionEntity a WHERE a.auctionItem.userID = :userID")
    List<AuctionEntity> findAllByUserID(@Param("userID") Integer userID);
    
}
