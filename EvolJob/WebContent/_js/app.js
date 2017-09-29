/**
* Angular JS module and routeprovider configuration 
 */
var app=angular.module("app",['ngRoute','ngCookies'])
app.config(function($routeProvider){
	$routeProvider
	.when('/home',{
		templateUrl:'views/home.html'
	})
	.when('/aboutus',{
		templateUrl:'views/aboutUs.html'
	})
	.when('/profile',{
		templateUrl:'views/profile.html',
			controller:'BlogPostController'
			
	})
	
	.when('/profilepic',{
		templateUrl:'views/profilepic.html'
	})
	.when('/coverpic',{
		templateUrl:'views/coverpic.html'
	})
	.when('/aboutme/:username',{
		templateUrl:'views/about.html',
		controller:'UserController'
	})
	.when('/register',{
		templateUrl:'views/registrationform.html',
		controller:'UserController'
	})
	.when('/login',{
		templateUrl:'views/login.html',
		controller:'UserController'
	})
	.when('/edit',{
		templateUrl:'views/edit.html',
		controller:'UserController'
	})
	.when('/addJob',{
		templateUrl:'views/jobform.html',
		controller:'JobController'
	})
	.when('/getAllJobs',{
		templateUrl:'views/jobtitles.html',
		controller:'JobController'
	})
	.when('/getjobbyid/:id',{
		controller:'JobController',
		templateUrl:'views/job.html'
	})
	.when('/editjob/:id',{
		templateUrl:'views/jobeditform.html',
		controller:'JobController'
		
	})
	.when('/confirm/:id',{
		templateUrl:'views/jobapplyconfirm.html',
		controller:'JobController'
		
	})
	.when('/saveblogpost',{
		templateUrl:'views/blogpostform.html',
		controller:'BlogPostController'
	})
	.when('/getallblogs',{
		templateUrl:'views/bloglist.html',
		controller:'BlogPostController'
		
	})
	
	.when('/getblogpostbyid/:id',{
		templateUrl:'views/blogpostdetails.html',
		controller:'BlogPostDetailController'
		
	})
	.when('/approveblogpost/:id',{
		templateUrl:'views/blogpostapprovelform.html',
		controller:'BlogPostDetailController'
		
	})
	.when('/editblogpost/:id',{
		templateUrl:'views/blogposteditform.html',
		controller:'BlogPostDetailController'
		
	})
	
	.when('/getAllUsers',{
		templateUrl:'views/userslist.html',
		controller:'FriendController'
	})
	.when('/pendingRequests',{
		templateUrl:'views/pendingRequests.html',
		controller:'FriendController'
	})	
	.when('/friendlist',{
		templateUrl:'views/friendlist.html',
		controller:'FriendController'
	})

	.when('/blocklist',{
		templateUrl:'views/blocklist.html',
		controller:'FriendController'
	})	

	.when('/following',{
		templateUrl:'views/followinglist.html',
		controller:'FriendController'
	})	
	
	.when('/chat',{
		templateUrl:'views/chat.html',
		controller:'ChatController'
	})

	
	.otherwise({
		templateUrl:'views/home.html'
	})
})
app.run(function($rootScope,$cookieStore,userservice,$location){
	if($rootScope.currentUser==undefined)
		$rootScope.currentUser=$cookieStore.get("currentUser")
		
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
