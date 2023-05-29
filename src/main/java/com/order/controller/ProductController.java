package com.order.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.order.service.CustomerService;
import com.order.service.ProductService;
import com.order.vo.CustomerVO;
import com.order.vo.ProductVO;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private ProductVO productVO;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CustomerVO customerVO;

	@RequestMapping(value = "/productList", method = { RequestMethod.GET, RequestMethod.POST })
	public String getProductList(HttpSession session, Model model) {
		System.out.println("productList");

		List<ProductVO> productList = productService.getProductList();
		model.addAttribute("productList", productList);
		
		customerVO = (CustomerVO) session.getAttribute("customerVO");
		model.addAttribute("user", customerVO);

		return "productView";
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchProductList(@RequestParam("searchOption") String option,
			@RequestParam("keyword") String keyword, Model model) {
		System.out.println("productList");

		List<ProductVO> productList = productService.searchProduct(option, keyword);

		model.addAttribute("productList", productList);

		return "productView";
	}

}// Class Ends
