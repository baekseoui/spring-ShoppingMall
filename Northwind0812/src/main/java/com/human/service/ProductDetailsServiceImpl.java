package com.human.service;


import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.human.domain.ProductDto;
import com.human.mapper.ProductDetailsMapper;


@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {

	@Inject
	private ProductDetailsMapper mapper;
	

	@Override
	public ProductDto getList(int productId){
		return mapper.getList(productId);
	}
	
	

}
