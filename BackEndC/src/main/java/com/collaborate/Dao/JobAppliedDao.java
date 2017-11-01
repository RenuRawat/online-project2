package com.collaborate.Dao;

import java.util.List;

import com.collaborate.Model.JobApplied;

public interface JobAppliedDao 
{
	
	public void applyNewJob(JobApplied jobApplied);
	
	public List<JobApplied> listByUser(String username);
	
	public List<JobApplied> listByCompany();
	
}
