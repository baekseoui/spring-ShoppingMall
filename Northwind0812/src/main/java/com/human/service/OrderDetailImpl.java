package com.human.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.human.domain.OrderDetailsDto;
import com.human.mapper.OrderDetailMapper;

@Service
public class OrderDetailImpl implements OrderDetailService {
	
	private OrderDetailMapper mapper;
	
	
	public OrderDetailImpl(OrderDetailMapper mapper) {
		super();
		this.mapper = mapper;
	}


	@Override
	public ArrayList<OrderDetailsDto> detailSelect(int orderId) {
		// TODO Auto-generated method stub
		System.out.println("mapper----------------"+mapper.detailSelect(orderId));
		return mapper.detailSelect(orderId);
	}

}
