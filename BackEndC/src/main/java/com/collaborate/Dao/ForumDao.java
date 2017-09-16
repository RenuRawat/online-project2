package com.collaborate.Dao;

import java.util.List;

import com.collaborate.Model.Forum;

public interface ForumDao {
	
	
	public boolean createForum(Forum forum);
	public Forum getForum(int forumId);
	public List<Forum> getForums();
	public boolean approveForum(Forum forum);
	public boolean editForum(int forumId);
	public boolean deleteForum(int forumId);

}
