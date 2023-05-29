package com.order.vo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import lombok.Data;


@Component
public class CartVO {
	 private String customerId;
	   private String productId;
	   private int sellEa;
	public CartVO() {
		super();
	}
	public CartVO(String customerId, String productId, int sellEa) {
		super();
		this.customerId = customerId;
		this.productId = productId;
		this.sellEa = sellEa;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getSellEa() {
		return sellEa;
	}
	public void setSellEa(int sellEa) {
		this.sellEa = sellEa;
	}
	@Override
	public String toString() {
		return "CartVO [customerId=" + customerId + ", productId=" + productId + ", sellEa=" + sellEa + "]";
	}
	   
}
