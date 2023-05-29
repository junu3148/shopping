package com.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.dao.CartDAO;
import com.order.vo.CartListVO;
import com.order.vo.CartVO;
import com.order.vo.CustomerVO;

@Service
public class CartService {
	@Autowired
	private CartDAO cartDAO;

//-------------------------------- addCart -----------------------------------------	
	public int addCart(CartVO cartVO) {
		System.out.println("Service addCart()");
		int row = 0;
		row = cartDAO.addCart(cartVO);
		return row;
	}

//-------------------------------- getCartList -----------------------------------------	
	public List<CartListVO> getCartList(CustomerVO customerVO) {
		System.out.println("Service getCartList()");
		List<CartListVO> cartList = cartDAO.getCartList(customerVO);
		return cartList;
	}

//-------------------------------- deleteCart -----------------------------------------
	public int deleteCart(CartVO cartVO) {
		System.out.println("Service deleteCart()");
		int row = 0;
//			Map<String,String> cart = new HashMap<String,String>();
//			cart.put("customerId", customerId);
//			cart.put("productId", productId);
		row = cartDAO.deleteCart(cartVO);
		return row;
	}

//-------------------------------- deleteCartAll -----------------------------------------
	public int deleteCartAll(CustomerVO customerVO) {
		System.out.println("Service deleteCartAll()");
		int row = 0;
		row = cartDAO.deleteCartAll(customerVO);
		return row;
	}

// ---------------------------------- getTotal ------------------------------------------
	public int getTotal(CustomerVO customerVO) {
		System.out.println("Service getTotal()");
		int row = 0;
		row = cartDAO.getTotal(customerVO);
		return row;
	}

// ---------------------------------- getTotal ------------------------------------------
	public int getTotal(List<CartListVO> CartListVO) {
		System.out.println("Service getTotal()");
		int row = 0;
		for (CartListVO vo : CartListVO) {
			row += vo.getTotal();
		}
		return row;
	}

}
