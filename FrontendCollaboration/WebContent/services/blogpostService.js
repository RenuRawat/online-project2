/**
 * 
 */

app.factory('BlogPostService',function($http) {
	var blogPostService={}
	var BASE_URL="http://localhost:8086/RestController"
		blogPostService.addBlogPost=function(blogPost) {
		return $http.post(BASE_URL + "/addblogpost",blogPost)
	}
	
	blogPostService.blogWaitingForApproval=function(){
		return $http.get(BASE_URL + "/getblogs/"+0)
	}
	
	blogPostService.blogApproved=function(){
		return $http.get(BASE_URL + "/getblogs/"+1)
	}
	
		
	return blogPostService;
})