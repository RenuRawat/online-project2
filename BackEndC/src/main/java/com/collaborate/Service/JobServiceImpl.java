package com.collaborate.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaborate.Dao.JobDao;
import com.collaborate.Model.Job;

@Service
public class JobServiceImpl implements JobService {


	
@Autowired
private JobDao jobDao;

	public void addJob(Job job) {
		jobDao.addJob(job);
		

	}

}
