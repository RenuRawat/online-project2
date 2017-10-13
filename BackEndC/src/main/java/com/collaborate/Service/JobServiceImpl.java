package com.collaborate.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaborate.Dao.JobDao;
import com.collaborate.Dao.UserDao;
import com.collaborate.Model.Job;

@Service
public class JobServiceImpl implements JobService {


	
@Autowired
private JobDao jobDao;

@Autowired
private UserDao userDao;

	public void addJob(Job job) {
		jobDao.addJob(job);
		

	}

	
	public List<Job> getAllJobs() {
	return jobDao.getAllJobs();
	}

}
