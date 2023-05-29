package com.order.vo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Data;


@Component
public class CustomerVO {
	private String customerId;
	private String customerPassword;
	private String customerName;
	private String customerNumbers;
	private int codeType;

	public CustomerVO() {
		super();
	}

	public CustomerVO(String customerId, String customerPassword, String customerName, String customerNumbers,
			int codeType) {
		super();
		this.customerId = customerId;
		this.customerPassword = customerPassword;
		this.customerName = customerName;
		this.customerNumbers = customerNumbers;
		this.codeType = codeType;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerNumbers() {
		return customerNumbers;
	}

	public void setCustomerNumbers(String customerNumbers) {
		this.customerNumbers = customerNumbers;
	}

	public int getCodeType() {
		return codeType;
	}

	public void setCodeType(int codeType) {
		this.codeType = codeType;
	}

	@Override
	public String toString() {
		return "CustomerVO [customerId=" + customerId + ", customerPassword=" + customerPassword + ", customerName="
				+ customerName + ", customerNumbers=" + customerNumbers + ", codeType=" + codeType + "]";
	}
	

}
