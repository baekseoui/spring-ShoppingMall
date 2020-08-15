package com.human.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.human.domain.CustomersDto;
import com.human.domain.FileDto;
import com.human.domain.LookupDateDto;
import com.human.domain.ReviewDto;

public interface CustomerService {
	public ArrayList<ReviewDto> orderSelect(String userID);

	public ArrayList<ReviewDto> reviewListSelect(int productId);

	public ArrayList<ReviewDto> reviewListFileSelect(int productId);
	
	public ArrayList<ReviewDto> reviewSelect(String userID);
	
	public ArrayList<ReviewDto> reviewFileSelect(String userID);
	
	public ReviewDto reviewContentSelect(@Param("userID") String userID, @Param("boardNum")String boardNum);
	
	public int ReviewUpdate(@Param("boardContent") String boardContent,@Param("boardNum") String boardNum);
	
	public int ReviewDelete(int boardNum);
	
	public void fileUpload(FileDto dto);
	
	public void ReviewInsert(@Param("userID") String userID, 
			@Param("boardContent") String boardContent, 
			@Param("orderID") String orderID, 
			@Param("productID") String productID);
	
	public List<LookupDateDto> list();
	public List<LookupDateDto> listDate(LookupDateDto dto,String list);
	public LookupDateDto selectOrderID(LookupDateDto orderID);
	public CustomersDto getUser(String customerId);
}
