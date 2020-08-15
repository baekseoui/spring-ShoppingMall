package com.human.service;

import java.util.ArrayList;



import com.human.domain.ProductDto;
import com.human.domain.ReviewDto;


public interface ProductService {
	
	public ArrayList<ProductDto> get(int categoryId);
	
	public ArrayList<ProductDto> search(String search);
	
	
	
}
