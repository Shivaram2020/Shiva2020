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
	function getApplyJobs(){
		JobService.getApplyJobs().then(function(response){
			$scope.applyjobs=response.data;
		},function(response){
			$location.path('/login')
		})
	}
	$scope.saveJob=function(){
		JobService.saveJob($scope.job).then(function(response){
			$location.path('/getAllJobs')
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
	
	
	
	JobService.getJobById(id).then(function(response){
		$scope.job=response.data;
		console.log(response.data);
	},function(response){
		console.log(response.status)
	})
getAllJobs()	
	
JobService.getApplyJobById(id).then(function(response){
		$scope.applyjob=response.data;
		console.log(response.data);
	},function(response){
		console.log(response.status)
	})
getApplyJobs()

$scope.updateJob=function(){
		console.log($scope.job)
		JobService.updateJob($scope.job).then(function(response){
			console.log(response.status)
			$location.path('/getAllJobs')
		},function(response){
			if(response.status==401)
				$location.path('/login')
		})
	}
	
	
	$scope.deleteJob=function(){
		console.log($scope.job.id)
		$scope.job=JobService.deleteJob($scope.job.id).then(function(response){
			$scope.job=response.data;
			console.log(response.data)
			$location.path('/getAllJobs')
		},function(response){
			console.log(response.status)
			if(response.status==401)
				$location.path('/login')
				
		})
		
	}
	
	
	$scope.applyJob=function(){
		console.log($scope.job.id)
		$scope.job=JobService.applyJob($scope.job.id).then(function(response){
			$scope.job=response.data;
			console.log(response.data)
			$location.path('/confirm/'+$scope.job.id)
			getApplyJobs()	
		},function(response){
			console.log(response.status)
			if(response.status==401)
				$location.path('/login')
				
		})
		
	}
	
	$scope.confirm=function(){
		console.log($scope.applyjob.id)
		$scope.applyjob=JobService.confirm($scope.applyjob.id).then(function(response){
			$scope.job=response.data;
			console.log(response.data)
			$location.path('/getAllJobs')
		},function(response){
			console.log(response.status)
			if(response.status==401)
				$location.path('/login')
				
		})
		
	}
})


