package com.EvolJob.pro.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import com.EvolJob.pro.dao.ApplyJobDaoImpl;
import com.EvolJob.pro.mail.MailControl1;
import com.EvolJob.pro.model.ApplyJob;
import com.EvolJob.pro.model.BlogComment;
import com.EvolJob.pro.model.BlogPost;
import com.EvolJob.pro.model.CoverPicture;
import com.EvolJob.pro.model.Friend;
import com.EvolJob.pro.model.Job;
import com.EvolJob.pro.model.ProfilePicture;
import com.EvolJob.pro.model.User;

@Configuration
@ComponentScan(basePackages="com.EvolJob.pro.mail")
@EnableTransactionManagement
public class DBConfig {
	//create an instance

@Bean
public SessionFactory sessionFactory(){
	LocalSessionFactoryBuilder lsf=new LocalSessionFactoryBuilder(getDataSource());

	System.out.println("nate working");
	
	Properties hibernateProperties=new Properties();
	hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
	hibernateProperties.setProperty("hibernate.hbm2ddl.auto","update");
	hibernateProperties.setProperty("hibernate.show_sql","true");
	lsf.addProperties(hibernateProperties);
	Class classes[]=new Class[]{User.class,Job.class,BlogPost.class,BlogComment.class,ProfilePicture.class,Friend.class,ApplyJob.class,CoverPicture.class};
	return lsf.addAnnotatedClasses(classes).buildSessionFactory();
}

@Bean
public JavaMailSender getMailSender()
{
	JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	//Using Gmail SMTP configuration.
	mailSender.setHost("smtp.gmail.com");
	mailSender.setPort(587);
	mailSender.setUsername("shivar.vijay.07@gmail.com");
	mailSender.setPassword("SHwSE-2020");
	
	Properties javaMailProperties = new Properties();
	javaMailProperties.put("mail.smtp.starttls.enable", "true");
	javaMailProperties.put("mail.smtp.auth", "true");
	javaMailProperties.put("mail.transport.protocol", "smtp");
	javaMailProperties.put("mail.debug", "true");
	
	System.out.println("mail working");
	mailSender.setJavaMailProperties(javaMailProperties);
	return mailSender;
}




@Bean
public DataSource getDataSource(){
	BasicDataSource dataSource=new BasicDataSource();
	dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	dataSource.setUsername("shiva");
	dataSource.setPassword("143");

	System.out.println("data working");
	return dataSource;
}

@Bean
public HibernateTransactionManager hibTransManagement(){

	System.out.println("hibe working");
	return new HibernateTransactionManager(sessionFactory());
}


@Autowired
@Bean(name="applyDAO")
public ApplyJobDaoImpl getSupplierDAO(SessionFactory sessionFactory)
{

	System.out.println("dao working");
	return new ApplyJobDaoImpl(sessionFactory);
}


@Autowired
@Bean(name="mailControl1")
public MailControl1 getMailControl(SessionFactory sessionFactory)
{

	System.out.println("dao working");
	return new MailControl1(sessionFactory);
}

}
