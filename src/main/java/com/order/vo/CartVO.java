package com.order.vo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Component
public class CartVO {
	 private String customerId;
	   private String productId;
	   private int sellEa;
}
