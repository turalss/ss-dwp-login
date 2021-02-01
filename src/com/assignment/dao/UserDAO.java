package com.assignment.dao;

import com.assignment.models.User;

public interface UserDAO {
	
	public boolean createUser(User user);
	public User findUserByUsername(String username);

}
