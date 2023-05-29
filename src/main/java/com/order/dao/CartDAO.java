package com.order.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.order.vo.CartListVO;
import com.order.vo.CartVO;
import com.order.vo.CustomerVO;

@Repository
public class CartDAO {

	@Autowired
	private SqlSession sqlSession;

//-------------------------------- addCart -----------------------------------------
	public int addCart(CartVO cartVO) {
		System.out.println("DAO addCart()");
		int row = 0;
		row = sqlSession.insert("cart.insertCart", cartVO);
		return row;
	}

//-------------------------------- getCartList -----------------------------------------
	public List<CartListVO> getCartList(CustomerVO customerVO) {
		System.out.println("DAO getCartList()");
		List<CartListVO> cartList = sqlSession.selectList("cart.selectCartList", customerVO);
		return cartList;
	}

//-------------------------------- deleteCart -----------------------------------------
	public int deleteCart(CartVO cartVO) {
		System.out.println("DAO deleteCart()");
		int row = 0;
		row = sqlSession.delete("cart.deleteCart", cartVO);
		return row;
	}

//-------------------------------- deleteCartAll -----------------------------------------
	public int deleteCartAll(CustomerVO customerVO) {
		System.out.println("DAO deleteCartAll()");
		int row = 0;
		row = sqlSession.delete("cart.deleteCartAll", customerVO);
		return row;
	}

// -------------------------------- deleteCartAll -----------------------------------------
	public int getTotal(CustomerVO customerVO) {
		System.out.println("DAO deleteCartAll()");
		int row = 0;
		row = sqlSession.selectOne("cart.getTotal", customerVO);
		return row;
	}

}
