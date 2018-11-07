package com.iotek.service;

import java.util.ArrayList;

import com.iotek.entity.Cartinf;
import com.iotek.entity.Goods;
import com.iotek.entity.Pagination;

public interface GoodsService {
	public ArrayList<Goods> querygoodsbykey(String key);
	public Pagination querycurrentgoods(int currpage,String key);
	public Cartinf queryCartByUser(int userId);
	
	public void addGoods2Cart(int goodsId, int userId, int count);
	public void removecart(int goodsId, int userId);
}
