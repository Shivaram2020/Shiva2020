package MailTestCase;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.EvolJob.pro.configuration.DBConfig;
import com.EvolJob.pro.mail.ApplyJobService;
import com.EvolJob.pro.model.ApplyJob;

public class MailTestCase {

	
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);

		ApplyJobService orderService = (ApplyJobService) context.getBean("mailControl1");
		orderService.sendOrderConfirmation1(getDummyOrder());
		((AbstractApplicationContext) context).close();
	}
	
	public static ApplyJob getDummyOrder(){
		ApplyJob order = new ApplyJob();
		order.setJobid(1111);
		order.setUsername("Thinkpad T510");
		order.setStatus("confirmed");
		order.setJobDescription("asdasdasd");
		order.setJobTitle("sssss");
		order.setCompanyname("google");
		order.setEmail("shivar.vijay.07@gmail.com");
		
		return order;
	}

	
	
}
