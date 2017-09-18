app.factory('FriendService',function($http){
	var friendService={}
	var BASE_URL="http://localhost:8084/EvolJobB"
		
		
	friendService.getAllUsers=function(){
		return $http.get(BASE_URL + "/getAllUsers")
	}
	
	friendService.sendFriendRequest=function(to){
		return $http.put(BASE_URL + "/friendRequest/"+to);
	}
	friendService.pendingRequests=function(){
		return $http.get(BASE_URL + "/pendingRequests")
	}
	
	friendService.followRequests=function(){
		return $http.get(BASE_URL + "/following")
	}
	
	friendService.updatependingrequest=function(from,status){
		return $http.put(BASE_URL + "/updatependingrequest/"+from+"/"+status)
	}
	
	friendService.getAllFriends=function(){
		return $http.get(BASE_URL +"/friendslist")
	}
	
	friendService.blockRequests=function(){
		return $http.get(BASE_URL + "/blockRequests")
	}
	
	friendService.deleteFriendRequest=function(id,status){
		return $http.delete("http://localhost:8083/EvolJobB/deleteFriend/"+id)
	}
	return friendService;
})