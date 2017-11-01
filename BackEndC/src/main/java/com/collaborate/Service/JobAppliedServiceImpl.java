package com.collaborate.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaborate.Dao.JobAppliedDao;
import com.collaborate.Dao.UserDao;
import com.collaborate.Model.JobApplied;

@Service
public class JobAppliedServiceImpl implements JobAppliedService {

	@Autowired
	JobAppliedDao jobAppliedDao;
	
	@Autowired
	private UserDao userDao;
	

	public void applyNewJob(JobApplied jobApplied) {
		jobAppliedDao.applyNewJob(jobApplied);
		
	}

	public List<JobApplied> listByUser(String username) {
		return jobAppliedDao.listByUser(username);
	}

	public List<JobApplied> listByCompany() {		
		return jobAppliedDao.listByCompany();
	}
	
	
	
	
}
