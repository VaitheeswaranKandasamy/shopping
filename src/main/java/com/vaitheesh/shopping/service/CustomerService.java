package com.vaitheesh.shopping.service;
import java.security.NoSuchAlgorithmException;

import com.vaitheesh.shopping.exception.AuthenticationFailedException;
import com.vaitheesh.shopping.model.Customer;

public interface CustomerService {
	

	Customer authentication(String username, String password) 
			throws NoSuchAlgorithmException, AuthenticationFailedException;
	Long addCustomer(Customer customer) throws NoSuchAlgorithmException;

}
