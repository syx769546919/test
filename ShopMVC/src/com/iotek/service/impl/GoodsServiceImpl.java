package com.iotek.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iotek.dao.GoodsDao;
import com.iotek.dao.ShopCartDao;
import com.iotek.dao.impl.GoodsDaoImpl;
import com.iotek.dao.impl.Shopcartdaoimpl;
import com.iotek.entity.Cartinf;
import com.iotek.entity.Goods;
import com.iotek.entity.Pagination;
import com.iotek.entity.Shopcart;
import com.iotek.service.GoodsService;
@Service("gs")
public class GoodsServiceImpl implements GoodsService{
	@Resource
	private GoodsDao gd;
	@Resource
	private ShopCartDao scDao;
	@Override
	public ArrayList<Goods> querygoodsbykey(String key) {
		
		return gd.getgoodsbykey(key);
	}

	@Override
	public Pagination querycurrentgoods(int currpage,String key) {
		Pagination page=new Pagination();
		page.setPagesize(2);
		int count=gd.getgoodsbykey(key).size();
		page.setTatalcount(count);
		if(page.getTotalpage()<currpage) {
			currpage=page.getTotalpage();
		}
		page.setCurrpage(currpage);
		page.setDatalist(gd.getgoodsbyPage(key, currpage, 2));
		return page;
	}

	@Override
	public Cartinf queryCartByUser(int userId) {
		Cartinf cart = new Cartinf();
		cart.setCartList(scDao.queryAll(userId));

		int count = 0;
		double amount = 0;
		for (Shopcart sc : cart.getCartList()) {
			count += sc.getQty();
			amount += sc.getQty() * sc.getGoods().getPrize();
		}
		cart.setTotalCount(count);
		cart.setAmount(amount);
		return cart;
	}

	@Override
	public void addGoods2Cart(int goodsId, int userId,int count) {
		Shopcart sc = scDao.queryByUser2Good(userId, goodsId);
		if (sc != null) {
			scDao.updateCartQty(userId, goodsId, count);
		} else {
			scDao.addCart(userId, goodsId, 1);
		}
		
	}

	@Override
	public void removecart(int goodsId, int userId) {
		Shopcart sc = scDao.queryByUser2Good(userId, goodsId);
		if (sc != null) {
			scDao.deleteCart(userId, goodsId);
		}
	}

}
