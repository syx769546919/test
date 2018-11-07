package com.iotek.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.iotek.dao.MenuDao;
import com.iotek.entity.Menu;
import com.iotek.utils.DBUtils;

@Repository
public class MenuDaoImp implements MenuDao {

	@Override
	public List<Menu> queryMenu(int userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Menu> list = new ArrayList<Menu>();
		try {
			conn = DBUtils.getConn();
			String sql = "select m.menu_id, m.menu_name,m.url from t_user u,t_role r,t_menu m,t_role_menu rm "
					+ " where u.role_id=r.role_id and r.role_id=rm.role_id "
					+ " and rm.menu_id=m.menu_id and u.user_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			Menu menu;
			while (rs.next()) {
				menu = new Menu();
				menu.setMenuId(rs.getInt("menu_id"));
				menu.setMenuName(rs.getString("menu_name"));
				menu.setUrl(rs.getString("url"));
				list.add(menu);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, pstmt, conn);
		}
		return list;
	}

}
