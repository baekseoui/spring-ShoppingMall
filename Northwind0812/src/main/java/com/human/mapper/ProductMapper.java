package com.human.mapper;

import java.util.ArrayList;

import com.human.domain.CartVO;
import com.human.domain.ProductDto;
import com.human.domain.ReviewDto;

public interface ProductMapper {
	
	public ArrayList<ProductDto> getList(int categoryId);
	
	public ArrayList<ProductDto> searchProduct(String search);
	
	
	
}
