package com.human.service;

import java.util.ArrayList;

import com.human.domain.OrderDetailsDto;

public interface OrderDetailService {
	public ArrayList<OrderDetailsDto> detailSelect(int orderId);
}
