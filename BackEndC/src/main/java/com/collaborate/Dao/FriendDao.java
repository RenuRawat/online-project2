package com.collaborate.Dao;

import java.util.List;

import com.collaborate.Model.Friend;
import com.collaborate.Model.User;

public interface FriendDao {
	

List<User> listOfSuggestedUsers(String username);   //logged in username
void friendRequest(Friend friend);

List<Friend> pendingRequests(String toId);

void updatePendingRequest(Friend friend);

List<String> listOfFriends(String username);

}
