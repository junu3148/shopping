package com.order.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.order.vo.CustomerVO;
import com.order.vo.ProductVO;

@Repository
public class CustomerDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	// ------------------ login -----------------------
		public CustomerVO login(CustomerVO customer) { // 5/22구현
			System.out.println("DAO login");
			CustomerVO customerVO = sqlSession.selectOne("customer.selectlogin",customer);
			return customerVO; // 삽입 결과 반환
		}

	//------------------ getCustomerList -----------------------
	public List<CustomerVO> getCustomerList() { // 5/22구현

		System.out.println("DAO getCustomerList");
		List<CustomerVO> customerList = sqlSession.selectList("customer.selectCustomerList");
		return customerList; // 삽입 결과 반환
	}
	//------------------  getCustomer -----------------------
	public CustomerVO getCustomer(CustomerVO customer) { // 5/22구현
		System.out.println("DAO getCustomer");
		CustomerVO customerVO =sqlSession.selectOne("customer.selectCustomerOn",customer);
		return customerVO; // 삽입 결과 반환
	}
	//------------------ Customer insert-----------------------
	public int insertCustomer(CustomerVO customer) { // 5/22구현
		int row = 0;
		System.out.println("DAO insertCustomer");
		sqlSession.insert("customer.insertCustomer",customer);
		return row; // 삽입 결과 반환
	}
	//------------------ Customer update-----------------------
	public int updateCustomer(CustomerVO customer) { // 5/22구현
		int row = 0;
		System.out.println("DAO updateCustomer");
		sqlSession.update("customer.updateCustomer",customer);
		return row; // 삽입 결과 반환
	}
	//------------------ Customer delete-----------------------
	public int deleteCustomer(CustomerVO customer) { // 5/22구현
		int row = 0;
		System.out.println("DAO deleteCustomer");
		sqlSession.delete("customer.deleteCustomer",customer);
		return row; // 삽입 결과 반환
	}
	

	
}
