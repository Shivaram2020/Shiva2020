package com.EvolJob.pro.mail;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EvolJob.pro.model.ApplyJob;




@Service("mailControl1")
public class MailControl1 implements ApplyJobService {
	
	
	@Autowired
	MailControl mailControl;

	
	public MailControl1(SessionFactory sessionFactory) {
		
	}


	@Override
	public void sendOrderConfirmation1(ApplyJob job) {
		mailControl.sendEmail(job);
		
	}


	
	

}
