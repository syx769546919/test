package com.iotek.auth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.iotek.entity.Menu;

public class UserAuth {

	private static Map<Integer, List<Menu>> authMap = new HashMap<Integer, List<Menu>>();

	/**
	 * 添加一个用户对应的菜单
	 * 
	 * @param userId
	 * @param list
	 */
	public static void addAuth(Integer userId, List<Menu> list) {
		authMap.put(userId, list);
	}

	/**
	 * 根据用户id获取菜单
	 * 
	 * @param userId
	 * @return
	 */
	public static List<Menu> getMenuByUserId(Integer userId) {
		return authMap.get(userId);
	}

	/**
	 * 校验给定用户是否可以访问给定url
	 * 
	 * @param userId
	 * @param url
	 * @return
	 */
	public static boolean validateAuth(int userId, String url) {
		List<Menu> list = authMap.get(userId);
		for (Menu m : list) {
			if (m.getUrl().equals(url)) {
				return true;
			}
		}
		return false;
	}
}
