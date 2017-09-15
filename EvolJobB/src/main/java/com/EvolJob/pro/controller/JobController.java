package com.EvolJob.pro.controller;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.EvolJob.pro.configuration.DBConfig;

import com.EvolJob.pro.dao.ApplyJobDaoImpl;
import com.EvolJob.pro.dao.JobDao;
import com.EvolJob.pro.dao.UserDao;
import com.EvolJob.pro.mail.ApplyJobService;
import com.EvolJob.pro.model.Job;
import com.EvolJob.pro.model.User;
import com.EvolJob.pro.model.ApplyJob;

import com.EvolJob.pro.model.Error;

@Controller
public class JobController {
	@Autowired
private JobDao jobDao;
	
	@Autowired
	private ApplyJobDaoImpl applyJobDao;
		

	
	@Autowired
private UserDao userDao;
	
	@RequestMapping(value="/savejob",method=RequestMethod.POST)
	public ResponseEntity<?> saveJob(@RequestBody Job job,HttpSession session){
		if(session.getAttribute("username")==null){
			Error error=new Error(5,"UnAuthroized User");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		String username=(String)session.getAttribute("username");
		User user=userDao.getUserByUsername(username);
        if(user.getRole().equals("admin")){
        	try{
        		job.setPostedOn(new Date());
        	jobDao.saveJob(job);
        	return new ResponseEntity<Job>(job,HttpStatus.OK);
        	}catch(Exception e){
        		Error error=new Error(7,"Unable to insert job details " + e.getMessage());
        		return new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);
        	}
        }
        else{
        	Error error=new Error(6,"Access Denied");
        	return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
        }
		
	}
	@RequestMapping(value="/getalljobs",method=RequestMethod.GET)
	public ResponseEntity<?> getAllJobs(HttpSession session){
		if(session.getAttribute("username")==null){
			Error error=new Error(5,"UnAuthroized User");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		List<Job> jobs=jobDao.getAllJobs();
		return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/getapplyjobs",method=RequestMethod.GET)
	public ResponseEntity<?> getApplyJobs(HttpSession session){
		if(session.getAttribute("username")==null){
			Error error=new Error(5,"UnAuthroized User");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		List<ApplyJob> jobs=applyJobDao.getApplyJobs();
		return new ResponseEntity<List<ApplyJob>>(jobs,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/getjobbyid/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> getJobById(@PathVariable int id,HttpSession session){
		if(session.getAttribute("username")==null){
			Error error=new Error(5,"UnAuthroized User");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		Job job=jobDao.getJobById(id);
		return new ResponseEntity<Job>(job,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/getapplyjobbyid/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> getApplyJobById(@PathVariable int id,HttpSession session){
		if(session.getAttribute("username")==null){
			Error error=new Error(5,"UnAuthroized User");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		ApplyJob applyjob=applyJobDao.getApplyJobById(id);
		return new ResponseEntity<ApplyJob>(applyjob,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/updatejob",method=RequestMethod.PUT)
	public ResponseEntity<?> updateBlogPost(@RequestBody Job job,HttpSession session){
		if(session.getAttribute("username")==null){
			Error error=new Error(5,"UnAuthorized User");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);//401 - 2nd call back func will be executed
		}
		
		try{
		jobDao.updateJob(job);
		return new ResponseEntity<Job>(job,HttpStatus.OK);//200 - 1st call back function will be called
		}catch(Exception e){
			Error error=new Error(6,"Unable to insert job details " + e.getMessage());
			return new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);//500 - 2nd call back func will be executed
		}
	}
	@RequestMapping(value="/deletejob/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteBlogPost(@PathVariable int id,HttpSession session){
		if(session.getAttribute("username")==null){
			Error error=new Error(5,"UnAuthorized User");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);//401 - 2nd call back func will be executed
		}
		Job job=jobDao.getJobById(id);
		jobDao.deleteJob(job);
		return new ResponseEntity<Job>(job,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/apply/{id}",method=RequestMethod.GET)
	public  ResponseEntity<?> apply(@PathVariable int id,HttpSession session){
		if(session.getAttribute("username")==null){
			Error error=new Error(5,"UnAuthorized User");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);//401 - 2nd call back func will be executed
		}
		
		String username=(String)session.getAttribute("username");
			
		
		
		
		
		Job job=jobDao.getJobById(id);
		User user=userDao.getUserByUsername(username);
				
				ApplyJob apply=new ApplyJob();

		
		apply.setUsername(username);
		apply.setEmail(user.getEmail());
		apply.setJobid(job.getId());
		apply.setJobTitle(job.getJobTitle());
		apply.setJobDescription(job.getJobDescription());
		apply.setCompanyname(job.getCompanyname());
		apply.setStatus("APPLIED");
		applyJobDao.saveApplyJob(apply);
		return new ResponseEntity<ApplyJob>(apply,HttpStatus.OK);
		}
			
	
	

	@RequestMapping(value="/confirm/{id}",method=RequestMethod.GET)	
public static ResponseEntity<?> main(String[] args,HttpSession session,@PathVariable int id) {
		if(session.getAttribute("username")==null){
			Error error=new Error(5,"UnAuthorized User");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);//401 - 2nd call back func will be executed
		}
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
	String username=(String) session.getAttribute("username");
	
		 
	ApplyJobDaoImpl applyDAO=(ApplyJobDaoImpl)context.getBean("applyDAO");
	
	ApplyJob apply= applyDAO.getApplyJobById(id);
	
		ApplyJob send=new ApplyJob();
		send.setUsername(username);
		send.setEmail(apply.getEmail());
		send.setJobid(apply.getJobid());
		send.setJobTitle(apply.getJobTitle());
		send.setJobDescription(apply.getJobDescription());
		send.setCompanyname(apply.getCompanyname());
	
	ApplyJobService applyService = (ApplyJobService) context.getBean("mailControl1");
	applyService.sendOrderConfirmation1(send);
	

	((AbstractApplicationContext) context).close();
	
	
	return new ResponseEntity<ApplyJob>(apply,HttpStatus.OK);
	
}

	
}

