package com.order.vo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Component
public class ProductVO {
	private String productId;
	private String productName;
	private int productEA;
	private int price;
	public ProductVO() {
		// TODO 자동 생성된 생성자 스텁
	}
}