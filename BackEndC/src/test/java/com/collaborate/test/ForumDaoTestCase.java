package com.collaborate.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaborate.Dao.ForumDao;
import com.collaborate.Model.Forum;



public class ForumDaoTestCase {


	private static AnnotationConfigApplicationContext context;
	private static ForumDao forumDao;
	private static Forum forum;
	
	@BeforeClass
	public static void initialize()
	{
		
		context= new AnnotationConfigApplicationContext();
		context.scan("com.collaborate");
		context.refresh();
		
		forumDao =(ForumDao)context.getBean("forumDao");
	}
	//@Ignore
	@Test
	public void creatTableTest() {
	  Forum forum = new Forum();	
	  forum.setForumId(202);
	  System.out.println("add");
	  forum.setForumname("javaring");
	  System.out.println("add2");
	  forum.setForumcontent("samart technology");
	  System.out.println("add3");
	  forum.setCreateDate(new java.util.Date());
	  System.out.println("add4");
	  forum.setStatus("A");
	  System.out.println("add5");
	  forum.setUserId(110);
	  System.out.println("add6");
	  System.out.println("before Insert table");
	  assertTrue("Insert Table",forumDao.createForum(forum) );
	  System.out.println("after Insert table");
	}
	
	
	
	@Ignore
	@Test
	public void editForumTest()
	{  
		 Forum forum = new Forum();	
		 forum = forumDao.getForum(99);
		 
		  System.out.println("add");
		  forum.setForumname("javaring");
		  System.out.println("add2");
		  forum.setForumcontent("samart technology");
		  System.out.println("add3");
		  forum.setCreateDate(new java.util.Date());
		  System.out.println("add4");
		  forum.setStatus("A");
		  System.out.println("add5");
		  forum.setUserId(110);
		  System.out.println("add6");
		  System.out.println("before Insert table");
					
	    assertTrue("This will succeed", forumDao.editForum(99));
	}
	
	
	
	
	@Ignore
	@Test
	public void getForumTest(){
		forum = new Forum();
		forum = forumDao.getForum(112);
		
		
		assertEquals("This will succeed.", forumDao.getForum(112));
	//	assertEquals("Successful","Rest",blog.getBlogname());
	}
	
	@Ignore
	@Test
	public void approveForumTest()
	{
   
    
		
    Forum forum = new Forum();	
    forum = forumDao.getForum(114);	
    
	  System.out.println("add");
	  forum.setForumname("javaring");
	  System.out.println("add2");
	  forum.setForumcontent("samart technology");
	  System.out.println("add3");
	  forum.setCreateDate(new java.util.Date());
	  System.out.println("add4");
	  forum.setStatus("A");
	  System.out.println("add5");
	  forum.setUserId(110);
	  System.out.println("add6");
	  System.out.println("before Insert table");
		
	   assertTrue("This will succeed.", forumDao.approveForum(forum));

		}
	
	
	
	@Ignore
	@Test
	public void getAllapproveForumListTest()
	{
	
		List<Forum> listForum= forumDao.getForums();
		assertTrue("No Approved Forums", listForum.size()>0);
	}
	
	
	@Ignore
	@Test
	public void DeleteForumTest()
	{
		
		assertTrue("Problem in Deleting", forumDao.deleteForum(94));
		
}

	
	
	
	
	
	
/*	@Test
	public void test() {
		fail("Not yet implemented");
	}*/

}
