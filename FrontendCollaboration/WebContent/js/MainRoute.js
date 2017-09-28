/*
 * Angular Js Module
 */

var app=angular.module("app",['ngRoute'])
app.config(function($routeProvider)
{
	$routeProvider .when('/home',{templateUrl:'view/home.html'
	                    })
	               .when('/login',{templateUrl:'views/Login.html',controller:'UserController'
	            	   })
	               .when('/register',{templateUrl:'views/Registration.html',controller:'UserController'
	            	  })
	             	  
	              .otherwise({templateUrl:'views/home.html'})

})

