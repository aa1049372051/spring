package com.yunix.service;  

import org.springframework.stereotype.Repository;
  
@Repository("orderService")
public interface IOrderService {  
  
    public int getOrderCount();  
}  