package com.deppatori.mysuperapp.restservice;

import javax.ws.rs.Path;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppatori.mysuperapp.model.Produk;
import com.deppatori.mysuperapp.service.BaseService;
import com.deppatori.mysuperapp.service.ProdukService;

@Service
@Path("/api/v2/produks")
public class RestProdukService extends RestBaseService<Produk>{

	@Autowired
	ProdukService produkService;
	
	@Override
	public BaseService<Produk> getService() {
		// TODO Auto-generated method stub
		return produkService;
	}

}
