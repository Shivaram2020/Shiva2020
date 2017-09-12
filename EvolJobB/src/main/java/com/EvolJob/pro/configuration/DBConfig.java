package com.EvolJob.pro.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.EvolJob.pro.model.BlogComment;
import com.EvolJob.pro.model.BlogPost;
import com.EvolJob.pro.model.Friend;
import com.EvolJob.pro.model.Job;
import com.EvolJob.pro.model.ProfilePicture;
import com.EvolJob.pro.model.User;

@Configuration
@EnableTransactionManagement
public class DBConfig {
	//create an instance

@Bean
public SessionFactory sessionFactory(){
	LocalSessionFactoryBuilder lsf=new LocalSessionFactoryBuilder(getDataSource());
	Properties hibernateProperties=new Properties();
	hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
	hibernateProperties.setProperty("hibernate.hbm2ddl.auto","update");
	hibernateProperties.setProperty("hibernate.show_sql","true");
	lsf.addProperties(hibernateProperties);
	Class classes[]=new Class[]{User.class,Job.class,BlogPost.class,BlogComment.class,ProfilePicture.class,Friend.class};
	return lsf.addAnnotatedClasses(classes).buildSessionFactory();
}

@Bean
public DataSource getDataSource(){
	BasicDataSource dataSource=new BasicDataSource();
	dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	dataSource.setUsername("shiva");
	dataSource.setPassword("143");
	return dataSource;
}

@Bean
public HibernateTransactionManager hibTransManagement(){
	return new HibernateTransactionManager(sessionFactory());
}

}
