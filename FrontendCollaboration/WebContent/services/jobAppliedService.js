/*

app.factory('JobAppliedService',function($http) {
	var jobAppliedService={}
	var BASE_URL="http://localhost:8084/RestController"
		
		jobAppliedService.applyNewJob=function(jobApplied) {
		return $http.post(BASE_URL + "/applyJob",jobApplied)
	}
	
	
	

	// return same variable name=var jobService={} otherwiise jobService not find error
return jobAppliedService;	
}
)
*/