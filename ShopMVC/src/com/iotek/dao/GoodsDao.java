package com.iotek.dao;

import java.util.ArrayList;

import com.iotek.entity.Goods;

public interface GoodsDao {
	public ArrayList<Goods> getallgoods();
	public void updategoods(int id);
	public void addgoods();
	public void deletegoods(int id);
	ArrayList<Goods> getgoodsbykey(String key);
	ArrayList<Goods> getgoodsbyPage(String key, int currpage, int pagesize);
}
