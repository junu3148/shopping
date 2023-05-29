package com.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.dao.ProductDAO;
import com.order.vo.CartVO;
import com.order.vo.ProductVO;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private ProductVO productVO;

	// ------------------ getProductList -----------------------
	public List<ProductVO> getProductList() { // 5/22구현

		System.out.println("Service getProductList");
		List<ProductVO> productList = productDAO.getProductList();

		return productList; // 삽입 결과 반환
	}

	// ------------------ getProduct -----------------------
	public List<ProductVO> searchProduct(String option, String keyword) { // 5/22구현
		System.out.println("Service searchProduct");

		List<ProductVO> products = productDAO.searchProduct(keyword);
		return products; // 삽입 결과 반환
	}

	// ---------------cartProductSearch --------------------

	public List<ProductVO> cartProductSearch(List<CartVO> cartList) {
		System.out.println("Service cartProductSearch()");
		List<ProductVO> list = new ArrayList<ProductVO>();
					
		for(int i=0; i<cartList.size(); i++) {
			String productId = cartList.get(i).getProductId();
			list.add(productDAO.cartProductSearch(productId));
		}
		
		return list;
	}

}
