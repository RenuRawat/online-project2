package com.collaborate.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import com.collaborate.Dao.JobAppliedDao;
import com.collaborate.Model.JobApplied;


@Repository("jobAppliedDao")
@Transactional
public class JobAppliedDaoImpl implements JobAppliedDao
{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public JobAppliedDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory=sessionFactory;
	}

	
	
	
	public void applyNewJob(JobApplied jobApplied) {
		Session session=sessionFactory.getCurrentSession();
		session.save(jobApplied);
		System.out.println("jobApplied");
	}

	public List<JobApplied> listByUser(String username) {
		Session session=sessionFactory.getCurrentSession();
		System.out.println("List jobApplied by user");
		
		Query query=session.createQuery("from JobApplied where username = '"+username+"' ");
		System.out.println("List jobApplied by user1");
		return query.list();
	
	}

	public List<JobApplied> listByCompany() {
		Session session=sessionFactory.getCurrentSession();
		System.out.println("List jobApplied by company");
		
		Query query=session.createQuery("from JobApplied");
		System.out.println("List jobApplied by company1");
		return query.list();
	}

	

}