package com.collaborate.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.collaborate.Model.BlogPost;

@Service
public interface BlogPostService {
	
	
	void addBlogPost(BlogPost blogPost);
	List<BlogPost> getBlogs(int approved); //0
	
	BlogPost getBlogById(int id);
	
	void updateBlogPost(BlogPost blogPost);

}
