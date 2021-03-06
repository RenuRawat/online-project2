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
	
	function pendingRequests(){
		FriendService.pendingRequests().then(function(response){
			$scope.pendingRequests=response.data  //List<Friend>
		}, function(response){
			if(response.status==401)
				$location.path('/login')
		})
	}
	
	function listOfFriends(){
	FriendService.listOfFriends().then(function(response){
//	alert(response.data)
	$scope.friends=response.data  //List<String>
	}, function(response){
		if(response.status==401)
			$location.path('/login')
	})	
	}
	
	
	$scope.sendFriendRequest=function(toId){
		FriendService.sendFriendRequest(toId).then(function(response){
			alert('Friend Request has been sent successfully')
			listOfSuggestedUsers()
			$location.path('/getsuggestedusers')
		}, function(response){
			if(response.status==401)
				$location.path('/login')
		})
	}
	
	
	$scope.updatePendingRequest=function(request, statusValue) {  //statusvalue = A/D
		//before assignment request.status is p(pending)
		//request.id=422 request.fromId=john    request.toId==admin    request.status=P
		console.log(request)
		console.log(request.status)  //P
		request.status=statusValue   //statusValue  A/D
		console.log(request.status)  //A=(Accept) / D=(Delete)
		console.log(request)
		FriendService.updatePendingRequest(request).then(function(response){
			pendingRequests()
			$location.path('/pendingrequests')
		}, function(response){
			if(response.status==401)
				$location.path('/login')	
		})
		
	}
	
	
	//function call
	listOfSuggestedUsers()  //select
	pendingRequests()  //select
	listOfFriends()    //select
	})
	