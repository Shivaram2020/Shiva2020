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
	jobService.getApplyJobs=function(){
		 return  $http.get("http://localhost:8083/EvolJobB/getapplyjobs")
	}
	jobService.getJobById=function(id){
		return $http.get("http://localhost:8083/EvolJobB/getjobbyid/"+id)
	}
	
	jobService.getApplyJobById=function(id){
		return $http.get("http://localhost:8083/EvolJobB/getapplyjobbyid/"+id)
	}
	
	
	
	jobService.deleteJob=function(id){
		return $http.delete("http://localhost:8083/EvolJobB/deletejob/"+id)
	}
	jobService.applyJob=function(id){
		return $http.get("http://localhost:8083/EvolJobB/apply/"+id)
	}
	jobService.confirm=function(id){
		return $http.get("http://localhost:8083/EvolJobB/confirm/"+id)
	}
	jobService.updateJob=function(job){
		return $http.put("http://localhost:8083/EvolJobB/updatejob",job)
	}
	
	return jobService;
})
