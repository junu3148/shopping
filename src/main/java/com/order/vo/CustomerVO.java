package com.order.vo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
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

}
