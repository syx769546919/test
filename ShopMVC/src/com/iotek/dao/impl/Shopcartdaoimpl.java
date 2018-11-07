package com.iotek.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.iotek.dao.ShopCartDao;
import com.iotek.entity.Goods;
import com.iotek.entity.Shopcart;
import com.iotek.utils.DBUtils;
@Repository
public class Shopcartdaoimpl implements ShopCartDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	@Override
	public void addCart(int userId, int goodsId, int qty) {
		try {
			conn = DBUtils.getConn();
			String sql = "insert into shopcar(goods_id,count,u_id) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, goodsId);
			pstmt.setInt(2, qty);
			pstmt.setInt(3, userId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(null, pstmt, conn);
		}

	}

	@Override
	public void updateCartQty(int userId, int goodsId, int qty) {
		try {
			conn = DBUtils.getConn();
			String sql = "update shopcar set count = count + ? where goods_id=? and u_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qty);
			pstmt.setInt(2, goodsId);
			pstmt.setInt(3, userId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(null, pstmt, conn);
		}

	}



	@Override
	public ArrayList<Shopcart> queryAll(int userId) {
		ArrayList<Shopcart> list=new ArrayList<>();
		try {
			conn = DBUtils.getConn();
			String sql = "select s.car_id, s.count,s.u_id, g.id,g.name,g.prize,g.picture from shopcar s, goods g "
					+ " where s.goods_id=g.id and s.u_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			Shopcart sc;
			Goods goods;
			while (rs.next()) {
				sc = new Shopcart();
				sc.setCartId(rs.getInt("s.car_id"));
				sc.setQty(rs.getInt("s.count"));
				sc.setUserId(rs.getInt("s.u_id"));
				goods = new Goods();
				goods.setId(rs.getInt("g.id"));
				goods.setName(rs.getString("g.name"));
				goods.setPrize(rs.getDouble("g.prize"));
				goods.setPicture(rs.getString("g.picture"));
				sc.setGoods(goods);
				list.add(sc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(null, pstmt, conn);
		}
		return list;
	}

	@Override
	public Shopcart queryByUser2Good(int userId, int goodsId) {
		Shopcart sc=null;
		try {
			conn = DBUtils.getConn();
			String sql = "select car_id, count, u_id, goods_id from shopcar  "
					+ " where u_id=? and goods_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, goodsId);
			rs = pstmt.executeQuery();
			Goods goods;
			if (rs.next()) {
				sc = new Shopcart();
				sc.setCartId(rs.getInt("car_id"));
				sc.setQty(rs.getInt("count"));
				sc.setUserId(rs.getInt("u_id"));
				goods = new Goods();
				goods.setId(rs.getInt("goods_id"));
				sc.setGoods(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(null, pstmt, conn);
		}
		return sc;
	}

	@Override
	public void deleteCart(int userId, int goodsId) {
		try {
			conn = DBUtils.getConn();
			String sql = "Delete from shopcar where u_id=? and goods_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, goodsId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(null, pstmt, conn);
		}
		
	}

}
