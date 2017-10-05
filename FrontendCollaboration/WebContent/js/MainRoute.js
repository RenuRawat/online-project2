/*
 * Angular Js Module
 */
//var app=angular.module("app",['ngRoute', 'ngCookies'])
var app=angular.module("app",['ngRoute', 'ngCookies'])
app.config(function($routeProvider)
{
	$routeProvider .when('/home',{templateUrl:'views/home.html'
	                    })
	               .when('/login',{templateUrl:'views/Login.html',controller:'UserController'
	            	   })
	               .when('/register',{templateUrl:'views/Registration.html',controller:'UserController'
	            	  })
	            	  
	            	.when('/editprofile',{templateUrl:'views/EditProfile.html', controller:'UserController'})  
	             	  
	              .otherwise({templateUrl:'views/home.html'})

})

app.run(function($rootScope,UserService,$location,$cookieStore) {
	console.log('entering app.run function')
	if($rootScope.currentUser==undefined)
  //reassign the user details to currentUser variable
    $rootScope.currentUser=$cookieStore.get('userDetails')
    
    $rootScope.logout=function() {
		console.log('entering logged function')
		UserService.logout().then(function(response) {
			console.log('logout successfully')
			delete $rootScope.currentUser;
			$cookieStore.remove('userDetails')
			$location.path('/login')
			
		},function(response) {
			console.log(response.status)
			if(response.status==401) {
				console.log('error in logout')
				delete $rootScope.currentUser;
				$cookieStore.remove('userDetails')
				$location.path('/login')
			}
		
		})
	}
})