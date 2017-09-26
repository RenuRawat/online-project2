/**
 *  UserController
 */


app.controller('UserController', function($scope,UserService,$location) {
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
            $location.path('/home')
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
      })