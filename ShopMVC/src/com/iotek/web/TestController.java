package com.iotek.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iotek.auth.UserAuth;
import com.iotek.entity.Menu;
import com.iotek.entity.User;
import com.iotek.service.AuthService;
import com.iotek.service.UserService;


@Controller
public class TestController {
	@Autowired
	private UserService userService;

	@Autowired
	private AuthService authService;

	@RequestMapping("/fin1.do")
	public String init2() {
		return "a_login";
	}
	
	@RequestMapping("/ainit.do")
	public String init() {
		return "a_login";
	}

	@RequestMapping("/alogin.do")
	public String login(Model model, String username, String pwd, HttpSession session) {
		User user = userService.queryUser(username, pwd);
		if (user == null) {
			return "a_login";
		}
		session.setAttribute("user", user);
		List<Menu> list = authService.queryMenuByUserId(user.getId());
		UserAuth.addAuth(user.getId(), list);
		model.addAttribute("menu", list);
		return "a_main";
	}
}
