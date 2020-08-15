package com.human.domain;

import java.util.ArrayList;

import com.human.service.OrderDetailImpl;
import com.human.service.OrderDetailService;

//import com.human.dao.GetOrderDao;

public class GetOrderPriceDto {
	private ArrayList<Double> prices=new ArrayList<Double>();
	private double totalPrice;
	private ArrayList<Double> discounts=new ArrayList<Double>();
	private double discountPrice;
	private double finalPrice;
	
	private OrderDetailService dService;
	
	public GetOrderPriceDto(OrderDetailService dService) {
		super();
		this.dService = dService;
	}


	public void getPriceInfo(String orderId) {
		ArrayList<OrderDetailsDto> dtos=dService.detailSelect(Integer.parseInt(orderId));
		//가격 정보
		for (OrderDetailsDto dto : dtos) {
			double price=Math.round(dto.getUnitPrice()*dto.getQuantity());
			this.prices.add(price);			
		}
		//총 가격
		for (Double p : prices) {
			this.totalPrice += p;
		}
		//할인 가격
		for(int i=0;i<dtos.size();i++) {
			double discount=Math.round(dtos.get(i).getDiscount()*100);
			double price=prices.get(i)*(discount/100);
			this.discounts.add(price);
			this.discountPrice+=discounts.get(i);
		}
		
		//최종 가격
		this.finalPrice = this.totalPrice - this.discountPrice;
	}
	

	public ArrayList<Double> getDiscounts() {
		return discounts;
	}


	public void setDiscounts(ArrayList<Double> discounts) {
		this.discounts = discounts;
	}


	public ArrayList<Double> getPrices() {
		return prices;
	}

	public void setPrices(ArrayList<Double> prices) {
		this.prices = prices;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}

}
