package com.vaitheesh.shopping.dao;

import com.vaitheesh.shopping.model.Customer;

public interface CustomerDao {
	
	Customer findBy(String username);
	Long save(Customer customer);

}
