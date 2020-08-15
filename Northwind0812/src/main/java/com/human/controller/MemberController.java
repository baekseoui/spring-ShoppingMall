package com.human.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.human.domain.BPageDto;
import com.human.domain.BoardDto;
import com.human.domain.CartVO;
import com.human.domain.Criteria;
import com.human.domain.CustomersDto;
import com.human.domain.FileDto;
import com.human.domain.MemberDto;
import com.human.domain.PageMaker;
import com.human.domain.Select_orderDto;
import com.human.domain.QnaBoardSearchDto;
import com.human.mail.MailSend;
import com.human.service.BoardService;
import com.human.service.CustomersService;
import com.human.service.MemberService;

/**
 * Handles requests for the application home page.
 * 
 * @param <Criteria>
 */
@Controller
@RequestMapping("/member/*")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService service;

	@Autowired
	private BoardService bService;
	
	@Autowired
	private CustomersService cService;

	@Inject
	private PasswordEncoder pwencoder;
	
	@Autowired
	public void setPwencoder(PasswordEncoder pwencoder) {
		this.pwencoder = pwencoder;
	}

	// by 창준 (id,pw 찾기 페이지 - get방식으로 이동)
	@RequestMapping(value = "/mainIDFindPage", method = RequestMethod.GET)
	public void mainIDFindPage() { // void로 해두고 return할 jsp페이지를 쓰지 않으면 "value값.jsp" 페이지로 이동한다.
		logger.info("mainIDFindPage.jsp");
	}

	// by 창준 아이디 찾기 기능
	@RequestMapping(value = "/mainIDFindPage", method = RequestMethod.POST)
	public String mainIDFind(@RequestParam("newName") String newName, @RequestParam("newEmail") String newEmail,
			Model model) {
		logger.info("mainIDFind() 실행");

		if (service.findID(newName, newEmail) != null) {
			logger.info("" + service.findID(newName, newEmail));

			MemberDto dto = service.findID(newName, newEmail);

			String idForSend = dto.getNewID();

			MailSend mailSend = new MailSend();
			mailSend.PWmailSend(newEmail, idForSend);

			return "/member/main_Id_Check_Succeed";

		}
		return "/member/main_Id_Check_fail";
	}

	// by 창준 아이디 찾기 페이지 
	@RequestMapping(value = "/mainPwdFindPage", method = RequestMethod.GET)
	public void mainPwdFindPage() {

	}

	// by 창준 비밀번호 찾기
	@RequestMapping(value = "/mainPwdFindPage", method = RequestMethod.POST)
	public String mainPwdFind(@RequestParam("newID") String newID, @RequestParam("newName") String newName,
			@RequestParam("newEmail") String newEmail, Model model) {
		logger.info("mainPwdFind() 실행");

		if (service.findPwd(newID, newName, newEmail) != null) {

			MemberDto dto = service.findPwd(newID, newName, newEmail);

			String pwForSend = dto.getNewPw();

			MailSend mailSend = new MailSend();
			mailSend.PWmailSend(newEmail, pwForSend);

			return "/member/main_Pwd_Check_Succeed";
		}

		return "/member/main_Pwd_Check_fail";
	}

	// by 창준 회원가입 페이지 이동
	@RequestMapping(value = "/signupPage", method = RequestMethod.GET)
	public void signupPage() {
		logger.info("signupPage");
	}

	// by 창준 회원가입 실행
	// by 재령 transation으로 customers 테이블 insert 작업 실행
	
	@Transactional
	@RequestMapping(value = "/signupNew", method = RequestMethod.POST)
	public String signup(@RequestParam("newID") String newID, @RequestParam("newPw") String newPw,
			@RequestParam("newName") String newName, @RequestParam("newDate") String newDate,
			@RequestParam("newPhone") String newPhone, @RequestParam("newEmail") String newEmail,CustomersDto dto) throws ParseException {
		
		logger.info("signup() 실행");
		
		newPw=pwencoder.encode(newPw);

		service.insertNewJoin(newID, newPw, newName, newDate, newPhone, newEmail);
		
		String customerID=newID;
		String phone=newPhone;
		
		dto.setCustomerID(customerID);
		dto.setPhone(phone);
		
		cService.customerInsert(dto);

		return "/member/main_Newjoin";

	}
	// by 재령 회원가입시 아이디 중복체크 member>signupPage 라인110 ajax
	@ResponseBody
	@RequestMapping(value = "/idCheck", method = RequestMethod.GET)
	public int idCheck(@RequestParam("newID") String newID) {
		
		return service.checkId(newID);
	}

	// by 재령 고객센터 페이지 출력
	@GetMapping("/customer_service")
	public void customerService() {
		logger.info("고객센터 페이지(footer)");
	}

	// by 재령 footer 공지사항 출력
	@GetMapping("/notice")
	public void noticeView(Model model,  @ModelAttribute("cri") Criteria cri) {
		logger.info("공지사항 페이지(footer)");
		
		logger.info(cri.toString());
		// 총 게시물 수& 페이지 개수
		int page = cri.getPage();
		int perPageNum = cri.getPerPageNum();
		//bService.notice(page, perPageNum) 내용을 "boardDtos"에 담아서 notice.jsp페이지에서 EL태그로 출력
		model.addAttribute("boardDtos", bService.notice(page, perPageNum));
		//페이징 작업
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(bService.noticeCount(cri));

		logger.info(pageMaker.toString());
		model.addAttribute("pageMaker", pageMaker);
	}

	// by 재령 고객센터 나의 문의내역 게시판 출력
	@GetMapping("/customer8_myqna")
	public void customerMyQna(Principal principal, Model model, @ModelAttribute("cri") Criteria cri) throws Exception {
		//로그인한 사용자 id 받아오기
		String customerID = principal.getName();

		
		logger.info(cri.toString());
		// 총 게시물 수& 페이지 개수
		int page = cri.getPage();
		int perPageNum = cri.getPerPageNum();

		logger.info("page: " + page + "perPageNum: " + perPageNum);
		model.addAttribute("bProductDtos", bService.select1By1(page, perPageNum, customerID));
		// 페이징처리
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(bService.listCountCriteria(cri, customerID));
		logger.info(pageMaker.toString());
		model.addAttribute("pageMaker", pageMaker);

		// 답변 불러오기
		model.addAttribute("replyDtos", bService.replySelect());

	}
	//by 재령 ~고객센터 페이지들 출력
	@GetMapping("/customer1_shipping")
	public void customer1() {
		logger.info("shipping");
	}

	@GetMapping("/customer2_order")
	public void customer2() {
		logger.info("shipping");
	}

	@GetMapping("/customer3_return")
	public void customer3() {
		logger.info("shipping");
	}

	@GetMapping("/customer4_member")
	public void customer4() {
		logger.info("shipping");
	}

	@GetMapping("/customer5_goods")
	public void customer5() {
		logger.info("shipping");
	}

	@GetMapping("/customer6_etc")
	public void customer6() {
		logger.info("shipping");
	}

	@GetMapping("/customer7_1by1")
	public void customer7() {
		logger.info("shipping");
	}

	// 하태훈. askqna 페이지 (페이지 이동)
	@RequestMapping(value = "/askqna", method = RequestMethod.GET)
	public void askqna1(@RequestParam(value = "check1", defaultValue = "0") int bno,Principal principal, Model model) {
		String customerID=principal.getName();
		model.addAttribute("login_Id", customerID);
		if (bno == 1) {
			model.addAttribute("check", 1);
		}
	}

	// 하태훈. askqna 페이지 (파일 업로드, 및 글쓰기)
	@Transactional
	@RequestMapping(value = "/askqna", method = RequestMethod.POST)
	public String askqna2(@RequestParam("qtype") String qtype, @RequestParam("productId") String productId,
			 @RequestParam("qTitle") String qTitle,@RequestParam("qContent") String qContent, 
			MultipartHttpServletRequest multi,Principal principal, Model model) {
		String customerID=principal.getName();
		// 파일 업로드 경로변경 c드라이브에 tempUpload라는 폴더 만들어줄것. 그리고 이미지 소스는 여기서 따다가 쓸것.
		
		BoardDto dto = new BoardDto();

		dto.setBoardOption(qtype);
		dto.setProductID(Integer.parseInt(productId));
		dto.setCustomerID(customerID);
		dto.setBoardTitle(qTitle);
		dto.setBoardContent(qContent);

		// 글쓰기 작업
		service.writeBoard(dto);

		String savePath = "C:\\tempUpload\\";

		// 넘어온 파일을 리스트로 저장
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

				service.fileUpload(dto2);
			}

		}

		return "redirect:/member/askqna?check1=1";

	}
	
	// 하태훈 footer 1:1 Contacts 상품선택(주문/배송)
	@RequestMapping(value = "/select_goods", method = RequestMethod.GET)
	public void select_goods(@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "pageDataCount", required = false, defaultValue = "10") String pageDataCount,
			Model model, Principal principal) {

		String id = principal.getName();
		System.out.println("id : " + id);
		System.out.println("page : " + page);
		System.out.println("pageDataCount : " + pageDataCount);

		ArrayList<Select_orderDto> dtos = service.Select_orderDto(id, page, pageDataCount);

		for (Select_orderDto dto : dtos) {
			System.out.println("dto : " + dto);
			dto.setSum(dto.getQuantity() * dto.getUnitprice());
		}

		model.addAttribute("dtos", dtos);

		int totalDataCount = service.ordersDateCount(id);
		System.out.println("totalDataCount : " + totalDataCount);
		BPageDto bPageDto = new BPageDto();

		bPageDto.makePage(Integer.parseInt(page), Integer.parseInt(pageDataCount), totalDataCount);
		System.out.println("bPageDto : " + bPageDto);
		model.addAttribute("bPageDto", bPageDto);

	}
	
	// 하태훈 footer 1:1 Contacts 상품선택(장바구니)
	@RequestMapping(value = "/select_goods2", method = RequestMethod.GET)
	public void select_goods2(@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "pageDataCount", required = false, defaultValue = "10") String pageDataCount,
			Model model, Principal principal) {

		String id = principal.getName();

		ArrayList<CartVO> cartList = service.listCart2(id, page, pageDataCount);

		model.addAttribute("cartList", cartList);

		int totalDataCount = service.cartDateCount(id);

		BPageDto bPageDto = new BPageDto();

		bPageDto.makePage(Integer.parseInt(page), Integer.parseInt(pageDataCount), totalDataCount);
		model.addAttribute("bPageDto", bPageDto);

	}

	// 하태훈. customer_inquiry 페이지 (페이지 이동)
	@RequestMapping(value = "/customer_inquiry", method = RequestMethod.GET)
	public void customer_inquiry1() {

	}

	// 하태훈. customer_inquiry 페이지 (파일 업로드 및 글쓰기)
	@Transactional
	@RequestMapping(value = "/customer_inquiry", method = RequestMethod.POST)
	public String customer_inquiry2(@RequestParam("select_option") String qtype,
			@RequestParam("select_n") String productID, @RequestParam("qna_cont") String qContent,
			MultipartHttpServletRequest multi, Principal principal) {

		// 파일 업로드 경로변경 c드라이브에 tempUpload라는 폴더 만들어줄것. 그리고 이미지 소스는 여기서 따다가 쓸것.

		String id = principal.getName();
		String qTitle = "문의드립니다.";
		BoardDto dto = new BoardDto();
		dto.setBoardOption(qtype);
		dto.setBoardTitle(qTitle);
		dto.setCustomerID(id);
		dto.setBoardContent(qContent);
		dto.setProductID(Integer.parseInt(productID));
		// 글쓰기 작업
		service.writeBoard_customer_inquiry(dto);

		String savePath = "C:\\tempUpload\\";

		// 넘어온 파일을 리스트로 저장
		Iterator<String> iter = multi.getFileNames();

		while (iter.hasNext()) {
			// 파일 중복명 처리
			UUID uid = UUID.randomUUID();

			String uploadFileName = iter.next();
			MultipartFile mFile = multi.getFile(uploadFileName);

			// 본래 파일명
			String originalFileName = mFile.getOriginalFilename();

			long fileSize = mFile.getSize();

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

				} catch (IllegalStateException | IOException e) {

					e.printStackTrace();
				}
				// 파일 db저장

				service.fileUpload(dto2);
			}

		}

		return "redirect:/member/customer8_myqna";

	}

	//by 재령 회원가입 성공 페이지
	@GetMapping("/main_Newjoin")
	public void newjoin() {}
	
}
