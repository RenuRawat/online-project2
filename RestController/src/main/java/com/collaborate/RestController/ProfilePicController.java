package com.collaborate.RestController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.collaborate.Model.Error;
import com.collaborate.Model.ProfilePicture;
import com.collaborate.Service.ProfilePicService;

@Controller
public class ProfilePicController {

	@Autowired
	private ProfilePicService profilePicService;
	
	
	/*
	 *  <input type="file" name="image">
	 *  
	 */
	
	@PostMapping(value="/uploadprofilepic")
	public ResponseEntity<?> uploadProfilePic(@RequestParam CommonsMultipartFile image, HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		if(username==null)
		{
			Error error=new Error(5,"Unauthorized access");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
	 
		// profilepic object used  for data in db table....
	 ProfilePicture profilePicture=new ProfilePicture();
	 profilePicture.setUsername(username);
	 profilePicture.setImage(image.getBytes());
	 
	 // call the service then call dao....
	 profilePicService.uploadProfilePic(profilePicture);
	 return new ResponseEntity<ProfilePicture>(profilePicture, HttpStatus.OK);
	}
	
}
