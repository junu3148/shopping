package com.order.vo;

import org.springframework.stereotype.Component;

import lombok.Data;


@Component
public class CartListVO {
	private String customerId;
	private int sellEa;
	private String productId;
	private String productName;
	private int price;
	
	public CartListVO() {
		super();
	}


	public CartListVO(String customerId, int sellEa, String productId, String productName, int price) {
		super();
		this.customerId = customerId;
		this.sellEa = sellEa;
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}





	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public int getSellEa() {
		return sellEa;
	}


	public void setSellEa(int sellEa) {
		this.sellEa = sellEa;
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


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getTotal() {

		return sellEa * price;

	}


	@Override
	public String toString() {
		return "CartListVO [customerId=" + customerId + ", sellEa=" + sellEa + ", productId=" + productId
				+ ", productName=" + productName + ", price=" + price + "]";
	}
	
	

}
