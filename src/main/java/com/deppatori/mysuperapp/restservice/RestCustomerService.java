package com.deppatori.mysuperapp.restservice;

import javax.ws.rs.Path;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppatori.mysuperapp.model.Customer;
import com.deppatori.mysuperapp.repository.CustomerRepository;
import com.deppatori.mysuperapp.service.BaseService;
import com.deppatori.mysuperapp.service.CustomerService;

@Service
@Path("/api/v2/customers")
public class RestCustomerService extends RestBaseService<Customer>{
	
	@Autowired
	private CustomerService customerService;

	@Override
	public BaseService<Customer> getService() {
		return customerService;
	}

}
