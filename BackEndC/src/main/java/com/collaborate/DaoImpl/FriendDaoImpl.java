package com.collaborate.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaborate.Dao.FriendDao;
import com.collaborate.Model.Friend;
import com.collaborate.Model.User;

@Transactional
@Repository("friendDao")
public class FriendDaoImpl implements FriendDao {

	
	@Autowired
	SessionFactory sessionFactory;
	
	public FriendDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory=sessionFactory;
	}
	
	



	public List<User> listOfSuggestedUsers(String username) {
		Session session=sessionFactory.getCurrentSession();
		SQLQuery query=session.createSQLQuery("select  * from admintable where username in "
				+ "(select username from admintable where username!=? minus "
				+ "(select fromId from friendtable where toId=? "
				+ "union select toId from friendtable where fromId=? )"
				+ ")");
		query.setString(0, username);
		query.setString(1, username);
		query.setString(2, username);
		query.addEntity(User.class);  //to convert records to User Objects
		List<User> suggestedUsers=query.list();
		return suggestedUsers;  //List<User>
	}





	public void friendRequest(Friend friend) {
	Session session=sessionFactory.getCurrentSession();
	session.save(friend);		
	}


	public List<Friend> pendingRequests(String toId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Friend where toId=? and status='P'");
		query.setString(0, toId);
		return query.list();
	}

	

}
