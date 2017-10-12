/*
 * Angular Js Module
 */

var app=angular.module("app",['ngRoute', 'ngCookies'])
app.config(function($routeProvider)
{
	$routeProvider .when('/home',{templateUrl:'views/Home.html'
	                    })
	               .when('/login',{templateUrl:'views/Login.html',controller:'UserController'
	            	   })
	               .when('/register',{templateUrl:'views/Registration.html',controller:'UserController'
	            	  })
	            	  
	            	.when('/editprofile',{templateUrl:'views/EditProfile.html', controller:'UserController'})  
	            	
	            	.when('/addblogpost',{templateUrl:'views/blogPostForm.html', controller:'BlogPostController'})
	            	.when('/getblogs' ,{templateUrl:'views/blogsList.html', controller:'BlogPostController'})
	            	
	            	
	            	
	            	.when('/getblogbyid/:id' , { //blogs approved
	            		templateUrl:'views/blogDetails.html', controller:'BlogPostDetailController'
	            			})
	            			
	            	.when('/getapprovalform/:id' ,{templateUrl:'views/blogApproval.html',controller:'BlogPostDetailController'
	            		})		
	            			
	            	/*.when('/addcomment' ,{templateUrl:'views/blogDetails.html',controller:'BlogPostDetailController'
	            		})	
	            	.when('/getcomments/ :blogPostId' ,{templateUrl:'views/blogDetails.html',controller:'BlogPostDetailController'
	            		})*/	
	             	  
	              .otherwise({templateUrl:'views/Home.html'})

})

app.run(function($rootScope,$cookieStore,UserService,$location) {
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