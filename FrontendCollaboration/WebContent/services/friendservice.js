

app.factory('FriendService',function($http) {
	var friendService={}
	var BASE_URL="http://localhost:8084/RestController"
		
		friendService.listOfSuggestedUsers=function(){
		return $http.get(BASE_URL + "/getsuggestedusers")
	   }
	
	return friendService;
	})