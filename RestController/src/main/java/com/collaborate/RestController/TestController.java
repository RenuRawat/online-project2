package com.collaborate.RestController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	
	
	
	

 @RequestMapping(value = {"/","/index"})
  public String index() {
  return "index";
	}

}
