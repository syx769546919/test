package com.iotek.dao;

import java.util.ArrayList;

import com.iotek.entity.User;

public interface UserDao {
	public User queryUserByName2Pwd(String username, String pwd);
	public ArrayList<User> findalluser();
	public void registuser(User user);
	public User queryUserByName(String username);
}
