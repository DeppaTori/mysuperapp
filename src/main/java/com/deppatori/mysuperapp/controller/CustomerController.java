package com.deppatori.mysuperapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deppatori.mysuperapp.model.Customer;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController extends BaseController<Customer>{

}
