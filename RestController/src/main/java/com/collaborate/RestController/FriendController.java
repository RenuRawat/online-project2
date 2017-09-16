package com.collaborate.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FriendController {
	
	@GetMapping("/friend")
	public ResponseEntity<String>testMethod() {
		
		
		return new ResponseEntity<String>("Successfully!", HttpStatus.OK);
		
		
	}

}
