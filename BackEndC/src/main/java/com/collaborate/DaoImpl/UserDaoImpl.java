package com.collaborate.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaborate.Dao.UserDao;
import com.collaborate.Model.User;


@Repository("userDao")
public class UserDaoImpl implements UserDao {

	
	@Autowired
	SessionFactory sessionFactory;
	
	public UserDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory=sessionFactory;
	}
	
	
	
	
	@Transactional
	public boolean insertUser(User user) {
		try 
		{
			Session session = sessionFactory.openSession();	
			session.save(user);	
			session.close();
		  System.out.println("Insert Table");

		return true;	
		} catch(Exception e)
		{
		System.out.println("Exception Arised:" +e);	
		return false;
		}

	}

	
	public User getUser(int userId) {
		Session session = sessionFactory.openSession();	
		User user = (User)session.get(User.class, userId);
		session.close();
		return user;
		
		}

	public List<User> getUsers() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from User where status='A'");
		List<User> listUser=query.list();
		session.close();
	
		return listUser;
	}

	@Transactional
	public boolean approveUser(User user) {
		try {
			user.setStatus("A");
			sessionFactory.getCurrentSession().save(user);	
			System.out.println("Approve");
			return true;
		} catch(Exception e) {
			System.out.println("Exception Arised:"+e); 
			return false;
		}
	}

	
	@Transactional
	public boolean updateUser(int userId) {
		 try
		  {
			
			 
		Session session = sessionFactory.openSession();	
		User user = (User)session.get(User.class, userId);
	
	    session.update(user);
		 System.out.println("Update the table");
		 session.close();
		 return true;
		  }
		  catch(Exception e) 
		  {
			 System.out.println("Exception Arised:"+e); 
			  return false; 
		  }
	}

	@Transactional
	public boolean deleteUser(int userId) {
		try {  
			Session session = sessionFactory.openSession();
			
			User user = (User)session.get(User.class, userId);
	        session.delete(user);
	        session.flush();
	        session.close();
	        return true;
	      } catch(Exception e) {
				System.out.println("Exception Arised:"+e); 
				return false;
			}
	}
}
