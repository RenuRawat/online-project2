package com.collaborate.RestController;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.collaborate.Model.Error;
import com.collaborate.Model.JobApplied;
import com.collaborate.Model.User;
import com.collaborate.Service.JobAppliedService;
import com.collaborate.Service.UserService;


@Controller
public class AppliedJobController 
{
	@Autowired
	private	UserService userService;
	
	@Autowired
	private JobAppliedService jobAppliedService;
	
	@PostMapping("/applyJob")	
	public ResponseEntity<?> applyNewJob(@RequestBody JobApplied jobApplied,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		if(username==null)
		{
			Error error=new Error(5,"Unauthorized access");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
	
		jobApplied.setPostedOn(new Date());
		jobApplied.setStatus('Y');
		 User applyBy=userService.getUserByUsername(username);
		 jobApplied.setApplyBy(applyBy); //applyBy is an object of type User
		 
		 try {
			 jobAppliedService.applyNewJob(jobApplied);
			return new ResponseEntity<JobApplied>(jobApplied,HttpStatus.OK);
		 } catch (Exception e) {
			 Error error=new Error(7,"Unable to save blog post details....");
			 return new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR); //exception
			
		 }
		
		
	}
	
}