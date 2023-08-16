package com.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 
 * @author Hetasvi.Ahir
 *
 */
@Data
@AllArgsConstructor
public class TransactionDetails {
	private String orderId;
	private String currency;
	private Integer amount;
	private String key;

}

