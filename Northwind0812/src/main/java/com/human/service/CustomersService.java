package com.human.service;

import com.human.domain.CustomersDto;

public interface CustomersService {

	public CustomersDto customerInfo(String customerID);
	
	public void customerInfoUpdate(CustomersDto dto);

	public void customerInsert(CustomersDto dto);
}
