package com.pro.Evol.mail;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import com.pro.Evol.model.Orders;



@Service("mailControl")
public class MailControl {
	
	
	
		@Autowired
		JavaMailSender mailSender;

		
		public void sendEmail(Object object) {

			Orders order = (Orders) object;

			MimeMessagePreparator preparator = getMessagePreparator(order);

			try {
				mailSender.send(preparator);
				System.out.println("Message Send...Hurrey");
			} catch (MailException ex) {
				System.err.println(ex.getMessage());
			}
		}

		private MimeMessagePreparator getMessagePreparator(final Orders order) {

			MimeMessagePreparator preparator = new MimeMessagePreparator() {

				public void prepare(MimeMessage mimeMessage) throws Exception {
					mimeMessage.setFrom("customerserivces@yourshop.com");
					mimeMessage.setRecipient(Message.RecipientType.TO,
							new InternetAddress(order.getEmail()));
					mimeMessage.setText("Dear " + order.getUsername()
							+ ", thank you for placing order success. Your id is: "+" "+order.getOrderid()
							+"    "+ "your mode of payment:"+" "+order.getPaymode()+"    "+"Total cost:"+" "+order.getTotal()+"    " +",Delivery Address:"+" "+order.getShipmentaddress()+ "   "+"Delivery within 10 to 15 days!"+".");
					mimeMessage.setSubject("Evol order Confirmation");
				}
			};
			return preparator;
		}

	}
	

