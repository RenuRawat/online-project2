package com.collaborate.RestController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.collaborate.Model.Error;
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
		
	
	
	
	

}
