package com.dataBaes.auctionSystem.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dataBaes.auctionSystem.AuctionCreation.AuctionCreationEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
}