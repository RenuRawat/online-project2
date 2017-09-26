package com.collaborate.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
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
		
		
/*	
			
			System.out.println("Admin");
			assertTrue("userDetails",userDao.insertUser(user));
			System.out.println("Table");
//			assertTrue("This will succeed.", userDao.createUser(user));

		}*/
		
	//	@Ignore
		@Test
		public void insertUserTestCase() {
			
			User user = new User();
					
		//	user.setBirthDate(LocalDate.parse("1994-04-09"));
			user.setUsername("renu");
		//	user.setUserId(1003);
			
			user.setEmail("renu@gmail.com");
					
			user.setFirstname("Renu");
			user.setSurname("Rawat");
		//	user.setGender('F');
			user.setPasswword("renu");
			user.setPhone("9876543210");
		//	user.setStatus("A");
			user.setIsOnline(false);
			
			user.setRole("ADMIN");
		//	user.setConfmemail("renu@gmail.com");
		//	user.setConfpassword("renu");
			
			System.out.println("user printed");
			assertEquals("successfully!", Boolean.valueOf(true), userDao.registerUser(user));
			System.out.println("After User Table");
			
	}
		
		
		
	/*	
		@Ignore
		@Test
		public void updateUserTest()
		{  
			
			user = new User();
			user = userDao.getUser(99);						
			
						
			user.setBirthDate(LocalDate.parse("1994-04-09"));
			user.setEmail("renu@gmail.com");
					
			user.setFirstname("Renu");
			user.setSurname("Rawat");
			user.setGender('F');
			user.setPasswword("renu");
			user.setPhone("9876543210");
			user.setStatus("A");
			user.setIsOnline(false);
			
			user.setRole("ADMIN");
			user.setConfmemail("renu@gmail.com");
			user.setConfpassword("renu");
			
			System.out.println("Admin");
						
		    assertTrue("This will succeed", userDao.updateUser(99));
		
		}
		
		
		
		@Ignore
		@Test
		public void getUserTest(){

			
			
			assertNotNull("Problem getting blog",userDao.getUser(204));
	
		}
		
		//@Ignore
		@Test
		public void approveUserFormTest()
		{
			User user=new User();
        
			
			user = userDao.getUser(304);
        
		
			user.setBirthDate(LocalDate.parse("1994-04-09"));
			user.setEmailId("renu@gmail.com");
					
			user.setFirstname("Renu");
			user.setSurname("Rawat");
			user.setGender('F');
			user.setPasswword("renu");
			user.setPhone("9876543210");
			user.setStatus("A");
			user.setIsOnline(false);
			
			user.setRole("ADMIN");
			user.setConfmemail("renu@gmail.com");
			user.setConfpassword("renu");
	
		
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

		*/
		

}
