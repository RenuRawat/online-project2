package com.collaborate.Model;

import javax.persistence.Id;
import javax.persistence.Lob;

public class ProfilePic {
	
	@Id
	private String username;
	
	@Lob
	private byte[] image;

}
