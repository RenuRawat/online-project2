package com.collaborate.RestController;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.collaborate.Model.Error;
import com.collaborate.Model.Job;
import com.collaborate.Model.User;
import com.collaborate.Service.JobService;
import com.collaborate.Service.UserService;

@RestController
public class JobController {
	
@Autowired
private	UserService userService;
	
@Autowired	
private JobService jobService;	
	
	

@PostMapping(value="/addjob")
public ResponseEntity<?> addJob(@RequestBody Job job,HttpSession session)
{
	String username=(String)session.getAttribute("username");
	if(username==null)
	{
		Error error=new Error(5,"Unauthorized access");
		return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
	}
	
 User user=userService.getUserByUsername(username);
 if(!user.getRole().equals("ADMIN")) 
 {	 
	 Error error=new Error(6,"Access Denied");
	 return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
 }	 
 try {
	 jobService.addJob(job);
	return new ResponseEntity<Job>(job,HttpStatus.OK);
 } catch (Exception e) {
	 Error error=new Error(7,"Unable to insert job details....");
	 return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE); //exception
	
 }
}
	
	
	

}
