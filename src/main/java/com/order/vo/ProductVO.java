package com.order.vo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Component
public class ProductVO {
	private String productId;
	private String productName;
	private int productEA;
	private int price;
	public ProductVO() {
		// TODO 자동 생성된 생성자 스텁
	}
	public ProductVO(String productId, String productName, int productEA, int price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productEA = productEA;
		this.price = price;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductEA() {
		return productEA;
	}
	public void setProductEA(int productEA) {
		this.productEA = productEA;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ProductVO [productId=" + productId + ", productName=" + productName + ", productEA=" + productEA
				+ ", price=" + price + "]";
	}
	
	
}