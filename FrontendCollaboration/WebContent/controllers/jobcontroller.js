/**
 * 
 */

app.controller('JobController',function($scope,JobService,$location) {
	
	$scope.addJob=function() {
		JobService.addJob($scope.job).then(function(response) {
			console.log(response.data)
			console.log(response.status)
			
			getAllJobs()
			
			 $location.path('/getalljobs')
				   
		 
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
	getAllJobs()
	
})