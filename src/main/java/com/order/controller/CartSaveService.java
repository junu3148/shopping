package com.order.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.order.vo.ProductVO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CartSaveService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartSaveService() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = null;
		session = request.getSession();
		String customerid = (String) session.getAttribute("customerid");
		if (customerid != null) {
			ProductVO product = new ProductVO();
			product.setProductId(request.getParameter("productId"));
			product.setProductName(request.getParameter("productName"));
			product.setProductEA(Integer.parseInt(request.getParameter("productEA")));
			product.setPrice(Integer.parseInt(request.getParameter("price")));
			ArrayList<ProductVO> cart = null;
			cart = (ArrayList) session.getAttribute("cart");
			if (cart != null) {
				cart.add(product);
			} else {
				cart = new ArrayList<ProductVO>();
				cart.add(product);
			}
			session.setAttribute("cart", cart);
			//response.sendRedirect("./snackList");
			out.println("<html><head></head><body>");
			out.println("<script>");
			out.println("if(window.confirm('계속 쇼핑하시겠습니까?')){");
			out.println("location.href='./productList' ");
			out.println("}else{");
			out.println("location.href='./viewCart.jsp' ");
			out.println("}</script>");
			out.println("</body></html>");
				
		}
		

	}// doPost() end
}// class end
