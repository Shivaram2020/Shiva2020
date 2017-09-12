package com.EvolJob.pro.dao;

import java.util.List;

import com.EvolJob.pro.model.Friend;
import com.EvolJob.pro.model.User;

public interface FriendDao {
List<User> getSuggestedUsers(String username);
public void friendRequest(String username,String toid);
public List<Friend> pendingRequests(String Username);
public List<Friend> following(String Username);
public List<Friend> blockRequests(String Username);
void updatePendingRequest(String from, String username, char status);
public List<Friend> listOfFriends(String username);
Friend getFriendById(int id);
void deleteFriendRequest(Friend friend);


}