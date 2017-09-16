package com.collaborate.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaborate.Dao.BlogDao;
import com.collaborate.Model.Blog;


@Repository("blogDao")
public class BlogDaoImpl implements BlogDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public BlogDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	
	public boolean createBlog(Blog blog) {
	  try
	  {
	 sessionFactory.getCurrentSession().save(blog);	
	 
	 System.out.println("Insert the table");
	 return true;
	  }
	  catch(Exception e) 
	  {
		 System.out.println("Exception Arised:"+e); 
		  return false; 
	  }
		
	}

//	@Transactional
	 
	public Blog getBlog(int blogId) {
		
		Session session = sessionFactory.openSession();	
		Blog blog = (Blog)session.get(Blog.class, blogId);
		session.close();
		return blog;
		
	}
	
	@Transactional
	
	public boolean editBlog(int blogId) {
		
		
			try {
				
				sessionFactory.getCurrentSession().update(blogId);
				return true;
			} catch (Exception e) {
				 System.out.println("Exception Arised:"+e); 
				return false;
			}
		
	}
/*	 try
		  {
			
			 
		Session session = sessionFactory.openSession();	
		Blog blog = (Blog)session.get(Blog.class, blogId);
	
	    session.update(blogId);
		 System.out.println("Update the table");
		 session.close();
		 return true;
		  }
		  catch(Exception e) 
		  {
			 System.out.println("Exception Arised:"+e); 
			  return false; 
		  }
			
		}*/
    
//	@Transactional

	public List<Blog> getBlogs() {
		
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Blog where status='A'");
		List<Blog> listBlog=query.list();
		session.close();
	
		return listBlog;
	}

	@Transactional

	public boolean approveBlog(Blog blog) {
		
		try {
			blog.setStatus("A");
			sessionFactory.getCurrentSession().save(blog);	
			System.out.println("Approve");
			return true;
		} catch(Exception e) {
			System.out.println("Exception Arised:"+e); 
			return false;
		}
		

	}


	

	@Transactional
	public boolean deleteBlog(int blogId) {

      try {  
		Session session = sessionFactory.openSession();
		
        Blog blog = (Blog)session.get(Blog.class, blogId);
        session.delete(blog);
        session.flush();
        session.close();
        return true;
      } catch(Exception e) {
			System.out.println("Exception Arised:"+e); 
			return false;
		}
	}

}
