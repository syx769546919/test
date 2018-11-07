package com.iotek.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iotek.entity.Pagination;
import com.iotek.service.GoodsService;
import com.iotek.service.impl.GoodsServiceImpl;

/**
 * Servlet implementation class QuerybypageSevrlet
 */
@WebServlet("/QuerySevrlet")
public class QuerybypageSevrlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GoodsService gs=new GoodsServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuerybypageSevrlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String currPageStr = req.getParameter("currPage");
		String key = req.getParameter("key");
		int currPage = 1;
		if (currPageStr != null && !"".equals(currPageStr)) {
			currPage = Integer.parseInt(currPageStr);
			if (currPage < 1) {
				currPage = 1;
			}
		}
		Pagination pagination = gs.querycurrentgoods(currPage, key);
		req.setAttribute("pagination", pagination);
		req.getRequestDispatcher("searchResult.jsp").forward(req, resp);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
