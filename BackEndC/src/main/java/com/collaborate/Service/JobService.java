package com.collaborate.Service;


import java.util.List;

import com.collaborate.Model.Job;


public interface JobService {
	
	void addJob(Job job);

	List<Job> getAllJobs();

	Job getJob(int jobId);
	
	Job deleteJob(int delete);

	
}
