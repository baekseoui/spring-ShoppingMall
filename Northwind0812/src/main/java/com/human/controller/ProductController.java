package com.human.controller;

import java.security.Principal;
import java.util.ArrayList;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.human.domain.CartVO;
import com.human.domain.MemberDto;
import com.human.domain.ProductDto;
import com.human.domain.QnaBoardSearchDto;
import com.human.domain.ReviewDto;
import com.human.security.CustomUserDetailsService;
import com.human.service.BoardService;
import com.human.service.CartService;
import com.human.service.CustomerService;
import com.human.service.ProductDetailsService;
import com.human.service.ProductService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/product/*")
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(CustomersController.class);

	@Inject
	private ProductService service;

	@Inject
	private CustomerService customerService;

	@Inject
	private ProductDetailsService detailsService;

	@Inject
	private CartService cartService;
	
	@Inject
	private BoardService bService;


	// <input type="hidden" name="${_csrf.parameterName}" value = "${_csrf.token}"/>

	// by상민 카테고리별 제품list
	@GetMapping("/productIndex/productList")
	public void productList(@RequestParam("categoryId") int categoryId, Model model, Principal principal) {
		model.addAttribute("dtos", service.get(categoryId));
		model.addAttribute("categoryId", categoryId);

	}

	// by상민 제품 검색
	@GetMapping("/productIndex/searchProduct")
	public void searchProduct(@RequestParam("search") String search, Model model) {
		if (search == "") {

		} else {
			model.addAttribute("search", service.search(search));
		}

	}

	// by상민 제품 상세페이지 상품리뷰----------------------------------------------------
	@GetMapping("/productDetails/productDetails")
	public void productReview(@RequestParam("productId") int productId,
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "pageDataCount", required = false, defaultValue = "15") String pageDataCount,
			@RequestParam(value = "searchCol", required = false, defaultValue = "boardTitle") String searchCol,
			@RequestParam(value = "searchVal", required = false, defaultValue = "") String searchVal,
			Model model) {
		ArrayList<ReviewDto> rDtos = customerService.reviewListSelect(productId);
		ArrayList<ReviewDto> dto1 = customerService.reviewListFileSelect(productId);
		model.addAttribute("reviewDtos", rDtos);
		model.addAttribute("dto1", dto1);

		// by 서의
		ProductDto productDto = detailsService.getList(productId);
		model.addAttribute("productDto", productDto);
		model.addAttribute("productId", productId);

		// by 재령 _상품문의 내역 출력
		logger.info("page="+page+" pageDC="+pageDataCount);
		model.addAttribute("qnaDtos", bService.searchSelect(page, pageDataCount, searchCol, searchVal, productId));

		int totalDataCount = bService.qnadataCount(searchCol, searchVal, productId);

		QnaBoardSearchDto bSearchDto = new QnaBoardSearchDto();
		bSearchDto.makePage(Integer.parseInt(page), Integer.parseInt(pageDataCount), totalDataCount, searchCol,
				searchVal, productId);

		model.addAttribute("bSearchDto", bSearchDto);
		logger.info("bSearchDto: "+bSearchDto);
		model.addAttribute("replyDtos", bService.replySelect());
	}

	// by하은 장바구니 list--------------------------------------------------------
	@GetMapping("/cart/cart")
	public void cart(Principal principal, Model model) {
		String userId = principal.getName();
		ArrayList<CartVO> cartList = cartService.getCart(userId);

		double totalPrice = 0;
		for (CartVO cartVO : cartList) {
			totalPrice += Integer.parseInt(String.valueOf(Math.round(cartVO.getPrice() * 100))) * cartVO.getQuantity();
		}

		totalPrice = Double.parseDouble(String.valueOf(totalPrice)) / 100;
		System.out.println(totalPrice);
		model.addAttribute("cartList", cartList);
		model.addAttribute("totalPrice", totalPrice);
	}

	@PostMapping("/cart/cartInsert")
	public String cartInsert(Principal principal, @RequestParam("productId") String productId,
			@RequestParam("productName") String productName, @RequestParam("amount") String amount,
			@RequestParam("price") String price, @RequestParam("picture") String picture, Model model) {

		String userId = principal.getName();
		cartService.addCart(userId, productId, productName, amount, price, picture);
		model.addAttribute("userId", userId);

		return "redirect:/product/cart/cart";
	}

	// by하은 장바구니 delete
	@PostMapping("/cart/cartDelete")
	public String cartDelete(@RequestParam("cartId") int cartId) {
		logger.info("123");
		cartService.deleteCart1(cartId);
		logger.info("456");
		return "redirect:/product/cart/cart";

	}

	@PostMapping("/cart/cartUpdate")
	public String cartUpdate(Principal principal, @RequestParam("cartId") int cartId,
			@RequestParam("quantity") int quantity) {
		String userId = principal.getName();
		cartService.updateCart(userId, cartId, quantity);
		return "redirect:/product/cart/cart";

	}

}
