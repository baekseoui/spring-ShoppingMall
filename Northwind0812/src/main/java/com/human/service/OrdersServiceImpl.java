package com.human.service;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.human.domain.CartVO;
import com.human.domain.OrderDetailsDto;
import com.human.domain.OrdersDto;
import com.human.domain.ProductsDto;
import com.human.mapper.OrdersMapper;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Inject
	private OrdersMapper mapper;
	
	@Override
	public void ordersInsert(OrdersDto dto) {
		// TODO Auto-generated method stub
		System.out.println("**** order테이블에 insert 하는 중......");
		mapper.ordersInsert(dto);
	}
	
	@Override
	public ArrayList<OrdersDto> orderSelectDesc(){
		
		return mapper.orderSelectDesc();
	}
	
	@Override
	public void orderDetailsInsert(OrderDetailsDto odd) {
		
		mapper.orderDetailsInsert(odd);
	}
	
	@Override
	public ArrayList<OrdersDto> listSize() {
		// TODO Auto-generated method stub
		return mapper.select();
	}

	@Override
	public void insert(OrdersDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int update(OrdersDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

//	@Override
//	public ArrayList joinSelect(ArrayList<Integer> oidList) {
//		System.out.println("1");
//		// TODO Auto-generated method stub
//		return mapper.joinSelectList(oidList);
//	}

	
	@Override
	public OrdersDto getOrder(int orderId, String customerId){
		
		return mapper.getOrder(orderId, customerId);
	}

	@Override
	public ProductsDto getProduct(int productID) {
		// TODO Auto-generated method stub
		return mapper.getProduct(productID);
	}

}
