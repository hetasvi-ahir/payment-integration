package com.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.dto.TransactionDetails;
import com.payment.service.PaymentService;
import com.razorpay.RazorpayException;

/**
 * 
 * @author Hetasvi.Ahir
 *
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	public PaymentService service;


	/**
	 * 
	 * @param amount
	 * @return {@summary returns orderId using the amount .}
	 */
	@GetMapping("/createTransaction/{amount}")
	public TransactionDetails createTransaction(@PathVariable("") Double amount) {
		return service.createTransaction(amount);
	}

	/**
	 * 
	 * @return {@summary returns all transaction details . }
	 * @throws RazorpayException
	 */
	@GetMapping("/all")
	public List<String> fetchPayments() throws RazorpayException {
		return service.fetchDetails();
	}

}
