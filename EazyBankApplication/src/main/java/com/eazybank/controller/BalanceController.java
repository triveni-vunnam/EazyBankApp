package com.eazybank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
//this is balance controller
    @GetMapping("/myBalance")
    public String getBalanceDetails() {
        return "Here are the balance details from the DB you can check it out";
    }


}
