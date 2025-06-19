DROP SCHEMA IF EXISTS auction_system;

CREATE DATABASE IF NOT EXISTS auction_system;
USE auction_system;

CREATE TABLE IF NOT EXISTS Users (
userID INT NOT NULL AUTO_INCREMENT UNIQUE,
username VARCHAR(50),
password VARCHAR(50),
email VARCHAR(50),
userStatus ENUM("ONLINE", "OFFLINE") NOT NULL,
if_admin BOOLEAN,
address VARCHAR(50),
contactNo VARCHAR(15),
name VARCHAR(50),
schoolName VARCHAR(50),
studentID VARCHAR(50),
age INT,
sex ENUM('Male', 'Female', 'Prefer_Not_To_Say') NOT NULL,
profile_location VARCHAR(255),

PRIMARY KEY (userID)

);

-- /* Auctioneer Side */
-- CREATE TABLE IF NOT EXISTS Auctioneer (
-- auctioneerID INT NOT NULL AUTO_INCREMENT UNIQUE,
-- userID INT,

-- PRIMARY KEY (auctioneerID),
-- FOREIGN KEY (userID) REFERENCES Users(userID)
-- );

-- CREATE TABLE IF NOT EXISTS Product_Verification(
-- verificationID INT NOT NULL AUTO_INCREMENT UNIQUE,
-- ifProductVerified BOOLEAN,

-- PRIMARY KEY (verificationID)
-- );


/* Bidder Side */
-- CREATE TABLE IF NOT EXISTS Bidder(
-- userID INT NOT NULL,
-- bidderID INT NOT NULL AUTO_INCREMENT UNIQUE,

-- FOREIGN KEY (userID) references Users(userID)
-- );




CREATE TABLE auction_items (
	userID INT NOT NULL,
    auctionItem_ID INT AUTO_INCREMENT PRIMARY KEY,
    item_image VARCHAR(255),            -- store image filename or path
    item_title VARCHAR(255) NOT NULL,
    item_description TEXT NOT NULL,
    item_category VARCHAR(100) NOT NULL,
    start_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL,
    starting_bid DECIMAL(10, 2) NOT NULL,
    seller_info_name VARCHAR(255) NOT NULL,
    seller_info_email VARCHAR(255) NOT NULL,
    seller_info_phone VARCHAR(50) NOT NULL,
    seller_info_location VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	isVerified BOOLEAN NOT NULL,
    
    FOREIGN KEY (userID) references Users(userID)
);

CREATE TABLE IF NOT EXISTS Auction (
  auctionID INT NOT NULL AUTO_INCREMENT UNIQUE,
  auctionItem_ID INT NOT NULL,
  auctionStatus ENUM('Ongoing', 'Inactive', 'Ended'),
  soldAt INT NOT NULL,
  current_price DOUBLE NOT NULL DEFAULT 0,

  PRIMARY KEY (auctionID),
  FOREIGN KEY (auctionItem_ID) REFERENCES auction_items(auctionItem_ID)
);

CREATE TABLE IF NOT EXISTS Bids(
bidID INT NOT NULL AUTO_INCREMENT UNIQUE,
userID INT NOT NULL,
auctionID INT NOT NULL,
bidAmount INT NOT NULL,
bidderPlace INT NOT NULL,
bidDateTime DATETIME,

PRIMARY KEY (bidID),
FOREIGN KEY (userID) REFERENCES Users(userID),
FOREIGN KEY (auctionID) REFERENCES Auction(auctionID)
);

CREATE TABLE IF NOT EXISTS Auctioneer_History(
auctioneerHistoryID INT NOT NULL AUTO_INCREMENT UNIQUE,
auctionID INT NOT NULL,

PRIMARY KEY (auctioneerHistoryID),
FOREIGN KEY (auctionID) references Auction(auctionID)
);

CREATE TABLE IF NOT EXISTS Bidder_History(
bidHistoryID INT NOT NULL AUTO_INCREMENT UNIQUE,
auctionID INT NOT NULL,
bidID INT NOT NULL,

PRIMARY KEY (bidHistoryID),
FOREIGN KEY (auctionID) REFERENCES Auction(auctionID),
FOREIGN KEY (bidID) REFERENCES Bids(bidID)
);

-- Create sample user forda testing
INSERT INTO Users (
  username, password, email, userStatus, if_admin, address, contactNo, name, schoolName, studentID, age, sex, profile_location
) VALUES (
  'Jensen', '1234', 'jensen@gmail.com', 'OFFLINE', true, '123 Main St', '0913245692', 'Jensen Santillan', 'NU Manila', '2023-1492', 24, 'Female', "userImages/550e8400-e29b-41d4-a716-446655440000.jpg"
);

INSERT INTO Users (
  username, password, email, userStatus, if_admin, address, contactNo, name, schoolName, studentID, age, sex, profile_location
) VALUES (
  'Matthew', '1234', 'matthew@gmail.com', 'OFFLINE', false, '123 Main St', '0913256713', 'Matthew Dwayne', 'NU Manila', '2022-1313', 20, 'Male', "userImages/523e6500-e13b-45r3-b346-563412340123.jpg"
);

INSERT INTO Users (
  username, password, email, userStatus, if_admin, address, contactNo, name, schoolName, studentID, age, sex, profile_location
) VALUES (
  'Myckle', '1234', 'myckle@gmail.com', 'OFFLINE', false, '123 Main St Manila', '0912346743', 'Myckle Vince', 'NU Manila', '2022-1433', 20, 'Male', "userImages/523e6500-e13b-45r3-b346-563412340123.jpg"
);


INSERT INTO Users (
  username, password, email, userStatus, if_admin, address, contactNo, name, schoolName, studentID, age, sex, profile_location
) VALUES (
  'Myckle', '1234', 'myckle@gmail.com', 'OFFLINE', false, '123 Main St Manila', '0912346743', 'Myckle Vince', 'NU Manila', '2022-1433', 20, 'Male', "userImages/523e6500-e13b-45r3-b346-563412340123.jpg"
);


INSERT INTO Bids (userID, auctionID, bidAmount, bidderPlace, bidDateTime)
VALUES (1, 1, 1, 1, '2025-06-17 14:30:00');


SELECT * FROM Users;
SELECT * FROM auction_items;
SELECT * FROM Auction;
SELECT * FROM Bids;
