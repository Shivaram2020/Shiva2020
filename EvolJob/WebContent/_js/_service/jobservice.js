/**
 * JobService
 */

app.factory('JobService',function($http){
	var jobService={}
	
	jobService.saveJob=function(job){
	  return  $http.post("http://localhost:8083/EvolJobB/savejob",job)
	}
	jobService.getAllJobs=function(){
		 return  $http.get("http://localhost:8083/EvolJobB/getalljobs")
	}
	jobService.getJobById=function(id){
		return $http.get("http://localhost:8083/EvolJobB/getjobbyid/"+id)
	}
	return jobService;
})
