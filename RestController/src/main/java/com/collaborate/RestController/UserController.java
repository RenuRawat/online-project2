package com.collaborate.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.collaborate.Model.User;
import com.collaborate.Service.UserService;
import com.collaborate.Model.Error;

//@RestController
@Controller
public class UserController {
	
	
@Autowired	
private UserService userService;	
	
    /*
     *  ? - Any type of data can be returned
     */



@PostMapping(value="/registeruser")
public ResponseEntity<?>registeruser(@RequestBody User user)
{     //validate username - unique
	
	if(!userService.isUsernameValid(user.getUsername())) { //username is duplicate
		Error error=new Error(2, "Username already exists....please enter different username");
		return new ResponseEntity<Error>(error, HttpStatus.NOT_ACCEPTABLE);
	}
	if(!userService.isEmailValid(user.getEmail())) {
		Error error=new Error(3,"Email address already exists....please enter different email");
		return new ResponseEntity<Error>(error, HttpStatus.NOT_ACCEPTABLE);
	}
	boolean result=userService.registerUser(user);
 	if(result)
 	{
	return new ResponseEntity<User>(user, HttpStatus.OK);   //200-299
	} else
	{
		Error error=new Error(1,"Unable to register user details");
	return new ResponseEntity<Error>(error, HttpStatus.INTERNAL_SERVER_ERROR); //500

	}
}



@PostMapping(value="/login")
public ResponseEntity<?>loginuser(@RequestBody User user)
{
	User validUser=userService.login(user);
 	if(validUser==null) // invalid username/password
 	{
 		Error error=new Error(4,"Invalid Username/Password....");
 	return new ResponseEntity<Error>(error, HttpStatus.UNAUTHORIZED); //401  error 2nd callback function
	  
	}
 	 // update the online status to true
		
	return new ResponseEntity<User>(validUser, HttpStatus.OK); //success 1st callback function

	
}



	/*@Autowired
	UserDao userDao;
	
	
	@GetMapping(value="/getAllUser")
	public ResponseEntity<ArrayList<User>>getAllUser() {
		
		ArrayList<User> listUsers= new ArrayList<User>();
		listUsers=(ArrayList<User>)userDao.getUsers();
		
		
		return new ResponseEntity<ArrayList<User>>(listUsers, HttpStatus.OK);
		
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

*/	
	
	
	
	
  @GetMapping("/user")
  public ResponseEntity<String>testMethosd()
  {
	  
	   return new ResponseEntity<String>("Create a User Table", HttpStatus.OK);
  }

}
