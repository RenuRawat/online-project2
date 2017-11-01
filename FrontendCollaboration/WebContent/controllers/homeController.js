/*
 *Home Controller get initiated blog post notification 
 *
*/

app.controller('HomeController',function(BlogPostService,$rootScope,$location){
	function getNotification(){
		// returns list of blogposts which are approved/rejected by admin
		//and updated status is not yet viewed by user
		BlogPostService.getNotification().then(function(response){
			$rootScope.blogApprovalStatus=response.data    //List of BlogPost 
			$rootScope.approvalStatusLength=$rootScope.blogApprovalStatus.length    //Number of objects 
		},function(response){
			if(response.status==401)
				$location.path('/login')
		})
	}
	
	$rootScope.updateViewedStatus=function(blogPost){
		blogPost.viewed=1
		BlogPostService.updateBlogPost(blogPost).then(function(response){
			getNotification();
		},function(response){
			if(response.status==401)
				$location.path('/login')
		})
	}
	
	$rootScope.updateLength=function()
	{
		$rootScope.approvalStatusLength=0
	}
	getNotification()
})




