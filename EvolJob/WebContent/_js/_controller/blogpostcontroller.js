/**
 * BlogPostController
 */
app.controller('BlogPostController',function(BlogPostService,$scope,$location,$rootScope){
	
	BlogPostService.getBlogPostsWaitingForApproval().then(function(response){
		$scope.blogPostsWaitingForApproval=response.data;
	},function(response){
		if(response.status==401)
			$location.path('/login')
	})
	
	
	BlogPostService.getBlogPostsApproved().then(function(response){
		$scope.blogPostsApproved=response.data
	},function(response){
		if(response.status==401)
			$location.path('/login')
	})
	
	
	$scope.addBlogPost=function(){
		BlogPostService.addBlogPost($scope.blogPost).then(function(response){
			console.log(response.status)
			alert('BlogPost added successfully.. It is waiting for approval')
			$location.path('/getallblogs')
		},function(response){
			if(response.status==401)
				$location.path('/login')
			$location.path('/saveblogpost')
		})
	}
	
	
	$rootScope.logout=function(){
        userservice.logout().then(function(response){
        	$rootScope.logoutSuccess="Loggedout Successfully.."
        		delete $rootScope.currentUser
        		$cookieStore.remove("currentUser")
        		$location.path('/login');
        },function(response){
        	$scope.error=response.data
        	$location.path('/login')
        })		
	}
	
})