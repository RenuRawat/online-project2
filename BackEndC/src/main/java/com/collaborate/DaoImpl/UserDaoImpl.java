package com.collaborate.DaoImpl;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaborate.Dao.UserDao;
import com.collaborate.Model.BlogPost;
import com.collaborate.Model.User;


@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

	
	@Autowired
	SessionFactory sessionFactory;
	
	public UserDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory=sessionFactory;
	}
	
	/*
	 * username must be unique and not null
	 * email must be unique and not null
	 * email is null/username is null - it is an exception
	 */
	
	
	
@Transactional
	public boolean registerUser(User user) {
/*		sessionFactory.getCurrentSession().persist(user);
		System.out.println("User Table inserted");
		return true;*/
		
			Session session = sessionFactory.getCurrentSession();	
			try 
			{
			session.save(user);	
			
			
		  System.out.println("Insert User Table");
		return true;	
			}
		catch(Exception e)
		{
		System.out.println("Exception Arised:" +e);	
		return false;
		}

	}

	
	public boolean isUsernameValid(String username) {
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class, username);
		if(user==null) //no rows selected - unique
			return true;
		else  // not null - 1 row selected - duplicate
		return false;
	}


	public boolean isEmailValid(String email) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User where email=?");
		query.setString(0, email);
		User user=(User)query.uniqueResult();
		if(user==null) //email is unique
			return true;
		else  // email is duplicate
		return false;
	}


	public User login(User user) {
	    Session session=sessionFactory.getCurrentSession();
	    System.out.println("0");
	    Query query=session.createQuery("from User where username=? and password=?");
	    System.out.println("1");
	    query.setString(0, user.getUsername());
	    System.out.println("2");
	    query.setString(1, user.getPassword());
	    System.out.println("3");
	    user=(User) query.uniqueResult();
	    System.out.println("4");
	    return user;
	}

	
	public void update(User user) {
		Session session=sessionFactory.getCurrentSession();
		session.update(user); //update set online=1, firstname=..lastname=... where username=? will same...only changing in online status
		
	}

	
	public User getUserByUsername(String username) {
		Session session=sessionFactory.getCurrentSession();
		 User user =(User) session.get(User.class, username);
		  return user;
	
	}

	
	public boolean isUpdatedEmailValid(String email, String username) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User where email=? and username!=?");
		query.setString(0, email);
		query.setString(1, username);
		User user =(User)query.uniqueResult();
		if(user==null)
			return true;
		else
		    return false;
	}

	public User getUsernameByUsername(String username) {
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class, username);
		return user;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

/*	
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
	}*/

	
/*	@Transactional
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
	}*/

/*	@Transactional
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
*/



/*	@Transactional
	public void updateUserOnline(User user) {
		String updateQuery = "UPDATE User SET isOnline = :isOnline WHERE userId = :userId";
		Query q = sessionFactory.getCurrentSession().createQuery(updateQuery);
		q.setParameter("userId", user.getUserId());
		q.setParameter("isOnline", user.getIsOnline());		
		try {
			q.executeUpdate();	
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
} 
	}*/
}
