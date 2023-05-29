package com.order.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.order.vo.CartVO;
import com.order.vo.ProductVO;

@Repository
public class ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	//------------------ getProductList -----------------------
	public List<ProductVO> getProductList() { // 5/22구현
		System.out.println("DAO getProductList");

		List<ProductVO> productList = sqlSession.selectList("product.selectProductList");
		
		return productList; // 삽입 결과 반환
	}
	//------------------  getProduct -----------------------
	public List<ProductVO> searchProduct(String keyword) { // 5/22구현
		System.out.println("DAO searchProduct");
	
		List<ProductVO> products =sqlSession.selectList("product.searchProduct",keyword);
		
		return products; // 삽입 결과 반환
	}
	
	//------------------  cartProductSearch -----------------------
	  public ProductVO cartProductSearch(String productId){
		  System.out.println("DAO cartProductSearch()");
		 
	      ProductVO list = sqlSession.selectOne("product.cartProductSearch",productId);   
	      
	      return list;
	   }

	
}
	   