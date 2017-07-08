package com.pro.Evol.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pro.Evol.model.Cart;
import com.pro.Evol.model.UserDetails;



@Repository("cartDAO")

public class CartDAO {

	
	@Autowired
	SessionFactory sessionFactory;
	
	public CartDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void insertUpdateCart(Cart cart)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(cart);
	}
	
	public Cart getCart(int cartitemid)
	{
		Session session=sessionFactory.openSession();
		Cart cart=(Cart)session.get(Cart.class,cartitemid);
		session.close();
		return cart;
	}

	@Transactional
	public void deleteCart(Cart cart)
	{
		sessionFactory.getCurrentSession().delete(cart);
	}
	
	public List<Cart> getCartDetails(String username)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Cart where username=:username and status='N'");
		query.setParameter("username", username);
		@SuppressWarnings("unchecked")
		List<Cart> list=query.list();
		session.close();
		return list;
	}

	
	
	
	
}
