/**
 *  BlogPostDetailController
 *  getblogbyid/317
 *  getblogbyid/:id
 *  $routeParam:id => 317
 */


app.controller('BlogPostDetailController',function($scope,BlogPostService,$location,$routeParams) {
	var id=$routeParams.id
	alert('blogpostdetailcontroller instantiated')
    BlogPostService.getBlogPostById(id).then(function(response) {
    	$scope.blogPost=response.data //BlogPost [select * from blogpost where id=?]
    },function(response) {
    	if(response.status==401)
    		$location.path('/login')
    })	
})