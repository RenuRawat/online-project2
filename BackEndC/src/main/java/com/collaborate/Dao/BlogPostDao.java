package com.collaborate.Dao;

import java.util.List;

import com.collaborate.Model.BlogPost;

public interface BlogPostDao {
	
	void addBlogPost(BlogPost blogPost);
	List<BlogPost> getBlogs(int approved); //0/1

}
