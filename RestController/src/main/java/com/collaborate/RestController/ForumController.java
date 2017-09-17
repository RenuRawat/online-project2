package com.collaborate.RestController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import com.collaborate.Model.Forum;
import com.collaborate.Dao.ForumDao;

@RestController
public class ForumController {

	@Autowired
	ForumDao forumDao;
	
	@GetMapping(value="/getAllForums")
	public ResponseEntity<ArrayList<Forum>> getAllForums()
	{
		
		ArrayList<Forum> listForum= new ArrayList<Forum>();
		listForum=(ArrayList<Forum>)forumDao.getForums();
		
		return new ResponseEntity<ArrayList<Forum>>(listForum, HttpStatus.OK);
		
			}
	
	
	
	
	@GetMapping("/forum")
	public ResponseEntity<String>testMethod()
	{
		return new ResponseEntity<String>("TestController", HttpStatus.OK);
	}
	
}
