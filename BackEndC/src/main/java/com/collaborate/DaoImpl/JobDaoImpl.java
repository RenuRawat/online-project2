package com.collaborate.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaborate.Dao.JobsDao;
import com.collaborate.Model.Jobs;

@Repository("jobsDao")
public class JobsDaoImpl implements JobsDao {
	
	
	@Autowired
	SessionFactory sessionFactory;
	
	public JobsDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory=sessionFactory;
	}
	

	@Transactional
	public boolean createJob(Jobs job) {
		try {
			sessionFactory.getCurrentSession().save(job);
			System.out.println("Insert the table");
		return true;
		} catch(Exception e) {
			System.out.println("Exception Arised:" +e);
			return false;
		}
	}

	@Transactional
	public Jobs getJob(int jobId) {
		return (Jobs) sessionFactory.getCurrentSession().get(Jobs.class, jobId);
	}

	@Transactional
	public List<Jobs> getJobs() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from JobTable where status='A'");
		List<Jobs> listJobs=query.list();
		session.close();
	
		return listJobs;
	}

	@Transactional
	public boolean editJob(int jobId) {
		 try
		  {
			
			 
		Session session = sessionFactory.openSession();	
		Jobs job = (Jobs)session.get(Jobs.class, jobId);
	//	blog.setBlogname("APPPP");
	    session.update(job);
		 System.out.println("Update the table");
		 session.close();
		 return true;
		  }
		  catch(Exception e) 
		  {
			 System.out.println("Exception Arised:"+e); 
			  return false; 
		  }
	}

	@Transactional
	public boolean deleteJob(int jobId) {
		try {  
			Session session = sessionFactory.openSession();
			
	        Jobs job = (Jobs)session.get(Jobs.class, jobId);
	        session.delete(job);
	        session.flush();
	        session.close();
	        return true;
	      } catch(Exception e) {
				System.out.println("Exception Arised:"+e); 
				return false;
			}
	}

}
