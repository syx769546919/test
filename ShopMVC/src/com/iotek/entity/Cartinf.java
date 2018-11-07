package com.iotek.entity;

import java.util.ArrayList;


public class Cartinf {
	private ArrayList<Shopcart> cartList;
	
	private int totalCount;
	
	private double amount;

	public ArrayList<Shopcart> getCartList() {
		return cartList;
	}

	

	public void setCartList(ArrayList<Shopcart> cartList) {
		this.cartList = cartList;
	}



	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
