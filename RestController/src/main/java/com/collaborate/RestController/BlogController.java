package com.collaborate.RestController;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.collaborate.Dao.BlogDao;
import com.collaborate.Model.Blog;






@RestController

public class BlogController {

	

	@Autowired
	BlogDao blogDao;
	
	
	
	
	@GetMapping(value="/getAllBlogs")
	public ResponseEntity<ArrayList<Blog>> getAllBogs()
	{
		ArrayList<Blog> listBlogs= new ArrayList<Blog>();
		listBlogs=(ArrayList<Blog>)blogDao.getBlogs();
		
	 return new ResponseEntity<ArrayList<Blog>>(listBlogs, HttpStatus.OK);	
	}
	
	
	
	@GetMapping(value="/getBlog/{blogId")
	public ResponseEntity<String>getBlog(@PathVariable ("blogid") int blogId)
	{
		blogDao.getBlog(blogId);
		//if(blogDao.getBlog(blog)
	//	{
			return new ResponseEntity<String>("Blog Details ",HttpStatus.OK);
		/*}
		else
		{
			return new ResponseEntity<String>("Problem in Blog Deletion",HttpStatus.NOT_ACCEPTABLE);
		}*/
		
	}
	
	
	
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

	/*	
	    Blog blogg= blogDao.getBlog(blogId);
		blogg.setBlogId(blog.getBlogId());
		blogg.setBlogname(blog.getBlogname());
		blogg.setStatus(blog.getStatus());
		blogg.setLikes(blog.getLikes());
		blogg.setCreateDate(blog.getCreateDate());
		blogg.setUserId(blog.getUserId());*/
		
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
	
	
	/*@PostMapping(value="/editBlog/{blogid}")
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
	
	}*/
	
	
	@GetMapping(value="/approveBlog/{blogid}")
	public ResponseEntity<String> approveBlog(@PathVariable("blogid") int blogId)
	{
		Blog blog=blogDao.getBlog(blogId);
		//sop
		if(blogDao.approveBlog(blog))
		{
			return new ResponseEntity<String>("Blog Approved",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in Blog Approval",HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	
	@GetMapping(value="/deleteBlog/{blogid}")
	public ResponseEntity<String> deleteBlog(@PathVariable("blogid") int blogId)
	{
		if(blogDao.deleteBlog(blogId))
		{
			return new ResponseEntity<String>("Blog Deleted",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in Blog Deletion",HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	
	
	
	

	@GetMapping(value="/test")
	public ResponseEntity<String> testMethod()
	{
		return new ResponseEntity<String>("Test RestController", HttpStatus.OK);
	}
	
	
	

}
