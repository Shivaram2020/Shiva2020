package com.pro.Evol.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.pro.Evol.dao.CartDAO;
import com.pro.Evol.dao.CategoryDAO;
import com.pro.Evol.dao.OrdersDAO;
import com.pro.Evol.dao.ProductDAO;
import com.pro.Evol.dao.SupplierDAO;
import com.pro.Evol.dao.UserDAO;
import com.pro.Evol.model.Cart;
import com.pro.Evol.model.Category;
import com.pro.Evol.model.Orders;
import com.pro.Evol.model.Product;
import com.pro.Evol.model.Supplier;
import com.pro.Evol.model.UserDetails;

@Configuration
@ComponentScan("com.mobitel.MobitelBackend")
@EnableTransactionManagement
public class DBConfig 
{

	@Bean(name = "dataSource")
	public DataSource getH2DataSource() 
	{
		System.out.println("Starting of the method getH2DataSource");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("shiva");
		dataSource.setPassword("143");
		return dataSource;
	}

	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		
		
		Properties prop=new Properties();
		prop.setProperty("hibernate.hbm2ddl.auto", "update");
		prop.put("hibernate.show_sql", "true"); 
		prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(getH2DataSource());
		sessionBuilder.addProperties(prop);
		
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(UserDetails.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(Orders.class);
		SessionFactory sessionFactory=sessionBuilder.buildSessionFactory();
				return sessionFactory;
	}
	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	@Autowired
	@Bean(name="categoryDAO")
	public CategoryDAO getCategoryDAO(SessionFactory sessionFactory)
	{
		return new CategoryDAO(sessionFactory);
	}
		@Autowired
	@Bean(name="supplierDAO")
	public SupplierDAO getSupplierDAO(SessionFactory sessionFactory)
	{
		return new SupplierDAO(sessionFactory);
	}
	
		@Autowired
		@Bean(name="userDAO")
		public UserDAO getUserDAO(SessionFactory sessionFactory)
		{
			return new UserDAO(sessionFactory);
		}
		
		
		@Autowired
		@Bean(name="productDAO")
		public ProductDAO getProductDAO(SessionFactory sessionFactory)
		{
			return new ProductDAO(sessionFactory);
		}

		@Autowired
		@Bean(name="cartDAO")
		public CartDAO getCartDAO(SessionFactory sessionFactory)
		{
			return new CartDAO(sessionFactory);
		}
		@Autowired
		@Bean(name="ordersDAO")
		public OrdersDAO getOrderDAO(SessionFactory sessionFactory)
		{
			return new OrdersDAO(sessionFactory);
		}

}


