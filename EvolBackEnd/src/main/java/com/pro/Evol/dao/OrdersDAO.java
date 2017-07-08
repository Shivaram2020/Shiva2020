package com.pro.Evol.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pro.Evol.model.Orders;




@Repository("ordersDAO")

public class OrdersDAO {

	
	@Autowired
	SessionFactory sessionFactory;
	
	public OrdersDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void insertUpdateOrders(Orders orders)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(orders);
	}
	
	public Orders getOrders(int id)
	{
		Session session=sessionFactory.openSession();
		Orders orders=(Orders)session.get(Orders.class,id);
		session.close();
		return orders;
	}

	@Transactional
	public void deleteOrders(Orders orders)
	{
		sessionFactory.getCurrentSession().delete(orders);
	}
	
	public List<Orders> getOrdersDetails(String username)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Orders  where username=:username and status='Y'");
		query.setParameter("username", username);
		@SuppressWarnings("unchecked")
		List<Orders> list=query.list();
		session.close();
		return list;
	}

	
	
	
	
}
