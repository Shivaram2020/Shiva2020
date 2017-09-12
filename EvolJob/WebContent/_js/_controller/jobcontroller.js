/**
 * Job Controller
 */
app.controller('JobController',function(JobService,$scope,$location,$routeParams,$rootScope){
	var id=$routeParams.id;
	
	
	function getAllJobs(){
		JobService.getAllJobs().then(function(response){
			$scope.jobs=response.data;
		},function(response){
			$location.path('/login')
		})
	}
	
	$scope.saveJob=function(){
		JobService.saveJob($scope.job).then(function(response){
			$location.path('/getallJobs')
		},function(response){
			console.log(response.status)
			if(response.status==401){
				$scope.error=response.data
				$location.path('/login')
			}
			if(response.status==500){
				$scope.error=response.data
				$location.path('/addJob')
			}
			$location.path('/home')
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
	
	JobService.getJobById(id).then(function(response){
		$scope.job=response.data;
		console.log(response.data);
	},function(response){
		console.log(response.status)
	})
getAllJobs()	
	
})


