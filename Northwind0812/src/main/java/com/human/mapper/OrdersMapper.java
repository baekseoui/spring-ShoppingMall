package com.human.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.human.domain.OrderDetailsDto;
import com.human.domain.OrdersDto;
import com.human.domain.ProductsDto;

public interface OrdersMapper {

	public void ordersInsert(OrdersDto dto);
	
	public ArrayList<OrdersDto> orderSelectDesc();
	
	public void orderDetailsInsert(OrderDetailsDto odd);
	
	
	public ArrayList<OrdersDto> select();
	public void insert(OrdersDto dto);
	public void update(OrdersDto dto);
//	public ArrayList joinSelectList(ArrayList<Integer> oidList);
	
	public OrdersDto getOrder
	(@Param("orderId")int orderId, @Param("userID")String userID);
	public ProductsDto getProduct(int productID);
}
