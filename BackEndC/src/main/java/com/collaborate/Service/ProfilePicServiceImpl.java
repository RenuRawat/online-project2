package com.collaborate.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaborate.Dao.ProfilePicDao;
import com.collaborate.Model.ProfilePicture;


@Service
public class ProfilePicServiceImpl implements ProfilePicService {
	
	@Autowired
	private ProfilePicDao profilePicDao;

	public void uploadProfilePic(ProfilePicture profilePicture) {
		profilePicDao.uploadProfilePic(profilePicture);
		
		
	}

	public ProfilePicture getProfilePicture(String username) {
		return profilePicDao.getProfilePic(username);
	}

}
