package com.order.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class CartListVO {
	private String customerId;
	private int sellEa;
	private String productId;
	private String productName;
	private int price;

	public int getTotal() {

		return sellEa * price;

	}

}
