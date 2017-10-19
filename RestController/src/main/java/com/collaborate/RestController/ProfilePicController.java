package com.collaborate.RestController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	
	@GetMapping(value="/getimage/{username}")
	public @ResponseBody byte[] getProfilePic(@PathVariable String username, HttpSession session)
	{
		String logInUsername=(String)session.getAttribute("username");
		if(logInUsername==null) 
		{  
			return null;
		}
	      //	profilepic obj use for data in db table
		ProfilePicture profilepic=profilePicService.getProfilePicture(username);
		 if(profilepic==null)  // no profilepic for the logged in user
		 return null;
		 else
			 return profilepic.getImage(); //image of the user
			 
		 }
			
	
}
