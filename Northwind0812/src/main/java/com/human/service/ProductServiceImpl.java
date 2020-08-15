package com.human.service;

import java.util.ArrayList;

import javax.inject.Inject;


import org.springframework.stereotype.Service;

import com.human.domain.ProductDto;
import com.human.domain.ReviewDto;
import com.human.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Inject
	private ProductMapper mapper;
	

	@Override
	public ArrayList<ProductDto> get(int categoryId) {
		
		return mapper.getList(categoryId);
	}

	@Override
	public ArrayList<ProductDto> search(String search) {
		
		return mapper.searchProduct(search);
	}

	

}
