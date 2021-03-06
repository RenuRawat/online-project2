package com.collaborate.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaborate.Dao.JobDao;
import com.collaborate.Model.Job;



public class JobsDaoTestCase {
	
	
	
	private static AnnotationConfigApplicationContext context;
	private static JobDao jobDao;
	private static Job job;
	
	
	@BeforeClass
	public static void initialize()
	{
		
		context= new AnnotationConfigApplicationContext();
		context.scan("com.collaborate");
		context.refresh();
		System.out.println("Before");
		jobDao =(JobDao)context.getBean("jobsDao");
		System.out.println("After");
	}
	
	
	
/*	@Test
	public void createUserTest() 
	{
		Job job=new Job();
		
		job.setJobId(105);
		System.out.println("Id");
		job.setJobProfile("Ja");
		System.out.println("ja");
		job.setQualification("OOa");
		System.out.println("ooa");
		job.setJobDesc("ITApp");
		System.out.println("ITApp");
		
		job.setCreateDate(new java.util.Date());
		System.out.println("date");
		job.setStatus("n");
		System.out.println("n2");
	
		assertTrue("userDetails",jobsDao.createJob(job));
		System.out.println("Table");


	}

	@Ignore
	@Test
	public void editJobTest()
	{  
		
		job = new Jobs();
		job = jobsDao.getJob(120);						
		
		System.out.println("Id");
		job.setJobProfile("Ja");
		System.out.println("ja");
		job.setQualification("OOa");
		System.out.println("ooa");
		job.setJobDesc("ITApp");
		System.out.println("ITApp");
		
		job.setCreateDate(new java.util.Date());
		System.out.println("date");
		job.setStatus("n");
		System.out.println("n2");
	
					
	    assertTrue("This will succeed", jobsDao.editJob(120));
	}
	
	
	    @Ignore
		@Test
		public void getJobTest(){
	    	job = new Jobs();
	    	job = jobsDao.getJob(120);
			
			
			assertEquals("This will succeed.", jobsDao.getJob(120));
		//	assertEquals("Successful","Rest",blog.getBlogname());
		}
		
		
		
		
		
		@Ignore
		@Test
		public void getJobsListTest()
		{
		
			List<Jobs> listJobs= jobsDao.getJobs();
			assertTrue("No Approved Blogs", listJobs.size()>0);
		}
		
		
		@Ignore
		@Test
		public void DeleteJobTest()
		{
			
			assertTrue("Problem in Deleting", jobsDao.deleteJob(96));
			
}
*/
	
	
	
	
	


}
