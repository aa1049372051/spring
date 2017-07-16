package com.yunix.dao;

import org.springframework.stereotype.Repository;
@Repository("orderDao")
public interface IOrderDao {

	public int getOrderCount();
}