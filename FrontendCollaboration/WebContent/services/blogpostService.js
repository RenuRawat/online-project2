/**
 * 
 */


app.factory('BlogPostService',function($http) {
	var blogPostService={}
	var BASE_URL="http://localhost:8086/RestController"
		blogPostService.addBlogPost=function(blogPost) {
		return $http.post(BASE_URL + "/addblogpost",blogPost)
	}
	
	blogPostService.blogsWaitingForApproval=function(){
		return $http.get(BASE_URL + "/getblogs/"+0)   //select * from blogpost where approved=0
	}
	
	blogPostService.blogsAapproved=function(){
		return $http.get(BASE_URL + "/getblogs/"+1)    //select * from blogpost where approved=1
	}
	
	blogPostService.getBlogPostById=function(id) {
		return $http.get(BASE_URL + "/getblogbyid/"+id)
	}
	
	/*
	 * to update approved property and rejection reason(approve/reject)
	 * id,blogTitle,blogContent.postedBy,postedOn,approved,rejectionReason
	 */
	blogPostService.updateBlogPost=function(blogPost){
		return $http.put(BASE_URL + "/updateblog", blogPost)
	}
	
	
	return blogPostService;
})