package com.human.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.human.domain.BoardDto;
import com.human.domain.CartVO;
import com.human.domain.Criteria;
import com.human.domain.OrderDetailsDto;
import com.human.domain.OrdersDto;
import com.human.domain.PageMaker;
import com.human.domain.ProductsDto;
import com.human.domain.ReviewDto;
import com.human.domain.MemberDto;
import com.human.domain.CustomersDto;
import com.human.domain.FileDto;
import com.human.domain.GetOrderPriceDto;
import com.human.domain.LookupDateDto;
import com.human.service.BoardService;
import com.human.service.CartService;
import com.human.service.CustomerService;
import com.human.service.CustomersService;
import com.human.service.MemberService;
import com.human.service.OrderDetailService;
import com.human.service.OrdersService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CustomersController {

	private static final Logger logger = LoggerFactory.getLogger(CustomersController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@Inject
	private CustomersService service;

	@Inject
	private CartService service2;

	@Inject
	private OrdersService service3;

	@Inject
	private MemberService service4;

	@Inject
	private PasswordEncoder pwencoder;

	@Autowired
	private BoardService bService;

	@Inject
	private CustomerService service5;

	@Inject
	private OrderDetailService dService;

	@Autowired
	public void setPwencoder(PasswordEncoder pwencoder) {
		this.pwencoder = pwencoder;
	}

	// by 보름 결제페이지 출력
	@RequestMapping(value = "/myPage/mainOrders", method = RequestMethod.POST)
	public String mainOrders(Principal principal, Model model) {

		String customerID = principal.getName();
		model.addAttribute("info", service.customerInfo(customerID));

		model.addAttribute("cartDtos", service2.listCart(customerID));

		return "/myPage/mainOrders";
	}

	@RequestMapping(value = "/myPage/ordersBuyNowSelect", method = RequestMethod.GET)
	public String ordersBuyNowSelect(Principal principal, Model model, CartVO cartVo, HttpServletRequest request,
			ArrayList<CartVO> cartDtos) {

		String customerID = principal.getName();
		model.addAttribute("info", service.customerInfo(customerID));

		cartVo.setUserId(customerID);
		cartVo.setPicture(request.getParameter("picture"));
		cartVo.setProductName(request.getParameter("productName"));
		cartVo.setProductId(Integer.parseInt(request.getParameter("productId")));
		cartVo.setPrice(Double.parseDouble(request.getParameter("price")));
		cartVo.setQuantity(Integer.parseInt(request.getParameter("quantity")));

		service2.insertCart(cartVo);

		model.addAttribute("cartDtos", service2.listCart(customerID));

		return "/myPage/mainOrders";
	}

	@RequestMapping(value = "/myPage/ordersInsert", method = RequestMethod.GET)
	public String ordersInsert(HttpServletRequest request, OrdersDto dto, OrderDetailsDto odd,
			ArrayList<CartVO> cartDtos, Model model) {

		String customerID = request.getParameter("customerID");
		String shipAddress = request.getParameter("shipAddress");
		String shipCity = request.getParameter("shipCity");
		String shipRegion = request.getParameter("shipRegion");
		String shipPostalCode = request.getParameter("shipPostalCode");
		String shipCountry = request.getParameter("shipCountry");

		dto.setCustomerID(customerID);
		dto.setShipAddress(shipAddress);
		dto.setShipCity(shipCity);
		dto.setShipRegion(shipRegion);
		dto.setShipPostalCode(shipPostalCode);
		dto.setShipCountry(shipCountry);

		service3.ordersInsert(dto);

		cartDtos = service2.listCart(customerID);
		System.out.println(cartDtos);
		for (CartVO dtos : cartDtos) {
			odd.setOrderID(service3.orderSelectDesc().get(0).getOrderID());
			odd.setProductID(dtos.getProductId());
			odd.setUnitPrice(dtos.getPrice());
			odd.setQuantity(dtos.getQuantity());

			service3.orderDetailsInsert(odd);
			System.out.println("ORDERDETAILS INSERT 합니다");
		}

		model.addAttribute("orderID", service3.orderSelectDesc().get(0).getOrderID());

		service2.deleteCart(customerID);

		return "/myPage/mainOrdersComplete";

	}

	@RequestMapping(value = "/myPage/personalInfoSelect", method = RequestMethod.GET)
	public String personalInfoSelect(Principal principal, Model model) {

		String customerID = principal.getName();
		model.addAttribute("info", service.customerInfo(customerID));

		return "/myPage/index5";

	}

	
	@RequestMapping(value = "/myPage/personalInfoUpdate", method = RequestMethod.GET)
	public String personalInfoUpdate(HttpServletRequest request, CustomersDto dto,
			MemberDto mDto) {

		String customerID = request.getParameter("customerID");

		String uContactName = request.getParameter("contactName");
		String uContactTitle = request.getParameter("contactTitle");
		String uAddress = request.getParameter("address");
		String uCity = request.getParameter("city");
		String uRegion = request.getParameter("region");
		String uPostalCode = request.getParameter("postalCode");
		String uCountry = request.getParameter("country");
		String uPhone = request.getParameter("phone");
		String uFax = request.getParameter("fax");

		dto.setCustomerID(customerID);
		dto.setCompanyName(request.getParameter("companyName"));
		dto.setContactName(uContactName);
		dto.setContactTitle(uContactTitle);
		dto.setAddress(uAddress);
		dto.setCity(uCity);
		dto.setRegion(uRegion);
		dto.setPostalCode(uPostalCode);
		dto.setCountry(uCountry);
		dto.setPhone(uPhone);
		dto.setFax(uFax);
		
		System.out.println(customerID);
		System.out.println("updating Personal Info.......1");

		service.customerInfoUpdate(dto);

		String newPw = request.getParameter("passInfo");

		if (newPw != "" && newPw != null) {
			System.out.println("newPW : " + newPw);

			String afterPw = pwencoder.encode(newPw);
			
			mDto.setNewID(customerID);
			mDto.setNewPw(afterPw);

			service4.update(mDto);
		}
		return "redirect:/myPage/index";
	}

	@RequestMapping(value = "/myPage/DelivStat0", method = RequestMethod.GET)
	public String delivInfo() {

		return "/myPage/(N)index2";
	}

	// by 재령 myPage 메인화면 출력
	@RequestMapping(value = "/myPage/index", method = RequestMethod.GET)
	public void index(Principal principal, Model model) {
		String userID = principal.getName();
		logger.info("myPage");

		logger.info("--------index--------");

		int cancel = 0, change = 0, back = 0;
		for (LookupDateDto d : service5.list()) {
			if (d.getType().trim().equals("취소")) {
				cancel += 1;
			} else if (d.getType().trim().equals("교환")) {
				change += 1;
			} else if (d.getType().trim().equals("반품")) {
				back += 1;
			}
		}
		model.addAttribute("cancel", cancel);
		model.addAttribute("change", change);
		model.addAttribute("back", back);

		model.addAttribute("userID", userID);
	}

	// by 재령 myPage 일대일문의 내역 게시판 출력
	@RequestMapping(value = "/myPage/indexqna1by1", method = RequestMethod.GET)
	public void indexqna1by1(Principal principal, Model model, @ModelAttribute("cri") Criteria cri) {

		String userID = principal.getName();
		model.addAttribute("userID", userID);

		logger.info(cri.toString());
		// 총 게시물 수& 페이지 개수
		int page = cri.getPage();
		int perPageNum = cri.getPerPageNum();

		logger.info("page: " + page + "perPageNum: " + perPageNum);
		model.addAttribute("bProductDtos", bService.select1By1(page, perPageNum, userID));
		// 페이징처리
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(bService.listCountCriteria(cri, userID));
		logger.info(pageMaker.toString());
		model.addAttribute("pageMaker", pageMaker);

		// 답변 불러오기
		model.addAttribute("replyDtos", bService.replySelect());
	}

	// by 재령 myPage 상품문의 내역 게시판 출력
	@GetMapping("/myPage/indexSearch")
	public void indexSearch(Principal principal, Model model, @ModelAttribute("cri") Criteria cri) throws Exception {

		String userID = principal.getName();
		model.addAttribute("userID", userID);

		logger.info(cri.toString());
		// 총 게시물 수& 페이지 개수
		int page = cri.getPage();
		int perPageNum = cri.getPerPageNum();

		logger.info("page: " + page + "perPageNum: " + perPageNum);
		model.addAttribute("bProductDtos", bService.selectQna(page, perPageNum, userID));
		// 페이징처리
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(bService.listCountCriteria2(cri, userID));
		logger.info("startpage: " + pageMaker.getStartPage() + "endPage: " + pageMaker.getEndPage());
		model.addAttribute("pageMaker", pageMaker);

		// 답변 불러오기
		model.addAttribute("replyDtos", bService.replySelect());
	}

	// by 재령 myPage 상품문의 내역 게시글 수정기능(update)
	@RequestMapping(value = "/myPage/indexSearchUpdate", method = RequestMethod.POST)
	public String indexSearchUpdate(HttpServletRequest request) {

		String boardContent = request.getParameter("boardContent");
		int boardNum = Integer.parseInt((String) request.getParameter("boardNum"));
		bService.updateQnaList(boardContent, boardNum);
		request.setAttribute("bProductDtos", boardContent);

		return "redirect:/myPage/indexSearch";
	}

	// by 재령 myPage 상품문의 내역 게시글 삭제기능(delete)
	@RequestMapping(value = "/myPage/indexSearchDelete", method = RequestMethod.POST)
	public String indexSearchDelete(HttpServletRequest request) {
		int boardNum = Integer.parseInt((String) request.getParameter("boardNum"));
		bService.deleteQnaList(boardNum);

		return "redirect:/myPage/indexSearch";
	}

	// by상민 상품평 쓰기 List
	@RequestMapping(value = "/myPage/index8", method = RequestMethod.GET)
	public void reviewList(Model model, Principal principal) {
		String userID = principal.getName();
		ArrayList<ReviewDto> orDtos = service5.orderSelect(userID);
		model.addAttribute("orDtos", orDtos);

	}

	// by상민 내가쓴 상품평
	@RequestMapping(value = "/myPage/index9", method = RequestMethod.GET)
	public void myReview(Model model, Principal principal) {
		String userID = principal.getName();
		ArrayList<ReviewDto> rDtos = service5.reviewSelect(userID);
		model.addAttribute("rDtos", rDtos);
		ArrayList<ReviewDto> dto1 = service5.reviewFileSelect(userID);
		model.addAttribute("dto1", dto1);
	}

	// by상민 내가쓴 상품평 수정페이지 열기
	@RequestMapping(value = "/myPage/index9Update", method = RequestMethod.GET)
	public String myReviewUpdate(@RequestParam("boardNum") String boardNum, Model model, Principal principal) {
		String userID = principal.getName();
		ReviewDto rDto = service5.reviewContentSelect(userID, boardNum);
		model.addAttribute("rDto", rDto);
		return "/myPage/index9_1";
	}

	// by상민 내가쓴 상품평 수정페이지 에서 수정
	@RequestMapping(value = "/myPage/reviewUpdate", method = RequestMethod.POST)
	public String myReviewUpdateOk(@RequestParam("boardContent") String boardContent,
			@RequestParam("boardNum") String boardNum, Model model) {
		service5.ReviewUpdate(boardContent, boardNum);
		return "redirect:/myPage/index9";
	}

	// by상민 내가쓴 상품평 삭제
	@RequestMapping(value = "/myPage/index9Delete", method = RequestMethod.POST)
	public String myReviewDelete(@RequestParam("boardNum") int boardNum) {
		service5.ReviewDelete(boardNum);
		return "redirect:/myPage/index9";
	}

	// by상민 마이페이지 상품평작성 파일첨부
	@Transactional
	@RequestMapping(value = "/myPage/myReviewWrite", method = RequestMethod.POST)
	public String myReviewWrite(@RequestParam("boardContent") String boardContent,
			@RequestParam("orderID") String orderID, @RequestParam("productID") String productID,
			MultipartHttpServletRequest multi, Principal principal) {

		String userID = principal.getName();

		BoardDto dto = new BoardDto();
		dto.setOrderID(Integer.parseInt(orderID));
		dto.setBoardContent(boardContent);
		dto.setProductID(Integer.parseInt(productID));

		service5.ReviewInsert(userID, boardContent, orderID, productID);

		String savePath = "C:\\tempUpload\\";

		Iterator<String> iter = multi.getFileNames();
		while (iter.hasNext()) {
			// 파일 중복명 처리
			UUID uid = UUID.randomUUID();

			String uploadFileName = iter.next();
			MultipartFile mFile = multi.getFile(uploadFileName);

			// 본래 파일명
			String originalFileName = mFile.getOriginalFilename();

			long fileSize = mFile.getSize();

			System.out.println("originalFileName : " + originalFileName);
			System.out.println("fileSize : " + fileSize);
			String newname = uid + "_" + originalFileName;
			FileDto dto2 = new FileDto();
			File serverFile = new File(savePath, newname);

			dto2.setFileOrgName(originalFileName);
			dto2.setFileSize(Long.toString(fileSize));
			dto2.setFileNewName(newname);

			// 파일저장
			if (originalFileName != "") {
				try {
					mFile.transferTo(serverFile);
					System.out.println("파일저장ok? ok");

				} catch (IllegalStateException | IOException e) {

					e.printStackTrace();
				}
				// 파일 db저장

				service5.fileUpload(dto2);
			}

		}

		return "redirect:/myPage/index9";
	}
	
	//by혁준 취소 조회페이지
	@GetMapping("/myPage/indexBd")
	public void indexBd(Model model, String listIndex, Principal principal) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 E");

		String userID = principal.getName();

		logger.info("--------indexBd--------");
		LookupDateDto dto = new LookupDateDto();
		List<LookupDateDto> dtos = new ArrayList<>();

		if (listIndex != null) {
			dto.setCustomerID(userID);
			if (service5.listDate(dto, listIndex).isEmpty()) {
				model.addAttribute("messeng", "조회하신 결과는 존재하지 않습니다.");
			} else {
				dtos = service5.listDate(dto, listIndex);
				for (LookupDateDto d : dtos) {
					d.setDateFormat(dateFormat.format(d.getApplicationDate()));
				}
				model.addAttribute("dtos", dtos);
			}
		}

		model.addAttribute("userID", userID);
	}

	@RequestMapping(value = "/myPage/(N)index2", method = RequestMethod.GET)
	public void index2(Principal principal,Model model) {
		String userID=principal.getName();
		
		model.addAttribute("userID", userID);
	}
	
	//by 혁준 
	@GetMapping("/myPage/index6")
	public void index6(Principal principal, Model model) {
		String userID = principal.getName();
		int orderId = 10643;

		ArrayList<ProductsDto> productsDtos = new ArrayList<ProductsDto>();
		for (OrderDetailsDto dto : dService.detailSelect(orderId)) {
			productsDtos.add(service3.getProduct((dto.getProductID())));
			logger.info("productsDtos: "+productsDtos.get(0));
		}
		
		
		
		
		GetOrderPriceDto priceDto = new GetOrderPriceDto(dService);
		priceDto.getPriceInfo(String.valueOf(orderId));

		model.addAttribute("priceDto", priceDto);
		model.addAttribute("productsDtos", productsDtos);
		model.addAttribute("ordersDto", service3.getOrder(orderId, userID));
		model.addAttribute("customersDto", service5.getUser(userID));
		model.addAttribute("orderDetailDtos", dService.detailSelect(orderId));
	}

	@PostMapping("/myPage/DelivCancel")
	public String DelivCancel(Principal principal) {
		String userID = principal.getName();
		return "redirect:/myPage/indexBd?userID=" + userID;
	}
}
