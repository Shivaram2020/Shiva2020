app.controller('FriendController',function($scope,$location,FriendService){
	$scope.friendRequest=function(username){
		FriendService.sendFriendRequest(username)
		.then(function(response){
			alert("Friend request has been sent to " + username)
			getAllUsers();
			$location.path("/getAllUsers")
		},function(response){
			console.log(response.status)
		})
	}
	
	$scope.pendingLists=FriendService.pendingRequests()
	.then(function(response){
		$scope.pendingLists=response.data;
	},function(response){
		console.log(response.status)
	})
	
	$scope.updatependingrequest=function(from,status){
		FriendService.updatependingrequest(from,status)
		.then(function(response){
			if(status=='A')
				{
			alert('You have accepted the friend request')
				$location.path("/friendlist")
				}
			else if(status=='P')
			alert('You have unblock'+from)
			
			else
				alert('You have denied the friend request')
			$location.path('/pendingRequests')
		},function(response){
			console.log(response.status)
		})
	}
	
	$scope.friendslist=FriendService.getAllFriends()
	.then(function(response){
		$scope.friendslist=response.data
	},function(response){
		console.log(response.status)
	})
	
	function getAllUsers(){
		$scope.usersList=FriendService.getAllUsers()
		.then(function(response){
			$scope.usersList=response.data
			console.log(response.data)
		},function(response){
			console.log(response.status)
		})
	}
	
	getAllUsers();
	
	
	$scope.blockLists=FriendService.blockRequests()
	.then(function(response){
		$scope.blockLists=response.data;
	},function(response){
		console.log(response.status)
	})
	
	
	
	$scope.deleteFriendRequest=function(id,status){
		FriendService.deleteFriendRequest(id,status)
		.then(function(response){
			if(status=='X'){
			alert('You have  cancel the friend request')
			 	$location.path('/getAllUsers')
			}
			else{
				alert('You have denied the friend request')
			$location.path('/pendingRequests')
			}
		},function(response){
			console.log(response.status)
		})
	}
	
	
	$scope.follow=FriendService.followRequests()
	.then(function(response){
		$scope.follow=response.data;
	
	},function(response){
		console.log(response.status)
	})
	
	
})