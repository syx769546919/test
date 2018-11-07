package com.iotek.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.iotek.entity.Cartinf;
import com.iotek.entity.User;
import com.iotek.service.GoodsService;
import com.iotek.service.impl.GoodsServiceImpl;


@WebServlet("/Addcart")
public class AddcartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GoodsService gs=new GoodsServiceImpl();
    public AddcartServlet() {
        super();
 
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String goodsIdStr = req.getParameter("goodsId");
		int goodsId = Integer.parseInt(goodsIdStr);
		User user = (User) req.getSession().getAttribute("user");
		gs.addGoods2Cart(goodsId, user.getId(),1);
		Cartinf cart = gs.queryCartByUser(user.getId());
		req.getSession().setAttribute("cartInfo", cart);
		String json = JSONObject.toJSONString(cart);
		resp.getWriter().write(json);
		resp.getWriter().flush();
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
