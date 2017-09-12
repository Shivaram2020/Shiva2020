package com.EvolJob.pro.dao;

import java.util.List;

import com.EvolJob.pro.model.Job;

public interface JobDao {
	void saveJob(Job job);

	
	Job getJobById(int id);

	List<Job> getAllJobs();


}
