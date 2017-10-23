package com.collaborate.Dao;

import java.util.List;

import com.collaborate.Model.User;

public interface FriendDao {
	

	List<User> listOfSuggestedUsers(String username);   //logged in username


}
