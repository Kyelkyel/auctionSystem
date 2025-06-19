package com.dataBaes.auctionSystem;

import java.time.ZonedDateTime;
import java.time.ZoneId;

public class timeMethods {

    private static final ZoneId PHILIPPINE_ZONE = ZoneId.of("Asia/Manila");

    // Get current Philippine time
    public static ZonedDateTime getCurrentTime() {
        return ZonedDateTime.now(PHILIPPINE_ZONE);
    }

    // Check if auction has started (auctionStartTime <= now)
    public static boolean hasStarted(ZonedDateTime auctionStartTime) {
        return getCurrentTime().isAfter(auctionStartTime);
    }

    // Check if auction has ended (auctionEndTime <= now)
    public static boolean hasEnded(ZonedDateTime auctionEndTime) {
        return getCurrentTime().isAfter(auctionEndTime);
    }
}
