
/**
 * UserController
 */
app.controller('UserController',function(userservice,$scope,$location,$rootScope,$cookieStore,$routeParams){
	$scope.user={}

	
	var username=$routeParams.username;
		
	
	
	
	userservice.getJobByIdd(username).then(function(response){
		$scope.job=response.data;
		console.log(response.data);
	},function(response){
		console.log(response.status)
	})
	
		
	if($rootScope.currentUser!=undefined){
		userservice.getUser().then(function(response){
			$scope.user=response.data;
		},function(response){
			console.log(response.status)
			$location.path('/home')
		})
		}
	
	$scope.registerUser=function(){
		userservice.registerUser($scope.user).then(function(response){
			$scope.mess="Registered successfully.. please login again"
				console.log($scope.mess)
			$location.path('/login')
		},function(response){
			console.log(response.status)
			console.log(response.data)
			$scope.error=response.data
			$location.path('/register')
		})
	}
	
	$scope.validateUser=function(){
		userservice.validateUser($scope.user).then(function(response){
			console.log(response.data)
			$rootScope.currentUser=response.data
			$cookieStore.put("currentUser",response.data)
			$location.path('/home')
		},function(response){
			$scope.error=response.data
			console.log(response.status)
			$location.path('/login')
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
	
	$scope.updateUser=function(){
		userservice.updateUser($scope.user).then(function(response){
			alert("updated successfully")
			$location.path('/home')
		},function(response){
			console.log(response.data)
			/*
			 * For unauthorized access, 401 -> redirect the user to login page
			 * For Exception , 500  -> redirect the user to updateprofile page
			 */
			if(response.status==401)
				$location.path('/login')
			$location.path('/editprofile')
		})
	}
	
	$scope.updateUserJob=function(){
		userservice.updateUserJob($scope.user).then(function(response){
			alert("updated successfully")
			
		},function(response){
			console.log(response.data)
			/*
			 * For unauthorized access, 401 -> redirect the user to login page
			 * For Exception , 500  -> redirect the user to updateprofile page
			 */
			if(response.status==401)
				$location.path('/login')
			$location.path('/editprofile')
		})
	}
})


