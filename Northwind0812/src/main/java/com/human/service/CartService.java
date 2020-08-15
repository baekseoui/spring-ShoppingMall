package com.human.service;

import java.util.ArrayList;

import com.human.domain.CartVO;

public interface CartService {

	// 장바구니 담기
	public void insertCart(CartVO cartVO);

	// 장바구니 목록
	public ArrayList<CartVO> listCart(String userId);

	// 장바구니 삭제
	public void deleteCart1(int cartId);

	public void updateCart(String userId, int cartId, int quantity);

	// 장바구니 체크 값만 토탈금액에 적용
	public ArrayList<CartVO> checkTotal(String userId);

	// 결제 완료시 해당 ID의 장바구니 삭제
	public void deleteCart(String userId);

	// 장바구니 목록
	public ArrayList<CartVO> getCart(String userId);

	// 장바구니 등록
	public void addCart(String userId, String productId, String productName, String amount, String price,
			String picture);
}
