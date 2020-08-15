package com.human.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.human.domain.CustomersDto;
import com.human.domain.FileDto;
import com.human.domain.LookupDateDto;
import com.human.domain.ReviewDto;
import com.human.mapper.CustomerMapper;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Inject
	private CustomerMapper mapper;
	@Override
	public ArrayList<ReviewDto> orderSelect(String userID) {
		
		return mapper.orderSelect(userID);
	}
	
	@Override
	public ArrayList<ReviewDto> reviewListSelect(int productId) {
		
		return mapper.reviewListSelect(productId);
	}



	@Override
	public ArrayList<ReviewDto> reviewListFileSelect(int productId) {
		// TODO Auto-generated method stub
		return mapper.reviewListFileSelect(productId);
	}

	@Override
	public ArrayList<ReviewDto> reviewSelect(String userID) {
		
		return mapper.reviewSelect(userID);
	}
	
	@Override
	public ArrayList<ReviewDto> reviewFileSelect(String userID){
		return mapper.reviewFileSelect(userID);
	}

	@Override
	public ReviewDto reviewContentSelect(String userID, String boardNum) {
		
		return mapper.reviewContentSelect(userID, boardNum);
	}

	@Override
	public int ReviewDelete(int boardNum) {
		mapper.ReviewDelete(boardNum);
		return 0;
	}

	@Override
	public int ReviewUpdate(String boardContent, String boardNum) {
		mapper.ReviewUpdate(boardContent, boardNum);
	
		return 0;
	}

	@Override
	public void ReviewInsert(String userID, String boardContent, String orderID, String productID) {
		mapper.ReviewInsert(userID, boardContent, orderID, productID);
		
	}

	@Override
	public void fileUpload(FileDto dto) {
		mapper.fileUpload(dto);
		
	}
	
	@Override
	public List<LookupDateDto> list() {
		// TODO Auto-generated method stub
		System.out.println("-----list------");
		
		return mapper.select("ALFKI");
	}


	@Override
	public List<LookupDateDto> listDate(LookupDateDto dto, String listIndex) {
		// TODO Auto-generated method stub
		
		return mapper.selectDate(dto,listIndex);
	}

	@Override
	public LookupDateDto selectOrderID(LookupDateDto dto) {
		// TODO Auto-generated method stub
		
		return mapper.selectDateOrderID(dto);
	}

	@Override
	public CustomersDto getUser(String customerId) {
		// TODO Auto-generated method stub
		return mapper.getUser(customerId);
	}

}
