package com.iotek.dao;

import java.util.ArrayList;

import com.iotek.entity.Shopcart;

public interface ShopCartDao {
	public void addCart(int userId, int goodsId, int qty);
	public void updateCartQty(int userId, int goodsId, int qty);

	public void deleteCart(int userId,int goodsId);

	public ArrayList<Shopcart> queryAll(int userId);
	public Shopcart queryByUser2Good(int userId, int goodsId);
	
	
}
