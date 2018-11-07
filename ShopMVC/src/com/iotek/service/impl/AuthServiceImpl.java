package com.iotek.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.dao.MenuDao;
import com.iotek.entity.Menu;
import com.iotek.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private MenuDao menuDao;

	@Override
	public List<Menu> queryMenuByUserId(int userId) {
		return menuDao.queryMenu(userId);
	}

}
