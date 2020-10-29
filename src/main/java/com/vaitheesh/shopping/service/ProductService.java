package com.vaitheesh.shopping.service;

import java.util.List;

import com.vaitheesh.shopping.exception.ProductNotFoundException;
import com.vaitheesh.shopping.model.Product;

public interface ProductService {
	
	Product findBy(Long idProduct) throws ProductNotFoundException;
	Product findBy(String description) throws ProductNotFoundException;
	List<Product> findByCategory(String category) throws ProductNotFoundException;
	List<Product> findAll() throws ProductNotFoundException;

}
