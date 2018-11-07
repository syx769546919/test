package com.iotek.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.iotek.dao.GoodsDao;
import com.iotek.entity.Goods;
import com.iotek.utils.DBUtils;
@Repository
public class GoodsDaoImpl implements GoodsDao{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	@Override
	public ArrayList<Goods> getgoodsbykey(String key) {
		Goods goods=null;
		ArrayList<Goods>list=new ArrayList<>();
		System.out.println(key);
		try {
			conn = DBUtils.getConn();
			String sql = "select * from goods,  category, brand where g_brand_id=b_id and g_category_id=category_id and (name like ? or categoryname like ? or brandname like ?);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"%"+ key+"%");
			pstmt.setString(2,"%"+ key+"%");
			pstmt.setString(3,"%"+ key+"%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				goods = new Goods();
				goods.setId(rs.getInt("id"));
				goods.setName(rs.getString("name"));
				goods.setBrand(rs.getString("brandname"));
				goods.setCategory(rs.getString("categoryname"));
				goods.setCount(rs.getInt("count"));
				goods.setPicture(rs.getString("picture"));
				goods.setPrize(rs.getDouble("prize"));
				goods.setDesc(rs.getString("desc"));
				list.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, pstmt, conn);
		}
		return list;
	}
	@Override
	public ArrayList<Goods> getgoodsbyPage(String key,int currpage, int pagesize) {
		Goods goods=null;
		ArrayList<Goods>list=new ArrayList<>();
		
		try {
			conn = DBUtils.getConn();
			String sql = "select * from goods,  category, brand where g_brand_id=b_id and g_category_id=category_id and (name like ? or categoryname like ? or brandname like ?) limit ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"%"+ key+"%");
			pstmt.setString(2,"%"+ key+"%");
			pstmt.setString(3,"%"+ key+"%");
			pstmt.setInt(4,(currpage-1)*pagesize);
			pstmt.setInt(5,pagesize);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				goods = new Goods();
				goods.setId(rs.getInt("id"));
				goods.setName(rs.getString("name"));
				goods.setBrand(rs.getString("brandname"));
				goods.setCategory(rs.getString("categoryname"));
				goods.setCount(rs.getInt("count"));
				goods.setPicture(rs.getString("picture"));
				goods.setPrize(rs.getDouble("prize"));
				goods.setDesc(rs.getString("desc"));
				list.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, pstmt, conn);
		}
		return list;
	}
	@Override
	public ArrayList<Goods> getallgoods() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updategoods(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addgoods() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deletegoods(int id) {
		// TODO Auto-generated method stub
		
	}

}
