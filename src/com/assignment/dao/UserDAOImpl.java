package com.assignment.dao;

import java.sql.Connection;

import com.assignment.models.User;
import com.assignment.utilities.DAOutilities;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAOImpl implements UserDAO {

	private PreparedStatement stmt;
	
	@Override
	public boolean createUser(User user) {
		String sql = "INSERT INTO users (Username, Email, Pswd) "
				+ "VALUES(?, ?, ?)";
		
		try(Connection connection = DAOutilities.getConnection()) {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());
			
			if (stmt.executeUpdate() != 0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public User findUserByUsername(String username) throws NullPointerException {
		
		User user = null;
		
		try(Connection connection = DAOutilities.getConnection()) {
			String sql = "SELECT * from users where Username = ? ";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, username);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				user = new User();
				user.setId(rs.getLong("userID"));
				user.setUsername(rs.getString("Username"));
				user.setEmail(rs.getString("Email"));
				user.setPassword(rs.getString("Pswd"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return user;
	}

}
