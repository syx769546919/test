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

/**
 * Servlet implementation class OperateCartServlet
 */
@WebServlet("/OperateCart")
public class OperateCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private GoodsService gs=new GoodsServiceImpl();
    public OperateCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String goodsIdStr = req.getParameter("goodsId");
		int goodsId = Integer.parseInt(goodsIdStr);
		User user = (User) req.getSession().getAttribute("user");
		String operate=req.getParameter("operate");
		if(operate.equals("add")) {
			gs.addGoods2Cart(goodsId, user.getId(),1);
			Cartinf cart = gs.queryCartByUser(user.getId());
			req.getSession().setAttribute("cartInfo", cart);
			String json = JSONObject.toJSONString(cart);
			resp.getWriter().write(json);
			resp.getWriter().flush();
		}else if(operate.equals("reduce")) {
			gs.addGoods2Cart(goodsId, user.getId(),-1);
			Cartinf cart = gs.queryCartByUser(user.getId());
			req.getSession().setAttribute("cartInfo", cart);
			String json = JSONObject.toJSONString(cart);
			resp.getWriter().write(json);
			resp.getWriter().flush();
		}else if(operate.equals("remove")) {
			gs.removecart(goodsId, user.getId());
			Cartinf cart = gs.queryCartByUser(user.getId());
			req.getSession().setAttribute("cartInfo", cart);
			String json = JSONObject.toJSONString(cart);
			resp.getWriter().write(json);
			resp.getWriter().flush();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
