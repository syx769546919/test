package com.iotek.web;




import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.iotek.entity.Cartinf;
import com.iotek.entity.Pagination;
import com.iotek.entity.Shopcart;
import com.iotek.entity.User;
import com.iotek.service.GoodsService;
import com.iotek.service.UserService;

@Controller
public class ShopController {
	@Resource(name="us")
	private UserService us;
	@Resource(name="gs")
	private GoodsService gs;
	@RequestMapping("/start.do")
	public String init(HttpServletRequest req, HttpServletResponse resp,HttpSession session) {
		System.out.println("1111");
		User user=(User) session.getAttribute("user");
		
		if (user != null) {
			
			return "index.jsp";
		}
		if(user==null) {
			Cookie[] cookies=req.getCookies();
			if(cookies!=null) {
				for (Cookie cookie : cookies) {
					if("usercookie".equals(cookie.getName())) {
						String username=cookie.getValue();
						user=us.queryUser(username);
						req.getSession().setAttribute("user", user);
						Cartinf cart = gs.queryCartByUser(user.getId());
						req.getSession().setAttribute("cartInfo", cart);
						return "index.jsp";
					}
				}
			}
		}
		return "Login.jsp";
	}
	@RequestMapping("/regist.do")
	public String regist(HttpServletRequest req, HttpSession session) {
		User user=new User();
		user.setUserName(req.getParameter("loginName"));
		user.setPwd(req.getParameter("password"));
		user.setE_mail(req.getParameter("email"));
		user.setPhone(req.getParameter("mobile"));

		if(us.couldadduser(user)) {
			req.getSession().setAttribute("user", user);
			return "index.jsp";
		}else {
			req.setAttribute("result", "失败，该用户名已注册");
			return "Regist.jsp";
		}

	}
	@RequestMapping("/login.do")
	public String login(HttpServletRequest req,HttpServletResponse resp) {
		String username=req.getParameter("loginName");
		String pwd=req.getParameter("password");
		User user = us.queryUser(username, pwd);
		String saveLogin = req.getParameter("saveLogin");
		if(user==null) {

			req.setAttribute("result", "用户名或者密码错误");
			return "Login.jsp";
		}else {
			//登录成功
			req.getSession().setAttribute("user", user);
			if (saveLogin != null) {

				Cookie cookie = new Cookie("usercookie", username);
				cookie.setPath("/");
				cookie.setMaxAge(7 * 24 * 60 * 60);
				resp.addCookie(cookie);
			}
			Cartinf cart = gs.queryCartByUser(user.getId());
			req.getSession().setAttribute("cartInfo", cart);
			return "index.jsp";
		}
		
	}
	@RequestMapping("/search.do")
	public String search(String currPageStr,String key,HttpServletRequest req) {
		System.out.println(currPageStr+key);
		int currPage = 1;
		if (currPageStr != null && !"".equals(currPageStr)) {
			currPage = Integer.parseInt(currPageStr);
			if (currPage < 1) {
				currPage = 1;
			}
		}
		Pagination pagination = gs.querycurrentgoods(currPage, key);
		req.setAttribute("pagination", pagination);
		req.setAttribute("key", key);
		return "searchResult.jsp";
	}
	@RequestMapping("/start2.do")
	public String test2() {
		//System.out.println(sp.getGoods().getName());
		//System.out.println(sp.getTime());
		return "index.jsp";
	}
	@RequestMapping("/start3.do")
	public String redirect() {

		return "index.jsp";
		//return "redirect:start2.do";
		//return "forward:start2.do";
	}
	@ResponseBody
	@RequestMapping("/getdata")
	public String getdata() {
		String msg="ajaxsucessful";
		User user=new User();
		user.setId(11);
		user.setUserName("赵六");
		user.setPwd("123456");
		user.setPhone("4564564564");
		user.setE_mail("1@1.con");
		String json=JSONObject.toJSONString(user);
		return json;
	}
	public String addcart() {
		String msg="ajaxsucessful";
		User user=new User();
		user.setId(11);
		user.setUserName("赵六");
		user.setPwd("123456");
		user.setPhone("4564564564");
		user.setE_mail("1@1.con");
		String json=JSONObject.toJSONString(user);
		return json;
	}
	
}
