package com.payment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 
 * @author Hetasvi.Ahir
 *
 */
@Controller
public class HomeController
{

	/**
	 * 
	 * @return {@summary redirects to home.html page }
	 */
	@GetMapping("/")
	public String home() {

		return "home";

	}

}
