package com.collaborate.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaborate.Dao.FriendDao;
import com.collaborate.Model.Friend;


public class FriendDaoTestCase {
	
	
	
	private static AnnotationConfigApplicationContext context;
	private static FriendDao friendDao;
	private static Friend friend;
	
	@BeforeClass
	public static void initialize()
	{
		
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaborate");
		context.refresh();
		
		friendDao =(FriendDao)context.getBean("friendDao");
	}
	@Ignore
	@Test
	public void creatFriendTest() {
	  Friend friend = new Friend();	
	 
	  
	  friend.setFriendId(1023);
	  System.out.println("add1");
	  friend.setStatus("A");
	  System.out.println("add2");
	 
	 friend.setUserId(116);
	  
	  System.out.println("before Insert table");
	  
	  assertTrue("Insert Table",friendDao.createFriend(friend) );
	  System.out.println("after Insert table");
	}
	

	
	@Ignore
	@Test
	public void editFriendTest()
	{  
		
		friend = new Friend();
		friend = friendDao.getFriend(118);						
		
		System.out.println("add1");
		  friend.setStatus("A");
		  System.out.println("add2");
		 
		 friend.setUserId(116);
		  
		  System.out.println("before Insert table");
					
	    assertTrue("This will succeed", friendDao.editFriend(118));
	
	}
	
	
	
	
	@Ignore
	@Test
	public void getFriendTest(){
		friend = new Friend();
		friend = friendDao.getFriend(116);
		
		
		assertEquals("This will succeed.", friendDao.getFriend(116));

	}
	
	@Ignore
	@Test
	public void approveFriendTest()
	{
		Friend friend=new Friend();
		friend = friendDao.getFriend(12);
    
		
    System.out.println("add1");
	  friend.setStatus("A");
	  System.out.println("add2");
	 
	 friend.setUserId(116);
	  
	  System.out.println("before Insert table");
		
	   assertTrue("This will succeed.", friendDao.approveFriend(friend));

		}
	
	
	
	@Ignore
	@Test
	public void getAllapproveFriendListTest()
	{
	
		List<Friend> listFriend= friendDao.getFriends();
		assertTrue("No Approved Blogs", listFriend.size()>0);
	}
	
	
	@Ignore
	@Test
	public void DeleteFriendTest()
	{
		
		assertTrue("Problem in Deleting", friendDao.deleteFriend(91));
		
}

	
	
	
/*	@Test
	public void test() {
		fail("Not yet implemented");
	}*/

}
