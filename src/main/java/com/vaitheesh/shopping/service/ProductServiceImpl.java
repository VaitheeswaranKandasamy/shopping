package com.vaitheesh.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vaitheesh.shopping.dao.ProductDao;
import com.vaitheesh.shopping.exception.ProductNotFoundException;
import com.vaitheesh.shopping.model.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao productDao;

	@Override
	public Product findBy(Long idProduct) throws ProductNotFoundException {
		Product product = productDao.findBy(idProduct);
		if (product != null)
			return product;
		else
			throw new ProductNotFoundException("Product Not FOund");
	}

	@Override
	public Product findBy(String description) throws ProductNotFoundException {
		Product product = productDao.findBy(description);
		if (product != null)
			return product;
		else
			throw new ProductNotFoundException("Product Not Found");
	}

	@Override
	public List<Product> findByCategory(String category) throws ProductNotFoundException {
		List<Product> products = productDao.findByCategory(category);
		if (products.isEmpty() || products == null)
			throw new ProductNotFoundException("Product Not Found");
		else
			return products;
	}

	@Override
	public List<Product> findAll() throws ProductNotFoundException {
		List<Product> products = productDao.findAll();
		if (products.isEmpty() || products == null)
			throw new ProductNotFoundException("Product Not Found");
		else
			return products;
	}

}
