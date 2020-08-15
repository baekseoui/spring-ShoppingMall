package com.human.service;

import java.util.ArrayList;

import com.human.domain.OrderDetailsDto;
import com.human.domain.OrdersDto;
import com.human.domain.ProductsDto;

public interface OrdersService {

	public void ordersInsert(OrdersDto dto);
	
	public ArrayList<OrdersDto> orderSelectDesc();
	
	public void orderDetailsInsert(OrderDetailsDto odd);
	
	public ArrayList<OrdersDto> listSize();
	public void insert(OrdersDto dto);
	public int update(OrdersDto dto);

	public OrdersDto getOrder(int orderId, String userID);
	public ProductsDto getProduct(int productID);
}
