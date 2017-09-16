package com.collaborate.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaborate.Dao.BlogDao;
import com.collaborate.Model.Blog;

public class BlogDaoTestCase {

	
	   
	
	private static BlogDao blogDao;
	private Blog blog;
	
		@BeforeClass
		public static void initialize()
		{
			AnnotationConfigApplicationContext annotationConfigAppContext= new AnnotationConfigApplicationContext();
			annotationConfigAppContext.scan("com.collaborate");
			annotationConfigAppContext.refresh();
			
	     blogDao=(BlogDao)annotationConfigAppContext.getBean("blogDao");
			
		}
		
		
	  //  @Ignore
		@Test
		public void createBlogTest() 
		{
			Blog blog=new Blog();
			
			blog.setBlogId(2013);
			blog.setBlogname("Java Ring");
			blog.setBlogContent("Smart Technology");
			blog.setUserId("Tannu@gmail.com");
			blog.setCreateDate(new java.util.Date());
			blog.setStatus("A");
			blog.setLikes(0);
			
			assertTrue("This will succeed.", blogDao.createBlog(blog));

		}
		@Ignore
		@Test
		public void editBlogTest()
		{  
			
			blog = new Blog();
			blog = blogDao.getBlog(99);						
			
		blog.setBlogContent("It is stand for Representational State Transfer");
			blog.setUserId("srenu@gmail.com");
			blog.setCreateDate(new java.util.Date());
			blog.setStatus("NA");
			blog.setLikes(0);  
						
		    assertTrue("This will succeed", blogDao.editBlog(99));
			//assertEquals("Successful","Rest",blog.getBlogname());

		}
		
		
		@Ignore
		@Test
		public void getBlogTest(){

			assertNotNull("Problem getting blog",blogDao.getBlog(204));
		}
		
		@Ignore
		@Test
		public void approveBlogTest()
		{
        Blog blog=new Blog();
        
			
        blog = blogDao.getBlog(102);
        
			blog.setBlogname("Rest");
			blog.setBlogContent("Rest is stand for Representational State Transfer");
			blog.setUserId("srenu@gmail.com");
			blog.setCreateDate(new java.util.Date());
			blog.setStatus("NA");
			blog.setLikes(0);
			
		   assertTrue("This will succeed.", blogDao.approveBlog(blog));

			}
		
		
		
		@Ignore
		@Test
		public void getAllapproveBlogListTest()
		{
		
			List<Blog> listBlog= blogDao.getBlogs();
			assertTrue("No Approved Blogs", listBlog.size()>0);
		}
		
		
		@Ignore
		@Test
		public void DeleteBlogTest()
		{
			
			assertTrue("Problem in Deleting", blogDao.deleteBlog(93));
			
}

			
		
		
		
		
		/*@Test
		public void test() {
			fail("Not yet implemented");
		}
*/
	}


