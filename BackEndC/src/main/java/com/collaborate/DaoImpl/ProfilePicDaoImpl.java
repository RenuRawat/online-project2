package com.collaborate.DaoImpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaborate.Dao.ProfilePicDao;
import com.collaborate.Model.ProfilePicture;


@Repository("profilePicDao")
@Transactional
public class ProfilePicDaoImpl implements ProfilePicDao {

	@Autowired
	SessionFactory sessionFactory;
	public ProfilePicDaoImpl(SessionFactory sessionFactory) 
		{
			this.sessionFactory=sessionFactory;
		}

	
	public void uploadProfilePic(ProfilePicture profilePicture) {
	
	Session session=sessionFactory.getCurrentSession();
	session.saveOrUpdate(profilePicture);   //insert or update....
		
	}


	public ProfilePicture getProfilePic(String username) {
		Session session=sessionFactory.getCurrentSession();
		ProfilePicture profilepic=(ProfilePicture)session.get(ProfilePicture.class, username);
		return profilepic;
	}

}
