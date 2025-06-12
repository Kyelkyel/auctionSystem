package com.dataBaes.auctionSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class sqlMethods {
	
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
	
}
