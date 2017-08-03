
package com.pro.Evol.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pro.Evol.model.Offer;

@Repository("offerDAO")
public class OfferDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public OfferDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void insertUpdateOffer(Offer offer)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(offer);
	}
	
	public Offer getOffer(int catid)
	{
		Session session=sessionFactory.openSession();
		Offer offer=(Offer)session.get(Offer.class,catid);
		session.close();
		return offer;
	}
	
	@Transactional
	public void deleteOffer(Offer offer)
	{
		sessionFactory.getCurrentSession().delete(offer);
	}
	
	public List<Offer> getOfferDetails()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Offer");
		@SuppressWarnings("unchecked")
		List<Offer> list=query.list();
		session.close();
		return list;
	}
	
}

