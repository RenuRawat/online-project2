/**
 * 
 */

app.controller('BlogPostController',function($scope,BlogPostService,$location) {
	
	$scope.addBlogPost=function() {
		BlogPostService.addBlogPost($scope.blog).then(function(response) {
			alert('BlogPost added successfully and waiting for approval....')
		    $location.path('/home')
		 
		},function(response) {//response.status [401/500]
		$scope.error=response.data.message //Error(code,message)
		if(response.status==401)  //401
			$location.path('/login')
			else//500
			$location.path('/addblogpost')	
		})
		
	}
})