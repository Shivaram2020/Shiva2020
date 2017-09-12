package com.EvolJob.pro.dao;

import com.EvolJob.pro.model.ProfilePicture;

public interface ProfilePictureDao {
void save(ProfilePicture profilePicture);
ProfilePicture getProfilePic(String username);
}