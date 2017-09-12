package com.EvolJob.pro.dao;

import java.util.List;

import com.EvolJob.pro.model.BlogComment;
import com.EvolJob.pro.model.BlogPost;

public interface BlogPostDao {

void saveBlogPost(BlogPost blogPost);

List<BlogPost> getBlogPosts(int approved);

BlogPost getBlogPostById(int id);

void updateBlogPost(BlogPost blogPost);

void deleteBlogPost(BlogPost blogPost);


void addBlogComment(BlogComment blogComment);

List<BlogComment> getAllBlogComments(int blogPostId);


}
