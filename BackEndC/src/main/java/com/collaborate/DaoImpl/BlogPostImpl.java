package com.collaborate.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaborate.Dao.BlogPostDao;
import com.collaborate.Model.BlogComment;
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
	// if approved=0, select* from blogPost where approved=0; blogs waiting for approval
	// if approved=1, select* from blogPost where approved=1; blogs which are approved
	
	String queryStr="";
	if(approved==1)
		queryStr="from BlogPost where approved=" +approved;
	else
		queryStr="from BlogPost where rejectionReason is null and approved=" +approved;
	
	Query query =session.createQuery(queryStr);	
	return query.list();
	}



	public BlogPost getBlogById(int id) {
	Session session=sessionFactory.getCurrentSession();
	BlogPost blogPost=(BlogPost)session.get(BlogPost.class, id);
		return blogPost;
	}



	public void updateBlogPost(BlogPost blogPost) {
	Session session=sessionFactory.getCurrentSession();
	session.update(blogPost); //update approved
	}



	public void addBlogComment(BlogComment blogComment) {
	Session session=sessionFactory.getCurrentSession();
	System.out.println("blogComment");
	session.save(blogComment);
	System.out.println("blogComment1");

		
	}


	public List<BlogComment> getBlogComments(int blogPostId) {
		Session session=sessionFactory.getCurrentSession();
		System.out.println("comments");
		Query query=session.createQuery("from BlogComment where blogPost.id=" + blogPostId);
		System.out.println("comments1");
		return query.list();
		
	}


//	from blogpost where postedBy_username='james' and viewed=0 and approved=1 or rejectionReason!='null'


	public List<BlogPost> getNotification(String username) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from BlogPost where postedBy.username=? and viewed=? and (approved=1 or rejectionReason!=null)");
		query.setString(0, username);
		query.setBoolean(1, false);
		return query.list();
		
		/* Or
		 * query.setBoolean(1, false);
		 * List<BlogPost> postupdated=query.list();
		 * return postupdated;
		 */
	}

	
	
}
