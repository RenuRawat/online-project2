package com.collaborate.RestController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.collaborate.Model.Error;
import com.collaborate.Model.Friend;
import com.collaborate.Model.User;
import com.collaborate.Service.FriendService;


@Controller
public class FriendController {
	
	@Autowired
	FriendService friendService;
	
	@GetMapping(value="/getsuggestedusers")
	public ResponseEntity<?>getSuggestedUsers(HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		if(username==null)
		{
			Error error=new Error(5,"Unauthorized access");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		
		List<User> suggestedUsers=friendService.listOfSuggestedUsers(username);
		return new ResponseEntity<List<User>>(suggestedUsers, HttpStatus.OK);
		
	}
		
	
	@GetMapping(value="/friendrequest/{toId}")
	public ResponseEntity<?>friendRequest(@PathVariable String toId, HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		if(username==null)
		{
			Error error=new Error(5,"Unauthorized access");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		Friend friend=new Friend();
		friend.setFromId(username);
		friend.setToId(toId);
		friend.setStatus('P');
		friendService.friendRequest(friend);     //insert into friend table
	    return new ResponseEntity<Friend>(friend, HttpStatus.OK);
	}
	
	
	@GetMapping(value="/pendingrequests")
	public ResponseEntity<?>pendingRequests(HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		if(username==null)
		{
			Error error=new Error(5,"Unauthorized access");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
	List<Friend> pendingRequests=friendService.pendingRequests(username);
	return new ResponseEntity<List<Friend>>(pendingRequests, HttpStatus.OK);
	}
	
	
	@PutMapping(value="/updatependingrequest")
	public ResponseEntity<?>updatePendingRequest(@RequestBody Friend friend, HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		if(username==null)
		{
			Error error=new Error(5,"Unauthorized access");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		System.out.println(friend.getFromId() + " " + friend.getStatus());
		friendService.updateFriendRequest(friend);   //update status to A or Delete the record.....
		return new ResponseEntity<Friend>(friend, HttpStatus.OK);
		
	}	

}
