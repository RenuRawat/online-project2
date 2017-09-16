package com.collaborate.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaborate.Dao.UserDao;
import com.collaborate.Model.User;


public class UserDaoTestCase {

	
	private static AnnotationConfigApplicationContext context;
	private static UserDao userDao;
	private User user;
	
		@BeforeClass
		public static void initialize()
		{
			context= new AnnotationConfigApplicationContext();
			context.scan("com.collaborate");
			context.refresh();
			
			System.out.println("Before");
			userDao=(UserDao)context.getBean("userDao");
			System.out.println("After");
		}
		
		
	//	@Ignore
		@Test
		public void insertUsertTest() 
		{
			User user=new User();
			
			user.setId(2005);
			System.out.println("Id");
			user.setFirstname("Ja");
			System.out.println("ja");
			user.setLastname("OOa");
			System.out.println("ooa");
			user.setPasswword("rennu");
			System.out.println("renu");
			user.setEmailId("awp@gmail.com");
			System.out.println("gmail");
			user.setStatus("n");
			System.out.println("n");
			user.setOnline("n");
			System.out.println("n2");
			user.setRole("Admin");
			
			System.out.println("Admin");
			assertTrue("userDetails",userDao.insertUser(user));
			System.out.println("Table");
//			assertTrue("This will succeed.", userDao.createUser(user));

		}
		
		
		
		@Ignore
		@Test
		public void updateUserTest()
		{  
			
			user = new User();
			user = userDao.getUser(99);						
			
			user.setFirstname("Ja");
			System.out.println("ja");
			user.setLastname("OOa");
			System.out.println("ooa");
			user.setPasswword("rennu");
			System.out.println("renu");
			user.setEmailId("awp@gmail.com");
			System.out.println("gmail");
			user.setStatus("n");
			System.out.println("n");
			user.setOnline("n");
			System.out.println("n2");
			user.setRole("Admin");
			
			System.out.println("Admin");
						
		    assertTrue("This will succeed", userDao.updateUser(99));
		
		}
		
		
		
		@Ignore
		@Test
		public void getUserTest(){

			
			
			assertNotNull("Problem getting blog",userDao.getUser(204));
	
		}
		
		@Ignore
		@Test
		public void approveUserFormTest()
		{
			User user=new User();
        
			
			user = userDao.getUser(102);
        
			user.setFirstname("Ja");
		System.out.println("ja");
		user.setLastname("OOa");
		System.out.println("ooa");
		user.setPasswword("rennu");
		System.out.println("renu");
		user.setEmailId("awp@gmail.com");
		System.out.println("gmail");
		user.setStatus("n");
		System.out.println("n");
		user.setOnline("n");
		System.out.println("n2");
		user.setRole("Admin");
		
		System.out.println("Admin");
			
		   assertTrue("This will succeed.", userDao.approveUser(user));

			}
		
		
		
		@Ignore
		@Test
		public void getAllapproveuserFormListTest()
		{
		
			List<User> listUser= userDao.getUsers();
			assertTrue("No Approved Blogs", listUser.size()>0);
		}
		
		
		@Ignore
		@Test
		public void DeleteUserTest()
		{
			
			assertTrue("Problem in Deleting", userDao.deleteUser(93));
			
}

		
		

}
