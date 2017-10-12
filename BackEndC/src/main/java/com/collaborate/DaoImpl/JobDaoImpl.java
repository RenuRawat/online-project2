package com.collaborate.DaoImpl;

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
		
	}
	

	
	
	
}
