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

    @Scheduled(fixedRate = 10000) // run every 60 seconds
    @Transactional
    public void updateAuctionStatusIfStarted() {
        ZoneId philippineZone = ZoneId.of("Asia/Manila");
        ZonedDateTime now = ZonedDateTime.now(philippineZone);

        // Fetch auctions that are not started yet and whose start time is <= now
        List<AuctionEntity> auctionsToStart = auctionRepository.findAuctionsToStart(now.toLocalDateTime());

        for (AuctionEntity auction : auctionsToStart) {
            auction.setAuctionStatus(AuctionEntity.AuctionStatus.Ongoing);
            auctionRepository.save(auction);
        }
    }
    
    @Scheduled(fixedRate = 10000) // every 60 seconds
    @Transactional
    public void updateAuctionStatusIfEnded() {
        ZoneId philippineZone = ZoneId.of("Asia/Manila");
        ZonedDateTime now = ZonedDateTime.now(philippineZone);

        List<AuctionEntity> auctionsToEnd = auctionRepository.findAuctionsToEnd(now.toLocalDateTime());

        for (AuctionEntity auction : auctionsToEnd) {
            auction.setAuctionStatus(AuctionEntity.AuctionStatus.Ended);
            auctionRepository.save(auction);
        }
    }

}
