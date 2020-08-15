package com.human.mapper;


import com.human.domain.CustomersDto;

public interface CustomersMapper {
	
	public CustomersDto customerInfo(String customerID);
	
	public void customerInfoUpdate(CustomersDto dto);

	public void customerInsert(CustomersDto dto);
}
