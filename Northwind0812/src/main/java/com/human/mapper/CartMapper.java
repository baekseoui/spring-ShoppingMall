package com.human.mapper;


import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.human.domain.CartVO;

public interface CartMapper {
	
	
	public ArrayList<CartVO> listCart(String userId);
	
	public void deleteCart(String userId);
	
	public void addCart(@Param("userId") String userId, @Param("productId") String productId,
			@Param("productName") String productName, @Param("amount") String amount, @Param("price") String price,
			@Param("picture") String picture);

	public void deleteCart1(int cartId);

	public void updateCart(@Param("userId") String userId, @Param("cartId") int cartId,
			@Param("quantity") int quantity);
	
	public ArrayList<CartVO> getCart(String userId);
	
	public void insertCart(CartVO cartVO);
}
