package com.collaborate.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	
  @GetMapping("/user")
  public ResponseEntity<String>testMethosd()
  {
	  
	   return new ResponseEntity<String>("Create a User Table", HttpStatus.OK);
  }

}
