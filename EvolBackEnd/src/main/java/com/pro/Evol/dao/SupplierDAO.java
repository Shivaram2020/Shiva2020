package com.pro.Evol.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pro.Evol.model.Supplier;

@Repository("supplierDAO")
public class SupplierDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	public SupplierDAO(SessionFactory sessionFactory1)
	{
		this.sessionFactory=sessionFactory1;
	}
	
	@Transactional
	public void insertUpdateSupplier(Supplier supplier)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(supplier);
	}
	
	public Supplier getSupplier(int catid)
	{
		Session session=sessionFactory.openSession();
		Supplier supplier=(Supplier)session.get(Supplier.class,catid);
		session.close();
		return supplier;
	}
	
	@Transactional
	public void deleteSupplier(Supplier supplier)
	{
		sessionFactory.getCurrentSession().delete(supplier);
	}
	
	public List<Supplier> getSupplierDetails()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Supplier");
		List<Supplier> list=query.list();
		session.close();
		return list;
	}
	


}
