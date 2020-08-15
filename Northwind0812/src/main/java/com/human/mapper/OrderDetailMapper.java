package com.human.mapper;

import java.util.ArrayList;

import com.human.domain.OrderDetailsDto;

public interface OrderDetailMapper {
	public ArrayList<OrderDetailsDto> detailSelect(int orderId);
}
