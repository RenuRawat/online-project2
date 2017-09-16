package com.collaborate.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobsController {
	
	@GetMapping("/job")
	public ResponseEntity<String>testMetod() {
		
		return new ResponseEntity<String>("Created", HttpStatus.OK);
	}

}
