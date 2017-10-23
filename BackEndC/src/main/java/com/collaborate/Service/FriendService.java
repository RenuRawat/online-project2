package com.collaborate.Service;

import java.util.List;

import com.collaborate.Model.User;

public interface FriendService {
	
	List<User> listOfSuggestedUsers(String username); 

}
