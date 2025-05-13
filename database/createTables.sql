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
contactNo INT,
name VARCHAR(50),
schoolName VARCHAR(50),
studentID INT,
age INT,
sex ENUM("Male", "Female", "Prefer Not To Say") NOT NULL,
ifStudentVerified BOOLEAN,

PRIMARY KEY (userID)

);

/* Auctioneer Side */
CREATE TABLE IF NOT EXISTS Auctioneer (
auctioneerID INT NOT NULL AUTO_INCREMENT UNIQUE,
userID INT,

PRIMARY KEY (auctioneerID),
FOREIGN KEY (userID) REFERENCES Users(userID)
);

CREATE TABLE IF NOT EXISTS Product_Verification(
verificationID INT NOT NULL AUTO_INCREMENT UNIQUE,
ifProductVerified BOOLEAN,

PRIMARY KEY (verificationID)
);


/* Bidder Side */
CREATE TABLE IF NOT EXISTS Bidder(
userID INT NOT NULL,
bidderID INT NOT NULL AUTO_INCREMENT UNIQUE,


FOREIGN KEY (userID) references Users(userID)
);

CREATE TABLE IF NOT EXISTS Bids(
bidID INT NOT NULL AUTO_INCREMENT UNIQUE,
bidderID INT NOT NULL,
bidAmount INT NOT NULL,
bidderPlace INT NOT NULL,
bidDate DATE,
bidTime DATE,

PRIMARY KEY (bidID),
FOREIGN KEY (bidderID) REFERENCES Bidder(bidderID)
);

CREATE TABLE IF NOT EXISTS Auction(
auctionID INT NOT NULL AUTO_INCREMENT UNIQUE,
verificationID INT NOT NULL,
auctioneerID INT NOT NULL,
auctionStartDate DATE NOT NULL,
auctionEndDate DATE NOT NULL,
auctionStatus ENUM("Ongoing", "Inactive", "Ended"),
consigneeName VARCHAR(50),
soldAt INT NOT NULL,
product_img VARCHAR(50),
initialBidPrice INT NOT NULL,
category ENUM("Clothes", "Accessories") NOT NULL,

PRIMARY KEY (auctionID),
FOREIGN KEY (verificationID) REFERENCES Product_Verification(verificationID),
FOREIGN KEY (auctioneerID) references Auctioneer(auctioneerID)
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
