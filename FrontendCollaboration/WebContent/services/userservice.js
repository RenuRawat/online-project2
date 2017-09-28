/**
 *  UserService
 */

app.factory('UserService', function($http) {
	var userService={}
	var BASE_URL="http://localhost:8086/RestController/"
	
	 userService.registerUser=function(user){
	 return	$http.post(BASE_URL + "/registeruser",user)
	}
	 userService.login=function(user){
	  return $http.post(BASE_URL + "/login",user)
	 
	}
	
	return userService;
     }
		)