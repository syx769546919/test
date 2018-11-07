package com.iotek.dao;

import java.util.List;

import com.iotek.entity.Menu;

public interface MenuDao {

	public List<Menu> queryMenu(int userId);
}
