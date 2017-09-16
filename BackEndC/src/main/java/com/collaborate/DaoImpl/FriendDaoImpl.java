package com.collaborate.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaborate.Dao.FriendDao;
import com.collaborate.Model.Friend;


@Repository("friendDao")
public class FriendDaoImpl implements FriendDao {

	
	@Autowired
	SessionFactory sessionFactory;
	
	public FriendDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory=sessionFactory;
	}
	
	
	
	
	@Transactional
	public boolean createFriend(Friend friend) {
		try {
			sessionFactory.getCurrentSession().save(friend);
			return true;
		} catch(Exception e) {
		System.out.println("Exception Arised:" +e);
		return false;
		}
	}

	@Transactional
	public Friend getFriend(int friendId) {
		return (Friend) sessionFactory.getCurrentSession().get(Friend.class, friendId);
	}

	@Transactional
	public List<Friend> getFriends() {

		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from FriendTable where status='A'");
		List<Friend> listFriend=query.list();
		session.close();
	
		return listFriend;
	}

	@Transactional
	public boolean approveFriend(Friend friend) {
		try {
			friend.setStatus("A");
			sessionFactory.getCurrentSession().save(friend);	
			System.out.println("Approve");
			return true;
		} catch(Exception e) {
			System.out.println("Exception Arised:"+e); 
			return false;
		}
		

	}

	@Transactional
	public boolean editFriend(int friendId) {
		 try
		  {
			
			 
		Session session = sessionFactory.openSession();	
		Friend friend = (Friend)session.get(Friend.class, friendId);
	
	    session.update(friend);
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
	public boolean deleteFriend(int friendId) {
		try {  
			Session session = sessionFactory.openSession();
			
			Friend friend = (Friend)session.get(Friend.class, friendId);
	        session.delete(friend);
	        session.flush();
	        session.close();
	        return true;
	      } catch(Exception e) {
				System.out.println("Exception Arised:"+e); 
				return false;
			}
	}

}
