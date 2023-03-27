package com.eazybank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	//change3
	@GetMapping("/myAccount")
	public String getAccountDetails() {
		return "Here are the account details from the DB you can check it out";
	}
	//end of method
}
