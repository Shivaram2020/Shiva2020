/**
 * UserService
 */
app.factory('userservice',function($http){
	var userservice={}
	var BASE_URL="http://localhost:8084/EvolJobB/"
	
	userservice.registerUser=function(user){
		return $http.post(BASE_URL+"/register",user);
	}	
	userservice.validateUser=function(user){
		return $http.post(BASE_URL+"/login",user)
	}
	
	userservice.logout=function(){
		return $http.get(BASE_URL+"/logout")
	}
	userservice.getUser=function(){
		return $http.get(BASE_URL + "/getuser")
	}
	
	userservice.updateUser=function(user){
		return $http.put(BASE_URL + "/updateuser",user)
	}
	return userservice; //returning the instance
})

