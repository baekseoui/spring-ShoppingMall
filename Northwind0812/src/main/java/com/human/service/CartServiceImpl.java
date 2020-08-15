package com.human.service;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.human.domain.CartVO;
import com.human.mapper.CartMapper;

@Service
public class CartServiceImpl implements CartService{
	@Inject
	private CartMapper mapper;

	
	private CartServiceImpl() {
	}


	// 장바구니 담기
	@Override
	public void insertCart(CartVO cartVO) {
		
		mapper.insertCart(cartVO);
	}

	// 장바구니 목록
	@Override
	public ArrayList<CartVO> listCart(String userId) {
		// TODO Auto-generated method stub
		System.out.println("****"+userId+"mapper.listCart 불러옵니다.");
		return mapper.listCart(userId);
	}

	// 장바구니 삭제
	@Override
	public void deleteCart1(int cartId) {
		mapper.deleteCart1(cartId);
	}
	@Override
	public void updateCart(String userId, int cartId, int quantity) {
		mapper.updateCart(userId, cartId, quantity);

	}

	// 장바구니 체크 값만 토탈금액에 적용
	@Override
	public ArrayList<CartVO> checkTotal(String userId) {
		
		return null;
	}

	@Override
	public void deleteCart(String userId) {
		// TODO Auto-generated method stub

		mapper.deleteCart(userId);
	}
	
	// 장바구니 목록
	@Override
	public ArrayList<CartVO> getCart(String userId) {

		return mapper.getCart(userId);
	}
	
	//장바구니 등록
	@Override
	public void addCart(String userId,String productId,
			String productName,String amount, String price, String picture){
		mapper.addCart(userId, productId, productName, amount, price, picture);
	
	}

	
}
