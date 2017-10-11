package com.collaborate.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaborate.Dao.BlogPostDao;
import com.collaborate.Model.Blog;
import com.collaborate.Model.BlogComment;
import com.collaborate.Model.BlogPost;
import com.collaborate.Model.User;

public class BlogCommenttest {

	
	
	private static BlogPostDao blogPostDao;
	private BlogComment blogComment;
	private BlogPost blogPost;
	private User user;
	
		@BeforeClass
		public static void initialize()
		{
			AnnotationConfigApplicationContext annotationConfigAppContext= new AnnotationConfigApplicationContext();
			annotationConfigAppContext.scan("com.collaborate");
			annotationConfigAppContext.refresh();
			
	     blogPostDao=(BlogPostDao)annotationConfigAppContext.getBean("blogPostDao");
			
		}
	
	
		@Test
		public void addBlogCommentTest() {
           BlogComment blogC=new BlogComment();
			
          
           blogC.setCommentText("Java Ring");
           blogC.setBlogPost(blogPost);
      //     blogC.setCommentedBy("ray");
           blogC.setCommentedOn(new java.util.Date());
           
           
		
        
		//	assertTrue("This will succeed.", blogPostDao.addBlogComment(blogComment);	
		}
		



	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
