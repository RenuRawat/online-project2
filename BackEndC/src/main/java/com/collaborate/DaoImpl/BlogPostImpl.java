package com.collaborate.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaborate.Dao.BlogPostDao;
import com.collaborate.Model.BlogPost;


@Repository("blogPostDao")
@Transactional
public class BlogPostImpl implements BlogPostDao {

	
	@Autowired
	SessionFactory sessionFactory;
	
	public BlogPostImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	
	


	public void addBlogPost(BlogPost blogPost) {
	Session session=sessionFactory.getCurrentSession();
	session.save(blogPost);	
	}

	
	public List<BlogPost> getBlogs(int approved) {
	Session session=sessionFactory.getCurrentSession();
	Query query =session.createQuery("from BlogPost where approved=" +approved);
	return query.list();
	}

	
	
}
