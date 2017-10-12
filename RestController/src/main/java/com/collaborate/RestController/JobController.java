package com.collaborate.RestController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collaborate.Dao.JobsDao;
import com.collaborate.Model.Jobs;

@RestController
public class JobsController {
	
	@GetMapping("/job")
	public ResponseEntity<String>testMetod() {
		
		return new ResponseEntity<String>("Created", HttpStatus.OK);
	}
	
	
	@Autowired
	JobsDao jobsDao;
	
	@PostMapping(value="/createJob")
	public ResponseEntity<String>createJob(@RequestBody Jobs job)
	{
	  job.setCreateDate(new java.util.Date());
	  job.setStatus("NA");
	  
	  if(jobsDao.createJob(job))
	  {
		  return new ResponseEntity<String>("Job table Created", HttpStatus.OK);
	  } else {
		  return new ResponseEntity<String>("Problem in Creation",HttpStatus.NOT_ACCEPTABLE);
	  }
	  
	}
	
	
	@GetMapping(value="/getAllJobs")
	public ResponseEntity<ArrayList<Jobs>>getAlljobs(@PathVariable Jobs job)
	{
		ArrayList<Jobs> listjob= new ArrayList<Jobs>();
		listjob=(ArrayList<Jobs>)jobsDao.getJobs();
		
		return new ResponseEntity<ArrayList<Jobs>>(listjob, HttpStatus.OK);
	}
	
	
	@GetMapping(value="DeleteJob/{jobid}")
	public ResponseEntity<String>DeleteJob(@PathVariable ("jobid") int jobId)
	{
	 if(jobsDao.deleteJob(jobId))
	 {
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	} else {
		return new ResponseEntity<String>("Problem in Deletion", HttpStatus.OK);
	}
	}
	

}
