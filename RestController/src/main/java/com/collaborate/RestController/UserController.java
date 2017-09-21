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

import com.collaborate.Dao.UserDao;
import com.collaborate.Model.User;

@RestController
public class UserController {
	

	
	@Autowired
	UserDao userDao;
	
	
	@GetMapping(value="/getAllUser")
	public ResponseEntity<ArrayList<User>>getAllUser() {
		
		ArrayList<User> listUsers= new ArrayList<User>();
		listUsers=(ArrayList<User>)userDao.getUsers();
		
		
		return new ResponseEntity<ArrayList<User>>(listUsers, HttpStatus.OK);
		
	}
	
	
	
	
	
	@PostMapping(value="/createUser")
	public ResponseEntity<String>createUser(@RequestBody User user)
	{
		user.setRole("user");
		user.setStatus("NA");
	
		
	 	if(userDao.insertUser(user))
	 	{
		return new ResponseEntity<String>("User table Created", HttpStatus.OK);
		} else
		{
		return new ResponseEntity<String>("Problem in Creation", HttpStatus.NOT_ACCEPTABLE);

		}
	}
	 	
	 	
	 @GetMapping(value="/ApproveUser/{userid}")
	 public ResponseEntity<String>Approveuser(@PathVariable ("userid") int userId)
	 {
		User user=userDao.getUser(userId); 
	  if(userDao.approveUser(user))	{ 
		return new ResponseEntity<String>("User Approved", HttpStatus.OK);
	  }else {
		return new ResponseEntity<String>("Problem in User Approval", HttpStatus.OK);  
	  }
	 }
	 
	 
	@GetMapping(value="/Delete/{userid}")
	public ResponseEntity<String>Delete(@PathVariable ("userid") int userId)
	{
		
	if(userDao.deleteUser(userId)) {
	return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	} else {
	 return new ResponseEntity<String>("Problem in Deletion", HttpStatus.OK);	
	}
	
	}

	
	
	
	
	
  @GetMapping("/user")
  public ResponseEntity<String>testMethosd()
  {
	  
	   return new ResponseEntity<String>("Create a User Table", HttpStatus.OK);
  }

}
