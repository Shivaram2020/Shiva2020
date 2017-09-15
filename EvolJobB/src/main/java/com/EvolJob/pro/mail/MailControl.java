package com.EvolJob.pro.mail;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.EvolJob.pro.model.ApplyJob;




@Service("mailControl")
public class MailControl {
	
	
	
		@Autowired
		JavaMailSender mailSender;

		
		public void sendEmail(Object object) {

			ApplyJob job = (ApplyJob) object;

			MimeMessagePreparator preparator = getMessagePreparator(job);

			try {
				mailSender.send(preparator);
				System.out.println("Message Send...Evoljob");
			} catch (MailException ex) {
				System.err.println(ex.getMessage());
			}
		}

		private MimeMessagePreparator getMessagePreparator(final ApplyJob job) {

			MimeMessagePreparator preparator = new MimeMessagePreparator() {

				public void prepare(MimeMessage mimeMessage) throws Exception {
					mimeMessage.setFrom("confirmationmail@EvolJob.com");
					mimeMessage.setRecipient(Message.RecipientType.TO,
							new InternetAddress(job.getEmail()));
					mimeMessage.setText("Dear " + job.getUsername()
							+ ",  you have applied for job is success. applied job name: "+" "+job.getJobTitle()
							+"    "+ "job id"+" "+job.getJobid()+"    "+"details about applied job"+" "+job.getJobDescription()+"    " +",CompanyName:"+" "+job.getCompanyname()+ "   "+"All the best,stay connect EvolJob!"+".");
					mimeMessage.setSubject("EvolJob job apply Confirmation");
				}
			};
			return preparator;
		}

	}
	

