

app.factory('JobService',function($http) {
	var jobService={}
	var BASE_URL="http://localhost:8084/RestController"
		
		jobService.addJob=function(job) {
		return $http.post(BASE_URL + "/addjob",job)
	}
	
	jobService.getAllJobs=function() {
		return $http.get(BASE_URL + "/getalljobs")
	}
	
	jobService.getJobDetails=function(jobId) {
		return $http.get(BASE_URL + "/getjob/"+jobId)
	}
	

	// return same variable name=var jobService={} otherwiise jobService not find error
return jobService;	
}
)
