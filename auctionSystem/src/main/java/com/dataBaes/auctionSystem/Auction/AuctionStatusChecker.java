package com.dataBaes.auctionSystem.Auction;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Component
public class AuctionStatusChecker {

    private final AuctionRepository auctionRepository;

    public AuctionStatusChecker(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    @Scheduled(fixedRate = 2000) // run every 2 seconds
    @Transactional
    public void updateAuctionStatusIfStarted() {
        ZoneId philippineZone = ZoneId.of("Asia/Manila");
        ZonedDateTime now = ZonedDateTime.now(philippineZone);

        // Only update inactive auctions that should start
        List<AuctionEntity> auctionsToStart = auctionRepository.findInactiveAuctionsToStart(now.toLocalDateTime());

        for (AuctionEntity auction : auctionsToStart) {
            auction.setAuctionStatus(AuctionEntity.AuctionStatus.Ongoing);
            auctionRepository.save(auction);
        }
    }
    
    @Scheduled(fixedRate = 60000) // every 60 seconds
    @Transactional
    public void updateAuctionStatusIfEnded() {
        ZoneId philippineZone = ZoneId.of("Asia/Manila");
        ZonedDateTime now = ZonedDateTime.now(philippineZone);

        // Only update ongoing auctions that should end
        List<AuctionEntity> auctionsToEnd = auctionRepository.findOngoingAuctionsToEnd(now.toLocalDateTime());

        for (AuctionEntity auction : auctionsToEnd) {
            auction.setAuctionStatus(AuctionEntity.AuctionStatus.Ended);
            auction.setSoldAt(auction.getCurrentPrice().intValue());
            auctionRepository.save(auction);
        }
    }
}