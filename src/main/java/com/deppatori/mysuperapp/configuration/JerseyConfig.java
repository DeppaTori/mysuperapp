package com.deppatori.mysuperapp.configuration;

import com.deppatori.mysuperapp.restservice.RestUserService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.deppatori.mysuperapp.restservice.RestCustomerService;
import com.deppatori.mysuperapp.restservice.RestProdukService;
import com.deppatori.mysuperapp.restservice.RestPurchaseService;


@Configuration
public class JerseyConfig extends ResourceConfig{
	public JerseyConfig() {
		register(RestPurchaseService.class);
		register(RestProdukService.class);
		register(RestCustomerService.class);
		register(RestUserService.class);
	}
}
