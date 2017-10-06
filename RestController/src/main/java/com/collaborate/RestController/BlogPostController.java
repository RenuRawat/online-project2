package com.collaborate.RestController;



import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.collaborate.Model.BlogPost;
import com.collaborate.Model.Error;
import com.collaborate.Model.User;
import com.collaborate.Service.BlogPostService;
import com.collaborate.Service.UserService;






@Controller

public class BlogPostController {

	
	@Autowired	
	private BlogPostService blogPostService;	
	@Autowired	
	private UserService userService;
	
	  public BlogPostController() {
		  System.out.println("BLOGPOSTCONTROLLER INSTANTIATED");
	  }
	
	
	
	
	
	@PostMapping(value="/addblogpost")
	public ResponseEntity<?> addBlogPost(@RequestBody BlogPost blogPost,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		if(username==null)
		{
			Error error=new Error(5,"Unauthorized access....plaese login...");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		
	// String username="u"; 	used for POSTMAN
	 blogPost.setPostedOn(new Date());
	 User postedBy=userService.getUserByUsername(username);
	 blogPost.setPostedBy(postedBy); //postedBy is an object of type User
	 
	 try {
		blogPostService.addBlogPost(blogPost);
		return new ResponseEntity<BlogPost>(blogPost,HttpStatus.OK);
	 } catch (Exception e) {
		 Error error=new Error(7,"Unable to save blog post details....");
		 return new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR); //exception
		
	 }
	}
	
	
	
	@GetMapping(value="/getblogs/{approved}")
	// /getblogs/0 -> blogs waiting for approval
	// /getblogs/1 -> blogs which are approved
	public ResponseEntity<?>getBlogs(@PathVariable int approved,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		if(username==null)
		{
			Error error=new Error(5,"Unauthorized access....plaese login...");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		List<BlogPost> blogs=blogPostService.getBlogs(approved);
			return new ResponseEntity<List<BlogPost>>(blogs, HttpStatus.OK);
		}
		
		
	@GetMapping(value="/getblogbyid/{id}")
	public ResponseEntity<?>getBlogById(@PathVariable int id,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		if(username==null)
		{
			Error error=new Error(5,"Unauthorized access....plaese login...");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
	BlogPost blogpost=blogPostService.getBlogById(id);
	return new ResponseEntity<BlogPost>(blogpost, HttpStatus.OK);
	}
	
	
	
	
	
/*	
	@PostMapping(value="/createBlog")
	public ResponseEntity<String> createBlog(@RequestBody Blog blog)
	{
		blog.setCreateDate(new java.util.Date());
		blog.setStatus("NA");
		blog.setLikes(0);
		
		if(blogDao.createBlog(blog))
		{
			return new ResponseEntity<String>("Blog Created",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in Blog Creation",HttpStatus.NOT_ACCEPTABLE);
		}
	
	}
	
	
	
	@PostMapping("/editBlog/{blogid}")
	public ResponseEntity<String> editBlog(@RequestBody int blog, @PathVariable("blogid") int blogId) {

		
	    Blog blogg= blogDao.getBlog(blogId);
		blogg.setBlogId(blog.getBlogId());
		blogg.setBlogname(blog.getBlogname());
		blogg.setStatus(blog.getStatus());
		blogg.setLikes(blog.getLikes());
		blogg.setCreateDate(blog.getCreateDate());
		blogg.setUserId(blog.getUserId());
		
        blogDao.getBlog(blogId);
		if(blogDao.editBlog(blog))
		{
			return new ResponseEntity<String>("Blog Update",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in Blog Updation",HttpStatus.NOT_ACCEPTABLE);
		}
}
	
	
	@PostMapping(value="/editBlog/{blogid}")
	public ResponseEntity<String> editBlog(@RequestParam("blogid") int blogId)
	{     
		Blog blog=blogDao.getBlog(blogId);
		blog.setCreateDate(new java.util.Date());
		blog.setStatus("NA");
		blog.setLikes(0);
		
		if(blogDao.editBlog(blogId))
		{
			return new ResponseEntity<String>("Blog Update",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in Blog Updation",HttpStatus.NOT_ACCEPTABLE);
		}
	
	}
	
	*/
	
	
	
	/*@GetMapping(value="/deleteBlog/{blogid}")
	public ResponseEntity<String> deleteBlog(@PathVariable("blogid") int blogId)
	{
		if(blogPostService.deleteBlog(blogId))
		{
			return new ResponseEntity<String>("Blog Deleted",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in Blog Deletion",HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	*/
	
	
	

	@GetMapping(value="/test")
	public ResponseEntity<String> testMethod()
	{
		return new ResponseEntity<String>("Test RestController", HttpStatus.OK);
	}
	
	
	

}
