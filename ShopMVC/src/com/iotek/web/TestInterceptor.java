package com.iotek.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.iotek.auth.UserAuth;
import com.iotek.entity.User;

public class TestInterceptor implements HandlerInterceptor {
	private List<String> excludeUrls;
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("进入after方法================");

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("进入post方法================");

	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println(arg0.getServletPath());
		String url = arg0.getServletPath().substring(1);
		if (excludeUrls.contains(url)) {
			System.out.println("路径包含");
			return true;
		}

		User user = (User) arg0.getSession().getAttribute("user");
		if (user == null) {
			System.out.println("11");
			return false;
		}


		if(!UserAuth.validateAuth(user.getId(), url)) {
			System.out.println("路径不包含");
			arg1.sendRedirect("init.do");
			return false;
		}
		
		return true;
	}
	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}
}
