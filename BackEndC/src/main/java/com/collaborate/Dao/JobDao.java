package com.collaborate.Dao;


import java.util.List;

import com.collaborate.Model.Job;


public interface JobDao {

	
void addJob(Job job);

List<Job> getAllJobs();

Job getJob(int jobId);

Job deleteJob(int delete);


}
