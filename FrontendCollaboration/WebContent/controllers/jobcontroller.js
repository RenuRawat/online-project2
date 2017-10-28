/**
 * 
 */

app.controller('JobController',function($scope,JobService,$location) {
	
	
		
	$scope.showJobDetails=false;
	
	$scope.addJob=function() {		
		JobService.addJob($scope.job).then(function(response) {
			console.log(response.data)
			console.log(response.status)
			
			getAllJobs()
			
			$scope.job=''
			 $location.path('/addjob')
				   
		 
		},function(response) {//response.status [401/500]
			console.log(response.data)
			console.log(response.status)
			
		
		if(response.status==401)  //401
			{
			$scope.error=response.data.message
			$location.path('/login') 
			}
			else//500
			{				
				$scope.error=response.data.message
				$location.path('/addjob')	
			}
			})
	}
	


	
	$scope.getJobDetails=function(jobId){
		
		$scope.showJobDetails=true;
		
		JobService.getJobDetails(jobId).then(function(response){
			$scope.job=response.data
		},function(response){
			console.log(response.data)
		 if(response.status==401)
			 {
			 $location.path('/login')
			 }
		})
	}
	
	
	
	function getAllJobs() {
		JobService.getAllJobs().then(function(response){
			$scope.jobs=response.data
		}, function(response){
			if(response.status==401)
				{
				$location.path('/login')
				}
		})
	}
	
	
	
	$scope.deleteJob = function(id)
	{
		
		JobService.deleteJob(id).then(function(response){
			alert("Deleted Successfully")
			getAllJobs();
			$location.path('/addjob')
		},function(response){
			console.log(response.status);
			console.log(response.message);
			$scope.error=response.data;
			$location.path('/login');
		})
	}
	
	
	
	getAllJobs()
	
})