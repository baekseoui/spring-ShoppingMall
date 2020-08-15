package com.human.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.human.domain.BoardDto;
import com.human.domain.CartVO;
import com.human.domain.Criteria;
import com.human.domain.FileDto;
import com.human.domain.MemberDto;
import com.human.domain.Select_orderDto;

public interface MemberService {

	public int checkId(String newID);

	// 회원가입
	public void insertNewJoin(String newID, String newPw, String newName, String newDate, String newPhone,
			String newEmail);

	public String login(String id, String pwd, MemberDto dto);

	// 아이디 찾기 0714 민창준
	public MemberDto findID(String newName, String newEmail);

	// 비번 찾기 0714 민창준
	public MemberDto findPwd(String newID, String newName, String newEmail);

	// personalInfo 에서 필요한 update 쿼리 새로 만듦.
	public void update(MemberDto mDto);

	public String getDate();

	// by 재령 아이디 가져오기
	// bcrypt 패스워드 인코딩 기존파일 업데이트에 사용 (ID불러오기)
	public ArrayList<MemberDto> getID();

	// by 하태훈 askqna 부분 -파일 db저장
	public void fileUpload(FileDto dto2);

	// by 하태훈 askqna 부분 -글쓰기 db저장
	public void writeBoard(BoardDto dto);

	// by 하태훈 select_goods 부분 -데이터불러오기
	public ArrayList<Select_orderDto> Select_orderDto(String id, String page, String pageDataCount);

	// by 하태훈 select_goods 부분 -orders 테이블 총갯수불러오기
	public int ordersDateCount(String id);

	// by 하태훈 select_goods2 부분 -장바구니 부분 불러오기
	public ArrayList<CartVO> listCart2(String id, String page, String pageDataCount);

	// by 하태훈 select_goods2 부분 -장바구니 총갯수 불러오기
	public int cartDateCount(String id);

	// by 하태훈 customer_inquiry 부분 -글쓰기 db저장 - 파일업로드는 위에 파일업로드 같이씀.
	public void writeBoard_customer_inquiry(BoardDto dto);

}
