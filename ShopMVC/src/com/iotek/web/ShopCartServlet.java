package com.iotek.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iotek.entity.Cartinf;
import com.iotek.entity.User;
import com.iotek.service.GoodsService;
import com.iotek.service.impl.GoodsServiceImpl;

/**
 * Servlet implementation class ShopCartServlet
 */
@WebServlet("/ShopCartServlet")
public class ShopCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GoodsService gs=new GoodsServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopCartServlet() {
        super();
       
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user=(User) req.getSession().getAttribute("user");
		Cartinf cart = gs.queryCartByUser(user.getId());
		req.getSession().setAttribute("cartInfo", cart);
		req.getRequestDispatcher("shopcar.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
