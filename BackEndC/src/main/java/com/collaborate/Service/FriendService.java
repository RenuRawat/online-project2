package com.collaborate.Service;

import java.util.List;

import com.collaborate.Model.Friend;
import com.collaborate.Model.User;

public interface FriendService {
	
List<User> listOfSuggestedUsers(String username);
void friendRequest(Friend friend);

List<Friend> pendingRequests(String toId);

void updateFriendRequest(Friend friend);

List<String> listOfFriends(String username);

}
