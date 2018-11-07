package com.iotek.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iotek.entity.Goods;
import com.iotek.service.GoodsService;
import com.iotek.service.impl.GoodsServiceImpl;

/**
 * Servlet implementation class QuerySevrlet
 */
@WebServlet("/QuerySevrlet2")
public class QuerySevrlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private GoodsService gs=new GoodsServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuerySevrlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key=request.getParameter("key");
		System.out.println(key);
		ArrayList<Goods> goods=gs.querygoodsbykey(key);
		request.setAttribute("goodslist", goods);
		request.getRequestDispatcher("searchResult.jsp").forward(request, response);;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
