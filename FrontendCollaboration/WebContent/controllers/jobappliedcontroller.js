/*app.controller('JobAppliedController',function($scope,JobAppliedService,$location,JobService) {
	
	
		
	
	
	$scope.applyNewJob=function() {		
		JobAppliedService.applyNewJob($scope.job).then(function(response) {
			console.log(response.data)
			console.log(response.status)
			
			getAllJobs()
			
			//$scope.job=''
			 $location.path('/applyJob')
				   
		 
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
				$location.path('/applyJob')	
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
	
	
})*/