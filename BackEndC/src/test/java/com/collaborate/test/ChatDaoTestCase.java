package com.collaborate.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaborate.Dao.ChatDao;
import com.collaborate.Model.Chat;




public class ChatDaoTestCase {

	
	
	private static AnnotationConfigApplicationContext context;
	private static ChatDao chatDao;
	private static Chat chat;
	
	@BeforeClass
	public static void initialize()
	{
		
		context= new AnnotationConfigApplicationContext();
		context.scan("com.collaborate");
		context.refresh();
		System.out.println("Before");
		chatDao =(ChatDao)context.getBean("chatDao");
		System.out.println("After");
	}
	
	
	
	
	@Test
	public void createUserTest() 
	{
		Chat chat=new Chat();
		
		chat.setChatId(204);
		System.out.println("Id");
		chat.setChatname("Ja");
		System.out.println("ja");
		chat.setCreateDate(new java.util.Date());
		System.out.println("ooa");
		chat.setUserId(45);
		System.out.println("userId");
		
			
		assertTrue("chatDetails",chatDao.createChat(chat));
		System.out.println("Table");


	}
	
	
	@Ignore
	@Test
	public void getChatTest(){
		chat = new Chat();
		chat = chatDao.getChat(97);
		
		
		assertEquals("This will succeed.", chatDao.getChat(97));
	
	}
	
	
	
	
	
	@Ignore
	@Test
	public void getAllChatListTest()
	{
	
		List<Chat> listChat= chatDao.getChats();
		assertTrue("No Approved Blogs", listChat.size()>0);
	}
	
	
	@Ignore
	@Test
	public void DeleteChatTest()
	{
		
		assertTrue("Problem in Deleting", chatDao.deleteChat(110));
		
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/

}
