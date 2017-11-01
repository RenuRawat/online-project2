package com.collaborate.Service;

import java.util.List;

import com.collaborate.Model.JobApplied;

public interface JobAppliedService {
	
	
	
 void applyNewJob(JobApplied jobApplied);

 List<JobApplied> listByUser(String username);
	
 List<JobApplied> listByCompany();

}
