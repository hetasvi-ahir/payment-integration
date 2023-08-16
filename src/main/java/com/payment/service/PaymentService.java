package com.payment.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.payment.dto.TransactionDetails;
import com.razorpay.Order;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
/**
 * 
 * @author Hetasvi.Ahir
 *
 */
@Service
public class PaymentService {
	@Value("${razorpay.key}")
	private String key;

	@Value("${razorpay.secret}")
	private String secret;

	@Value("${razorpay.currency}")
	private String currency;

	/**
	 * 
	 * @param amount
	 * @return Transaction Details {@summary Create Order in Razorpay }
	 */
	public TransactionDetails createTransaction(Double amount) {

		try {

			JSONObject jsonObject = new JSONObject();
			// *100 because RazorPay considers amount as smallest unit of Money in INR its
			// paisa
			jsonObject.put("amount", (amount * 100));
			jsonObject.put("currency", currency);
			RazorpayClient razorpayClient = new RazorpayClient(key, secret);

			Order order = razorpayClient.orders.create(jsonObject);
			return prepareTransactionDetails(order);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private TransactionDetails prepareTransactionDetails(Order order) {
		String orderId = order.get("id");
		String money = order.get("currency");
		Integer amount = order.get("amount");

		return new TransactionDetails(orderId, money, amount, key);
	}
	/**
	 * 
	 * @return {@summary Returns details of all the transaction}
	 * @throws RazorpayException
	 */

	public List<String> fetchDetails() throws RazorpayException {

		RazorpayClient razorpayClient = new RazorpayClient(key, secret);
		List<Payment> fetchAll = razorpayClient.payments.fetchAll();
		List<String> result = new ArrayList<>();
		for (Payment payment : fetchAll) 
		{
			System.out.println(payment);
			result.add(payment.toJson().toString());

		}
		return result;
	}

}
