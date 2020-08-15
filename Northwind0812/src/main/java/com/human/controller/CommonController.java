package com.human.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//by 재령
//Spring Security를 사용한 로그인/로그아웃 기능

@Controller
public class CommonController {

	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	//권한 없는 사용자 'User'가 'ADMIN'페이지 접속시 출력되는 페이지
	//페이지 새로만들고 맵핑 주소 수정필요
	@GetMapping("/member/main_login_fail")
	public void accessDenied(Authentication auth) {

		logger.info("access Denied : " + auth);
		
	}
	
	//로그인 페이지 출력 - GET
	//실제 로그인은 "/login"을 통해 Security에서 실행됨 -POST
	@GetMapping("/member/mainLoginPage")
	public void loginInput(String error, String logout) {

		logger.info("error: " + error);
		logger.info("logout: " + logout);

	}
	
	//로그아웃 클릭시 출력되는 페이지 - GET
	@GetMapping("/member/customLogout")
	public void logoutGET() {

		logger.info("custom logout");
	}

	

}
