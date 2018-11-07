package com.iotek.service;

import java.util.List;

import com.iotek.entity.Menu;

public interface AuthService {
	public List<Menu> queryMenuByUserId(int userId);
}
