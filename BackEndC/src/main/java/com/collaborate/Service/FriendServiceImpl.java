package com.collaborate.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaborate.Dao.FriendDao;
import com.collaborate.Model.User;

@Service
public class FriendServiceImpl implements FriendService {

	@Autowired
	private FriendDao friendDao;
	
	public List<User> listOfSuggestedUsers(String username) {
     
		return friendDao.listOfSuggestedUsers(username);
	}

}
