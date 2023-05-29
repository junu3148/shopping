package com.order.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.order.dao.CustomerDAO;
import com.order.vo.CustomerVO;

@Service
public class CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	@Autowired
	private CustomerVO customerVO;

	// ------------------ login -----------------------
	public CustomerVO login(CustomerVO customer) { // 5/22구현
		System.out.println("Service login");

		CustomerVO getCustomer = customerDAO.getCustomer(customer);

		if (customer.getCustomerPassword().equals(getCustomer.getCustomerPassword())) {
			customerVO = customerDAO.login(customer);
		}
		return customerVO; // 삽입 결과 반환
	}

	// ------------------ getCustomerList -----------------------
	public List<CustomerVO> getCustomerList() { // 5/22구현

		System.out.println("Service getCustomerList");
		List<CustomerVO> customerList = customerDAO.getCustomerList();
		return customerList; // 삽입 결과 반환
	}

	// ------------------ getCustomer -----------------------
	public CustomerVO getCustomer(CustomerVO customer) { // 5/22구현
		System.out.println("Service getCustomer");
		CustomerVO customerVO = customerDAO.getCustomer(customer);
		return customerVO; // 삽입 결과 반환
	}

	// ------------------ Customer insert-----------------------
	public int insertCustomer(CustomerVO customer) { // 5/22구현
		int row = 0;
		System.out.println("Service insertCustomer");
		row = customerDAO.insertCustomer(customer);
		return row; // 삽입 결과 반환
	}

	// ------------------ Customer update-----------------------
	public int updateCustomer(CustomerVO customer) { // 5/22구현
		int row = 0;
		System.out.println("Service updateCustomer");
		row = customerDAO.updateCustomer(customer);
		return row; // 삽입 결과 반환
	}

	// ------------------ Customer delete-----------------------
	public int deleteCustomer(CustomerVO customer) { // 5/22구현
		int row = 0;
		System.out.println("Service deleteCustomer");
		row = customerDAO.deleteCustomer(customer);
		return row; // 삽입 결과 반환
	}

}
