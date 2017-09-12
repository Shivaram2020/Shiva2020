/**
 * BlogPostService
 */

app.factory('BlogPostService',function($http){
	var blogPostService={};
	
	blogPostService.addBlogPost=function(blogPost){
		return $http.post("http://localhost:8083/EvolJobB/saveblogpost",blogPost)
	}
	blogPostService.getBlogPostsWaitingForApproval=function(){
		return $http.get("http://localhost:8083/EvolJobB/getblogposts/"+0)
	}
	
	blogPostService.getBlogPostsApproved=function(){
		return $http.get("http://localhost:8083/EvolJobB/getblogposts/"+1)
	}
	
	blogPostService.getBlogPostById=function(id){
		return $http.get("http://localhost:8083/EvolJobB/getblogpostbyid/"+id)
	}
	
	blogPostService.deleteBlogPost=function(id){
		return $http.delete("http://localhost:8083/EvolJobB/delete/"+id)
	}
	
	blogPostService.updateBlogPost=function(blogPost){
		return $http.put("http://localhost:8083/EvolJobB/updateblogpost",blogPost)
	}
	
	blogPostService.addComment=function(blogComment){
		console.log(blogComment)
		return $http.post("http://localhost:8083/EvolJobB/addblogcomment",blogComment)
	}
	
	blogPostService.getBlogComments=function(blogPostId){
		return $http.get("http://localhost:8083/EvolJobB/getblogcomments/"+blogPostId)
	}
	
	return blogPostService;
})