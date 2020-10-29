package com.vaitheesh.shopping.dao;

import com.vaitheesh.shopping.model.Cart;

public interface CartDao {

	Cart findBy(Long idCart);
	Long save(Cart cart);
	void update(Cart cart);
}
