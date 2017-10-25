package com.collaborate.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.StandardBasicTypes;
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
		Query query=session.createQuery("from Friend where toId=? and status='P' ");
		query.setString(0, toId);
		return query.list();
	}





	public void updatePendingRequest(Friend friend) {
		Session session=sessionFactory.getCurrentSession();
		if(friend.getStatus()=='A')
			session.update(friend);   //update Friend set status='A' where id=?
		else
			session.delete(friend);   //delete from Friend where id=?
		
	}



/* List<String> use for SqlQuery for all friend list without all friend property obj...it return string....("gfdgf,gfh,fg")
	List<Friend> use for hibernateQuery for all friend list with friend obj.....return all detail
	*/

	public List<String> listOfFriends(String username) {
		Session session=sessionFactory.getCurrentSession();
		SQLQuery sqlQuery1=session.createSQLQuery("select fromId from FriendTable where toId=? and status='A' ")
				.addScalar("fromId", StandardBasicTypes.STRING);
		sqlQuery1.setString(0, username);
		List<String> list1=sqlQuery1.list();
		
		System.out.println("RESULT Of 1st QUERY" +list1);
		
		SQLQuery sqlQuery2=session.createSQLQuery("select toId from FriendTable where fromId=? and status='A' ")
				.addScalar("toId", StandardBasicTypes.STRING);
		sqlQuery2.setString(0, username);
		List<String> list2=sqlQuery2.list();
		System.out.println("RESULT Of 2st QUERY" +list2);
		
		list1.addAll(list2);  //list1=list1 U list2
		System.out.println("RESULT Of list1 + list2 " +list1);
		
		return list1;
	}

	

}
