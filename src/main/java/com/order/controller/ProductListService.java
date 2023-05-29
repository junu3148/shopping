package com.order.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.order.dao.CustomerDAO;
import com.order.vo.ProductVO;



public class ProductListService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductListService() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = null;
		session = request.getSession();
		String uid = (String)session.getAttribute("customerid");
		List<ProductVO> productList = null;
		RequestDispatcher rd = null;
		if (uid != null) {
			CustomerDAO dao = new CustomerDAO();
			//productList = dao.getAllProducts();
			 	if (productList != null) {
				rd = request.getRequestDispatcher("/product.jsp");
				request.setAttribute("product", productList);
				rd.forward(request, response);
			}
		}else {// 로그인 안되어 있는 경우
			response.sendRedirect("./login.do");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
