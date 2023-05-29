package com.order.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.order.service.CartService;
import com.order.service.ProductService;
import com.order.vo.CartListVO;
import com.order.vo.CartVO;
import com.order.vo.CustomerVO;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;
	@Autowired
	private CustomerVO customerVO;
	@Autowired
	private ProductService productService;

//--------------------------------- addCart ----------------------------------	
	@RequestMapping(value = "/addCart", method = { RequestMethod.GET, RequestMethod.POST })
	public String addcart(@MatrixVariable CartVO cartVO, Model model) {
		System.out.println("addCart");

		cartService.addCart(cartVO);
		// 추가구매 할때 만들기

		return "reAddCart";
	}

//--------------------------------- getCartlist ----------------------------------
	@RequestMapping(value = "/getCartlist", method = { RequestMethod.GET, RequestMethod.POST })
	public String getCartList(HttpSession session, Model model) {
		System.out.println("getCartlist");

		customerVO = (CustomerVO) session.getAttribute("customerVO");
		List<CartListVO> cartList = cartService.getCartList(customerVO);
		System.out.println(cartList);
		model.addAttribute(cartList);

		return "redirect:/cartForm";
	}

	// --------------------------------- cartForm ----------------------------------
	@RequestMapping(value = "/cartForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String cartForm(HttpSession session, Model model) {
		System.out.println("cartForm");
		customerVO = (CustomerVO) session.getAttribute("customerVO");
		String uri = "/main";
		List<CartListVO> cartList = cartService.getCartList(customerVO);
		if (!cartList.isEmpty()) {
			if (cartList.get(0).getCustomerId() != null) {
				uri = "/cartView";
			}
		}
		model.addAttribute("cartList", cartList);
		model.addAttribute("total", cartService.getTotal(cartList));

		return uri;
	}

//--------------------------------- deleteCart ----------------------------------
	@RequestMapping(value = "/deleteCart", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteCart(@MatrixVariable CartVO cartVO, Model model) {
		System.out.println("deleteCart");
		System.out.println(cartVO);

		cartService.deleteCart(cartVO);

		return "redirect:/cartForm";
	}

//--------------------------------- deleteCartAll ----------------------------------
	@RequestMapping(value = "/deleteCartAll", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteCartAll(@MatrixVariable CustomerVO customerVO, Model model) {
		System.out.println("deleteCartAll");

		cartService.deleteCartAll(customerVO);

		return "redirect:/cartForm";
	}
}
