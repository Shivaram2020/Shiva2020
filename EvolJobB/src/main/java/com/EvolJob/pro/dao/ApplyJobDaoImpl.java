package com.EvolJob.pro.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.EvolJob.pro.model.ApplyJob;
import com.EvolJob.pro.model.Job;
import com.EvolJob.pro.model.User;



@Repository("applyDAO")
@Transactional
public class ApplyJobDaoImpl {

	@Autowired
	private SessionFactory sessionFactory;
	public ApplyJobDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}	

	public void saveApplyJob(ApplyJob job) {
		
		Session session=sessionFactory.getCurrentSession();
		session.save(job);
	}

	
	public void updateJob(ApplyJob job) {
		
     Session session=sessionFactory.getCurrentSession();
		

		session.update(job);
		
	}

	
	
	
	
	public ApplyJob getApplyJobById(int id) {
		Session session=sessionFactory.getCurrentSession();
		ApplyJob applyjob=(ApplyJob)session.get(ApplyJob.class, id);
		return applyjob;
	}
	
	
	public List<ApplyJob> getApplyJobs() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from ApplyJob");
		return query.list();
	}

}
