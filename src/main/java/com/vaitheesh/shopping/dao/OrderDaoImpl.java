package com.vaitheesh.shopping.dao;

import org.springframework.stereotype.Repository;

import com.vaitheesh.shopping.model.Order;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Long save(Order order) {
		return (Long) sessionFactory.getCurrentSession().save(order);	
	}

}
