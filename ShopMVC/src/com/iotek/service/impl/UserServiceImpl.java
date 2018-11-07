package com.iotek.service.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.iotek.dao.UserDao;
import com.iotek.dao.impl.UserDaoImpl;
import com.iotek.entity.User;
import com.iotek.service.UserService;
@Service("us")
public class UserServiceImpl implements UserService{
	
	UserDao ud=new UserDaoImpl();
	@Override
	public User queryUser(String userName, String pwd) {
		
		return ud.queryUserByName2Pwd(userName, pwd);
	}

	@Override
	public ArrayList<User> getuserlist() {
		
		return ud.findalluser();
	}

	@Override
	public boolean couldadduser(User user) {
		String username=user.getUserName();
		User testuser=queryUser(username);
		if(testuser!=null) {
			return false;
		}else {
			ud.registuser(user);
			return true;
		}
		
		
	}

	@Override
	public User queryUser(String userName) {
		return ud.queryUserByName(userName);
	}

}
