USE auction_system;

-- Create sample user forda testing
INSERT INTO Users (
  username, password, email, userStatus, if_admin, address, contactNo, name, schoolName, studentID, age, sex, ifStudentVerified
) VALUES (
  'johndoe', 'securePass123', 'johndoe@example.com', 'ONLINE', FALSE, '123 Main St', 1234567890, 'John Doe', 'Example University', 2023456, 21, 'Male', TRUE
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