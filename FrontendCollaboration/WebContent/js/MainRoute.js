/*
 * Angular Js Module
 */

var app=angular.module("app",['ngRoute', 'ngCookies'])
app.config(function($routeProvider)
{
	$routeProvider .when('/home',{templateUrl:'views/home.html'
	                    })
	               .when('/login',{templateUrl:'views/Login.html',controller:'UserController'
	            	   })
	               .when('/register',{templateUrl:'views/Registration.html',controller:'UserController'
	            	  })
	             	  
	              .otherwise({templateUrl:'views/home.html'})

})

app.run(function($rootScope,UserService,$location) {
	if($rootScope.currentUser==undefined)
  //reassign the user details to currentUser variable
    $rootScope.currentUser=$cookieStore.get('userDetails')
    
    $rootScope.logout=function() {
		UserService.logout().then(function(response) {
			delete $rootScope.currentUser;
			$cookieStore.remove('userDetails')
			$location.path('/login')
		},function(response) {
			console.log(response.status)
		
		})
	}
})