

package com.EvolJob.pro.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.EvolJob.pro.model.Friend;
import com.EvolJob.pro.model.Job;
import com.EvolJob.pro.model.User;

@Repository
public class FriendDaoImpl implements FriendDao{

	
	
@Autowired
private SessionFactory sessionFactory;
	
	public List<User> getSuggestedUsers(String username) {
		Session session=sessionFactory.openSession();
		SQLQuery query=session.createSQLQuery("select * from userdetails where username in (select username from userdetails where username!=? minus (select from_id from frienddetails where to_id=?"
				+ "union select to_id from frienddetails where from_id=?" + "))");
		query.setString(0, username);
		query.setString(1, username);
		query.setString(2, username);
		query.addEntity(User.class);
		List<User> users=query.list();
		session.close();
		return users;
	}
	
	
	@Override

	public void friendRequest(String from, String to){
		Session session=sessionFactory.openSession();
		Friend friend =new Friend();
		friend.setFromId(from);
		friend.setTo(to);
		friend.setStatus('P');
		session.save(friend);
		session.flush();
		session.close();
	}

	public List<Friend> pendingRequests(String toUsername) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where to=? and status=?");
		query.setString(0, toUsername);
		query.setCharacter(1, 'P');
		List<Friend> pendingRequests=query.list();
		session.close();
		return pendingRequests;
	}

	public void updatePendingRequest(String from, String username, char status) {
		Session session=sessionFactory.openSession();
		SQLQuery query=session.createSQLQuery("update frienddetails set status=? where from_id=? and to_id=?");
		query.setCharacter(0, status);
		query.setString(1,from );
		query.setString(2, username);
		int count=query.executeUpdate();
		System.out.println("Number of records updated " + count);
		session.flush();
		session.close();
	}

	public List<Friend> listOfFriends(String username){
		Session session=sessionFactory.openSession();
		SQLQuery query=session.createSQLQuery("select * from frienddetails where (from_id=? or to_id=?) and status=?");
		query.setString(0, username);
		query.setString(1, username);
		query.setCharacter(2, 'A');
		query.addEntity(Friend.class);
		List<Friend> friends=query.list();
		session.close();
		return friends;
	}

	
	public List<Friend> blockRequests(String toUsername) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where to=? and status=?");
		query.setString(0, toUsername);
		query.setCharacter(1, 'D');
		List<Friend> blockRequests=query.list();
		session.close();
		return blockRequests;
	}


	
	public Friend getFriendById(int id) {
		Session session=sessionFactory.openSession();
		Friend friend=(Friend)session.get(Friend.class, id);
		session.close();
		return friend;
		
	}


	@Override
	public void deleteFriendRequest(Friend friend) {
		Session session=sessionFactory.openSession();
	
		session.delete(friend);
		session.flush();
		session.close();
	
	}

	public List<Friend> following(String toUsername) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where fromid=? and status=?");
		
		query.setString(0, toUsername);
		query.setCharacter(1, 'P');
		List<Friend> following=query.list();
		session.close();
		return following;
	}
	
	
	
}


