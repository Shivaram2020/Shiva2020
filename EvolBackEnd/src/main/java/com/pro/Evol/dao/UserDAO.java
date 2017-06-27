package com.pro.Evol.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pro.Evol.model.UserDetails;
@Repository("userDAO")
public class UserDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	public UserDAO(SessionFactory sessionFactory1)
	{
		this.sessionFactory=sessionFactory1;
	}
	
	@Transactional
	public void insertUpdateUser(UserDetails user)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
	}
	
	public UserDetails getUser(String username)
	{
		Session session=sessionFactory.openSession();
		UserDetails User=(UserDetails)session.get(UserDetails.class,username);
		session.close();
		return User;
	}
	
	@Transactional
	public void deleteUser(UserDetails user)
	{
		sessionFactory.getCurrentSession().delete(user);
	}
	
	public List<UserDetails> getUserDetails()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from UserDetails");
		List<UserDetails> list=query.list();
		session.close();
		return list;
	}
	



}
