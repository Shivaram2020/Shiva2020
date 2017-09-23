/**
 * BlogPostService
 */

app.factory('BlogPostService',function($http){
	var blogPostService={};
	
	blogPostService.addBlogPost=function(blogPost){
		return $http.post("http://localhost:8084/EvolJobB/saveblogpost",blogPost)
	}
	blogPostService.getBlogPostsWaitingForApproval=function(){
		return $http.get("http://localhost:8084/EvolJobB/getblogposts/"+0)
	}
	
	blogPostService.getBlogPostsApproved=function(){
		return $http.get("http://localhost:8084/EvolJobB/getblogposts/"+1)
	}
	
	blogPostService.getBlogPostById=function(id){
		return $http.get("http://localhost:8084/EvolJobB/getblogpostbyid/"+id)
	}
	
	blogPostService.deleteBlogPost=function(id){
		return $http.delete("http://localhost:8084/EvolJobB/delete/"+id)
	}
	
	blogPostService.updateBlogPost=function(blogPost){
		return $http.put("http://localhost:8084/EvolJobB/updateblogpost",blogPost)
	}
	blogPostService.realupdateBlogPost=function(blogPost){
		return $http.put("http://localhost:8084/EvolJobB/realupdateblogpost",blogPost)
	}
	
	blogPostService.addComment=function(blogComment){
		console.log(blogComment)
		return $http.post("http://localhost:8084/EvolJobB/addblogcomment",blogComment)
	}
	
	blogPostService.getBlogComments=function(blogPostId){
		return $http.get("http://localhost:8084/EvolJobB/getblogcomments/"+blogPostId)
	}
	
	return blogPostService;
})