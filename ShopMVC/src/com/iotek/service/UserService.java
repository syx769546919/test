package com.iotek.service;

import java.util.ArrayList;

import com.iotek.entity.User;

public interface UserService {
	public User queryUser(String userName, String pwd);
	public ArrayList<User> getuserlist();
	public boolean couldadduser(User user);
	public User queryUser(String userName);
}
