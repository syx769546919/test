package com.iotek.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.iotek.dao.UserDao;
import com.iotek.entity.User;
import com.iotek.utils.DBUtils;
@Repository
public class UserDaoImpl implements UserDao{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	@Override
	public User queryUserByName2Pwd(String username, String pwd) {
		User user = null;

		try {
			conn = DBUtils.getConn();
			String sql = "select * from user where user_name=? and pwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("user_name"));
				user.setPwd(rs.getString("pwd"));
				user.setE_mail(rs.getString("e_mail"));
				user.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, pstmt, conn);
		}
		return user;
	}

	@Override
	public ArrayList<User> findalluser() {
		User user=null;
		ArrayList<User>list=new ArrayList<>();
		try {
			conn = DBUtils.getConn();
			String sql = "select * from user";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("user_name"));
				user.setPwd(rs.getString("pwd"));
				user.setE_mail(rs.getString("e_mail"));
				user.setPhone(rs.getString("phone"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public void registuser(User user) {
		String username=user.getUserName();
		String passwoed=user.getPwd();
		String e_mail=user.getE_mail();
		String phone=user.getPhone();
		System.out.println(username);
		try {
			conn = DBUtils.getConn();
			String sql = "Insert into user(user_name, pwd, e_mail, phone) values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, passwoed);
			pstmt.setString(3, e_mail);
			pstmt.setString(4, phone);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, pstmt, conn);
		}
		
	}

	@Override
	public User queryUserByName(String username) {
		User user = null;

		try {
			conn = DBUtils.getConn();
			String sql = "select * from user where user_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("user_name"));
				user.setPwd(rs.getString("pwd"));
				user.setE_mail(rs.getString("e_mail"));
				user.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, pstmt, conn);
		}
		return user;
	}



}
