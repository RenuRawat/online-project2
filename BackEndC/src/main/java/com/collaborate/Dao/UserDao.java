package com.collaborate.Dao;

import java.util.List;

import com.collaborate.Model.User;





public interface UserDao {
	
	public boolean insertUser(User user);
	
	public User getUser(int userId);
	
	public List<User> getUsers();
	
	public boolean approveUser(User user);
	
	public boolean updateUser(int userId);
	
	public boolean deleteUser(int userId);

}
