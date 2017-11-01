/*
 * Angular Js Module
 */

var app=angular.module("app",['ngRoute', 'ngCookies'])
app.config(function($routeProvider)
{
	$routeProvider /*.when('/home',{templateUrl:'views/Home.html',controller:'HomeController'
	                    })*/
	                    
	.when('/myprofile',{templateUrl:'views/myProfile.html'})
	/*.when('/friendslist' ,{templateUrl:'views/myProfile.html',controller:'FriendController'
            		})*/
	
	                    .when('/demo',{templateUrl:'views/Demo.html'})
	                     .when('/pro',{templateUrl:'views/demoProfile.html'})
	                    .when('/profileInfo',{templateUrl:'views/ProfileInfo.html'})
	                    
	                     .when('/chat',{	templateUrl:'views/chat.html',controller:'ChatController'
	                    	})
	                    
	                   /* .when('/chat',{templateUrl:'views/Chatuser.html'})*/
	                                  
                   .when('/uploadprofilepic',{templateUrl:'views/ProfilePic.html' ,controller:'ProfilePicController'})  
	                    
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
	            	.when('/addjob' ,{templateUrl:'views/jobform.html',controller:'JobController'
            		})
            		.when('/getalljobs' ,{templateUrl:'views/joblist.html',controller:'JobController'
            		})
            		
            		
            		
            		.when('/getsuggestedusers' ,{templateUrl:'views/SuggestedFriendList.html',controller:'FriendController'
            		})
            		
            		.when('/pendingrequests' ,{templateUrl:'views/PendingFriendRequest.html',controller:'FriendController'
            		})
            		
            		.when('/friendslist' ,{templateUrl:'views/FriendList.html',controller:'FriendController'
            		})
            		
	              .otherwise({templateUrl:'views/Home.html',controller:'HomeController'})

})

app.run(function($rootScope,$cookieStore,UserService,$location,BlogPostService) {
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
	
	
	
	
	function getNotification(){
		
		BlogPostService.getNotification().then(function(response){
			$rootScope.blogApprovalStatus=response.data   //List of BlogPost
			$rootScope.approvalStatusLength = $rootScope.blogApprovalStatus.length
		}, function(response){
			if(response.status==401)
				$location.path('/login')
		})
	}
	
	$rootScope.updateViewedStatus=function(blogPost){
		blogPost.viewed=1
		BlogPostService.updateBlogPost(blogPost).then(function(response){
		getNotification();	
		
		}, function(response){
			if(response.status==401)
				$location.path('/login')
		})
	}
	
	$rootScope.updateLength=function()
	{
		$rootScope.approvalStatusLength=0
	}
	
	
	
	
	
	
	
})