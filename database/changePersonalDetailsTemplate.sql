USE auction_system;

-- Create sample user forda testing
INSERT INTO Users (
  username, password, email, userStatus, if_admin, address, contactNo, name, schoolName, studentID, age, sex, profile_location
) VALUES (
  'Jensenauction_items', '1234', 'jensen@gmail.com', 'OFFLINE', true, '123 Main St', '0913245692', 'Jensen Santillan', 'NU Manila', '2023-1492', 24, 'Female', "userImages/550e8400-e29b-41d4-a716-446655440000.jpg"
);

INSERT INTO Users (
  username, password, email, userStatus, if_admin, address, contactNo, name, schoolName, studentID, age, sex, profile_location
) VALUES (
  'Matthew', '1234', 'matthew@gmail.com', 'OFFLINE', false, '123 Main St', '0913256713', 'Matthew Dwayne', 'NU Manila', '2022-1313', 20, 'Male', "userImages/523e6500-e13b-45r3-b346-563412340123.jpg"
);

-- Start the transaction, it will not be saved if you choose ROLLBACK, it will be applied it you choose COMMIT
START TRANSACTION;

-- Changing account details 
UPDATE Users
SET
  address = '456 Elm St',
  contactNo = 987654321,
  name = 'Johnathan Doe',
  schoolName = 'New Example University',
  age = 22
WHERE userID = '1';


-- ONLY RUN ONE LINE FROM THESE TWO, PICK ONE
-- If user wants to save account changes then
COMMIT;

-- If user wants to cancel changes then:
ROLLBACK;

-- View Changes
SELECT * FROM users;

-- If magtetest ulit, start na ulit sa transaction cause nainsert naman na si koya john doe