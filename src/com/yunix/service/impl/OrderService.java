package com.yunix.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunix.dao.IOrderDao;
import com.yunix.service.IOrderService;

@Service("orderServiceImpl")
public class OrderService implements IOrderService{

	@Autowired
	private IOrderDao orderDao;
	@Override
	public int getOrderCount() {
		// TODO Auto-generated method stub
		return orderDao.getOrderCount();
	}

}