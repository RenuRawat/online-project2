/**
 *  UserController
 */


app.controller('UserController', function($scope,UserService,$location,$rootScope,$cookieStore) {
	
	
	
	$scope.registerUser=function() {
		/*
		 * call userservice - pass user data in Json Format
		 */
		console.log("USER DATA IS" + $scope.user)
		UserService.registerUser($scope.user).then(function(response) {
			/*
			 * Redirect the user to login page with 'registration success' message
			 */
			console.log(response.data)
            console.log(response.status)          
            $location.path('/login')
		}, function(response) {
			/*
			 * if status is 406, either username is not valid/email is not valid
			 * Display the errorMessage in the registrationForm
			 */
			console.log(response.data)
            console.log(response.status)
            $scope.error=response.data
            $location.path('/register')
		})
		}
	
	
	$scope.login=function()
	{
	  console.log($scope.userObj)
	  UserService.login($scope.userObj).then(function(response)
	 {
		 $rootScope.currentUser=response.data  //response.data is User obj
		 $cookieStore.put('userDetails', response.data)
		 $location.path('/home') 
	 }, function(response) {
		 $scope.error=response.data.message
		 $location.path('/login')
	
	 }	)
	  
	}
	
	
	if($rootScope.currentUser!=undefined) {
		UserService.getUser().then(function(response) {
			$scope.user=response.data
			
		},function(response) {
			console.log(response.status)
		})
	}
	
	
	
})
