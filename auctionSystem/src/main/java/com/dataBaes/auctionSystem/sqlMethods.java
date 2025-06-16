package com.dataBaes.auctionSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service
public class sqlMethods {
	@Autowired
	private HttpSession session;
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	public Integer getUserIdByUsername(String username) {
        String sql = "SELECT userID FROM users WHERE username = ?";
        try {
            // queryForObject returns a single object, here Integer userID
            Integer userId = jdbcTemplate.queryForObject(sql, Integer.class, username);
            return userId;
        } catch (EmptyResultDataAccessException e) {
            // No user found with that username
            return null;
        }
    }
	
	public boolean confirmUserPassword(String username, String password, int userId)
	{
		String sql = "SELECT password FROM users WHERE userID=?";
		String passwordSaved = jdbcTemplate.queryForObject(sql, String.class, userId);

		if (password.equals(passwordSaved))
		{
			
			return true;
		}
		
		return false;
	}
	
	public boolean checkUsernameDuplicate(String username) // returns true if there is a duplicate
	{
		String sql = "SELECT COUNT(*) FROM users WHERE username = ?";
		Integer usernameCount = jdbcTemplate.queryForObject(sql, Integer.class, username);
		
		if(usernameCount > 0)
		{
			return true;
		}
		
		else
		{
			return false;
		}
		
	}
	
	public boolean checkIfAdmin(int userID) // returns true if there is a duplicate
	{
		String sql = "SELECT if_admin FROM users WHERE userID=?";
		boolean isAdmin = jdbcTemplate.queryForObject(sql, Boolean.class, userID);
		
		if(isAdmin == true)
		{
			return true;
		}
		
		else
		{
			return false;
		}
		
	}
	
	public boolean checkEmailDuplicate(String email)
	{
		String sql = "SELECT COUNT(*) FROM users WHERE email = ?";
		Integer emailCount = jdbcTemplate.queryForObject(sql, Integer.class, email);
		System.out.println("This code ran");
		if(emailCount > 0)
		{
			return true;
		}
		
		else
		{
			return false;
		}
		
	}
	
	public void setUserData(int userID)
	{
//		String username;                 // VARCHAR(50)
//		String password;                 // VARCHAR(50)
//		String email;                    // VARCHAR(50)
//		boolean if_admin;                // BOOLEAN
//		String address;                  // VARCHAR(50)
//		String contactNo;                // VARCHAR(50)
//		String name;                    // VARCHAR(50)
//		String schoolName;              // VARCHAR(50)
//		String studentID;               // VARCHAR(50)
//		String userStatus;
//		String sex;
//		
//		int age;                        // INT
		
		String sqlUsername = "SELECT username FROM users WHERE userID = ?";
		String username = jdbcTemplate.queryForObject(sqlUsername, String.class, userID);

		String sqlPassword = "SELECT password FROM users WHERE userID = ?";
		String password = jdbcTemplate.queryForObject(sqlPassword, String.class, userID);

		String sqlEmail = "SELECT email FROM users WHERE userID = ?";
		String email = jdbcTemplate.queryForObject(sqlEmail, String.class, userID);

		String sqlUserStatus = "SELECT userStatus FROM users WHERE userID = ?";
		String userStatus = jdbcTemplate.queryForObject(sqlUserStatus, String.class, userID);

		String sqlIfAdmin = "SELECT if_admin FROM users WHERE userID = ?";
		Boolean if_admin = jdbcTemplate.queryForObject(sqlIfAdmin, Boolean.class, userID);

		String sqlAddress = "SELECT address FROM users WHERE userID = ?";
		String address = jdbcTemplate.queryForObject(sqlAddress, String.class, userID);

		String sqlContactNo = "SELECT contactNo FROM users WHERE userID = ?";
		String contactNo = jdbcTemplate.queryForObject(sqlContactNo, String.class, userID);

		String sqlName = "SELECT name FROM users WHERE userID = ?";
		String name = jdbcTemplate.queryForObject(sqlName, String.class, userID);

		String sqlSchoolName = "SELECT schoolName FROM users WHERE userID = ?";
		String schoolName = jdbcTemplate.queryForObject(sqlSchoolName, String.class, userID);

		String sqlStudentID = "SELECT studentID FROM users WHERE userID = ?";
		String studentID = jdbcTemplate.queryForObject(sqlStudentID, String.class, userID);

		String sqlAge = "SELECT age FROM users WHERE userID = ?";
		int age = jdbcTemplate.queryForObject(sqlAge, Integer.class, userID);

		String sqlSex = "SELECT sex FROM users WHERE userID = ?";
		String sex = jdbcTemplate.queryForObject(sqlSex, String.class, userID);

		String sqlProfile = "SELECT profile_location FROM users WHERE userID = ?";
		String profile_location = jdbcTemplate.queryForObject(sqlProfile, String.class, userID);
		
		session.setAttribute("userID", userID);
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		session.setAttribute("email", email);
		session.setAttribute("userStatus", userStatus);
		session.setAttribute("if_admin", if_admin);
		session.setAttribute("address", address);
		session.setAttribute("contactNo", contactNo);
		session.setAttribute("name", name);
		session.setAttribute("schoolName", schoolName);
		session.setAttribute("studentID", studentID);
		session.setAttribute("age", age);
		session.setAttribute("sex", sex);
		session.setAttribute("profile_location", profile_location);
		

	}
	
	public String absolutePathUserUpload()
	{
		return "E:/Programming_Files/Java Spring Boot/auctionSystemWeb/auctionSystem/userUploads";
		
	}

	
}
