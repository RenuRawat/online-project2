

app.factory('FriendService',function($http) {
	var friendService={}
	var BASE_URL="http://localhost:8084/RestController"
		
		friendService.listOfSuggestedUsers=function(){
		return $http.get(BASE_URL + "/getsuggestedusers")
	   }
	
	friendService.sendFriendRequest=function(toId){
		return $http.get(BASE_URL + "/friendrequest/" + toId)
	   }
	
	friendService.pendingRequests=function(){
		return $http.get(BASE_URL + "/pendingrequests")
	   }
	friendService.updatePendingRequest=function(request){  //request is Friend obj (id, fromId, toId, status('A'/'D'))
		//request.id=422  request.fromId=john   request.toId=admin   request.status=A
		return $http.put(BASE_URL + "/updatependingrequest", request)   //request obj with updated status
	   }
	
	friendService.listOfFriends=function(){
		return $http.get(BASE_URL + "/friendslist")
	   }
	
	return friendService;
	})