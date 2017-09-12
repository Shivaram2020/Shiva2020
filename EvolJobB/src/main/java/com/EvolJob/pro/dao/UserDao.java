package com.EvolJob.pro.dao;

import com.EvolJob.pro.model.User;



public interface UserDao {
	void registerUser(User user);
	User validateUsername(String username);
	User validateEmail(String email);
	User login(User user);
	void update(User user);
	User getUserByUsername(String username);

}