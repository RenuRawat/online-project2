package com.collaborate.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaborate.Dao.JobDao;
import com.collaborate.Model.Job;

@Transactional
@Repository("jobDao")
public class JobDaoImpl implements JobDao {
	
	
	@Autowired
	SessionFactory sessionFactory;
	
	public JobDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory=sessionFactory;
	}

	
	public void addJob(Job job) {	
		Session session=sessionFactory.getCurrentSession();
		session.save(job);
		
	}


	
	public List<Job> getAllJobs() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Job");
		return query.list();
		
	}


	public Job getJob(int jobId) {
		Session session=sessionFactory.getCurrentSession();
		Job job=(Job)session.get(Job.class, jobId);
		return job;
	}
	
	
	
	
}
