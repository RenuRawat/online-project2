package com.collaborate.RestController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collaborate.Dao.FriendDao;
import com.collaborate.Model.Friend;


@RestController
public class FriendController {
	
	@GetMapping("/friend")
	public ResponseEntity<String>testMethod() {
		
		
		return new ResponseEntity<String>("Successfully!", HttpStatus.OK);
		
	}
		
	@Autowired
	FriendDao friendDao;
	
	
	@GetMapping(value="/getAllFriend")
	public ResponseEntity<ArrayList<Friend>>getAllFriend() {
		
		ArrayList<Friend> listFriend=new ArrayList<Friend>();
		listFriend=(ArrayList<Friend>)friendDao.getFriends();
		
		return new ResponseEntity<ArrayList<Friend>>(listFriend, HttpStatus.OK);
		
	}
		
	
	@PostMapping(value="/createFriend")
	public ResponseEntity<String>createFriend(@RequestBody Friend friend) {
		friend.setStatus("NA");
		if(friendDao.createFriend(friend))
		{
		return new ResponseEntity<String>("Friend table Created", HttpStatus.OK);
		} else
		{
		return new ResponseEntity<String>("Problem in Creation", HttpStatus.NOT_ACCEPTABLE);

		}
	}
	
	
	
	@GetMapping(value="/approveFriend/{friendid}")
	public ResponseEntity<String>approveFriend(@PathVariable ("friendid") int friendId)
	{
	 Friend frnd=friendDao.getFriend(friendId);	
	 if(friendDao.approveFriend(frnd))
		{
			return new ResponseEntity<String>("Blog Approved",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in Blog Approval",HttpStatus.NOT_ACCEPTABLE);
		}				 
	}
	
	
	@GetMapping(value="DeleteFriend/{friendid}")
	public ResponseEntity<String>DeleteFriend(@PathVariable ("friendid") int friendId)
	{
		if(friendDao.deleteFriend(friendId))
		{
			return new ResponseEntity<String>("Friend detail Deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Problem in Deletion", HttpStatus.NOT_ACCEPTABLE);
		}
	}
	

}
