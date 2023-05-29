package com.order.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.order.service.CustomerService;
import com.order.service.ProductService;
import com.order.vo.CustomerVO;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private CustomerVO customerVO;

//---------------------- main ---------------------------------------
	@RequestMapping(value = "/main", method = { RequestMethod.GET, RequestMethod.POST })
	public String main() {
		System.out.println("main");

		return "main";
	}

//---------------------- loginForm ---------------------------------------
	@RequestMapping(value = "/loginForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String loginForm(@ModelAttribute CustomerVO customer) {
		System.out.println("loginForm");

		return "/login";
	}

//---------------------- login ---------------------------------------
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(@ModelAttribute CustomerVO customer,HttpSession session ) {
		System.out.println("login");
		String Uri = "redirect:/loginForm";
		this.customerVO = customerService.login(customer);
		if (this.customerVO != null) {
			session.setAttribute("customerVO",this.customerVO);
			Uri = "/main";
		}
		return Uri;
	}

//---------------------- logout ---------------------------------------
	@RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpSession session) {
		System.out.println("logout");
		session.invalidate();

		return "/main";
	}

//---------------------- customerList ---------------------------------------
	@RequestMapping(value = "/customerList", method = { RequestMethod.GET, RequestMethod.POST })
	public String customerList(Model model) {
		System.out.println("customerList");

		List<CustomerVO> customerList = customerService.getCustomerList();
		model.addAttribute("custmerList", customerList);

		return "userlist";
	}

//---------------------- insertForm ---------------------------------------
	@RequestMapping(value = "/insertForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String insertForm() {
		System.out.println("insertForm");

		return "insertCustomer";
	}

//---------------------- insert -------------------------------------------
	@RequestMapping(value = "/insert", method = { RequestMethod.GET, RequestMethod.POST })
	public String insertCustomer(@ModelAttribute CustomerVO customer) {
		System.out.println("insert");

		customerService.insertCustomer(customer);

		return "main";
	}

//---------------------- modifyForm -------------------------------------------
	@RequestMapping(value = "/modifyForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyFrom(HttpSession session, Model model) {
		System.out.println("modifyForm");
		
		customerVO = customerService.getCustomer((CustomerVO)session.getAttribute("customerVO"));
						
		model.addAttribute("user",customerVO);

		return "modifyForm";
	}
	
//---------------------- update -------------------------------------------
	@RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
	public String update(@ModelAttribute CustomerVO customer) {
		System.out.println("update");
		
		customerService.updateCustomer(customer);
		
		return "/main";
	}
	
//---------------------- delete -------------------------------------------
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@ModelAttribute CustomerVO customer) {
		System.out.println("delete");
		
		customerService.deleteCustomer(customer);
		
		return "/main";
	}

}//Class End
