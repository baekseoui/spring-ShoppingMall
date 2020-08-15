package com.human.service;

import java.util.ArrayList;
import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.human.domain.BoardDto;
import com.human.domain.BoardProductDto;
import com.human.domain.CartVO;
import com.human.domain.FileDto;
import com.human.domain.MemberDto;
import com.human.mapper.MemberMapper;
import com.human.domain.Select_orderDto;


@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberMapper mapper;

	@Override
	public int checkId(String newID) {

		return mapper.checkId(newID);
	}

	@Override
	public void insertNewJoin(String newID, String newPw, String newName, String newDate, String newPhone,
			String newEmail) {
		
	}

	@Override
	public String login(String id, String pwd, MemberDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDto findID(String newName, String newEmail) { // MemberMapper.xml 에 있는 id가 "findID"인 것을 실행.

		return mapper.findID(newName, newEmail);
	}

	@Override
	public MemberDto findPwd(String newID, String newName, String newEmail) {

		return mapper.findPwd(newID, newName, newEmail);
	}

	@Override
	public void update(MemberDto mDto) {
		// TODO Auto-generated method stub
		mapper.update(mDto);
	}

	@Override
	public String getDate() {
		// TODO Auto-generated method stub
		return null;
	}

	// by 재령 아이디 가져오기
	// bcrypt 패스워드 인코딩 기존파일 업데이트에 사용 (ID불러오기)
	@Override
	public ArrayList<MemberDto> getID() {
		return mapper.getID();
	}

	// 하태훈 파일업로드 1대1문의
	@Override
	public void fileUpload(FileDto dto) {

		mapper.fileUpload(dto);
	}

	// 하태훈 글쓰기 1대1문의
	@Override
	public void writeBoard(BoardDto dto) {

		mapper.writeBoard(dto);
	}
	// 하태훈 글쓰기 에서 제품선택부분

	@Override
	public ArrayList<Select_orderDto> Select_orderDto(String id, String page, String pageDataCount) {

		return mapper.Select_orderDto(id, page, pageDataCount);
	}

	@Override
	public int ordersDateCount(String id) {

		return mapper.ordersDateCount(id);
	}

	@Override
	public ArrayList<CartVO> listCart2(String id, String page, String pageDataCount) {

		return mapper.listCart2(id, page, pageDataCount);
	}

	@Override
	public int cartDateCount(String id) {

		return mapper.cartDateCount(id);
	}

	@Override
	public void writeBoard_customer_inquiry(BoardDto dto) {

		mapper.writeBoard_customer_inquiry(dto);
	}

}
