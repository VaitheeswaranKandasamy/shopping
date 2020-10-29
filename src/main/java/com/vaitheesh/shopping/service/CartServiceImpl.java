package com.vaitheesh.shopping.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vaitheesh.shopping.dao.CartDao;
import com.vaitheesh.shopping.dao.OrderDao;
import com.vaitheesh.shopping.dao.ProductDao;
import com.vaitheesh.shopping.model.Cart;
import com.vaitheesh.shopping.model.LineItem;
import com.vaitheesh.shopping.model.Order;
import com.vaitheesh.shopping.model.Order.BuilderOrder;
import com.vaitheesh.shopping.model.Product;
import com.vaitheesh.shopping.utils.OrderStatus;


@Service
@Transactional
public class CartServiceImpl implements CartService{
	
	@Autowired
	CartDao cartDao;

	@Autowired
	ProductDao productDao;
	
	@Autowired
	OrderDao orderDao;
	
	@Override
	public Long save(Cart cart) {
		return cartDao.save(cart);
	}

	@Override
	public void add(Long idCart, Long idProduct, Integer quantity) {
		Cart cart = cartDao.findBy(idCart);
		Product product = productDao.findBy(idProduct);
		cart.getLinesItems().add(new LineItem(cart, product, quantity, product.getPrice()));
		cartDao.update(cart);
	}

	@Override
	public Long ordered(Long idCart) {
		Cart cart = cartDao.findBy(idCart);
		Order order = new BuilderOrder()
				.setCustomer(cart.getCustomer())
				.setOrdered(new Date())
				.setStatus(OrderStatus.NEW.toString())
				.setTotal(cart.calculateTotal())
				.setLinesItems(cart.getLinesItems())
				.build();
		return orderDao.save(order);
	}

	 
}
