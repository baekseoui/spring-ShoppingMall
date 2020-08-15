package com.human.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.human.domain.CustomersDto;
import com.human.mapper.CustomersMapper;

@Service
public class CustomersServiceImpl implements CustomersService {

	@Inject
	private CustomersMapper mapper;
	
	@Override
	public CustomersDto customerInfo(String customerID) {
		// TODO Auto-generated method stub
		
		return  mapper.customerInfo(customerID);
	}
	
	@Override
	public void customerInfoUpdate(CustomersDto dto) {
		
		mapper.customerInfoUpdate(dto);
	}

	@Override
	public void customerInsert(CustomersDto dto) {
		
		mapper.customerInsert(dto);
	}

}
