/**
 * 
 */

app.controller('FriendController',function($scope,FriendService,$location) {
	
	function listOfSuggestedUsers(){
	   FriendService.listOfSuggestedUsers().then(function(response){
		   $scope.suggestedUsers=response.data  //List<User>
	   }, function(response){
		   if(response.status==401)
			   $location.path('/login')
	   })	
	}   
	
	//function call
	listOfSuggestedUsers()
	
	})
	