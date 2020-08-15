package com.human.mapper;

import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.human.domain.BoardDto;
import com.human.domain.BoardProductDto;
import com.human.domain.CartVO;
import com.human.domain.FileDto;
import com.human.domain.MemberDto;
import com.human.domain.Select_orderDto;

public interface MemberMapper {

	public MemberDto read(String userid);

	public ArrayList<MemberDto> getID();

	public MemberDto findID(@Param("newName") String newName, @Param("newEmail") String newEmail);

	public MemberDto findPwd(@Param("newID") String newID, @Param("newName") String newName,
			@Param("newEmail") String newEmail);

	public void insertNewJoin(@Param("newID") String newID, @Param("newPw") String newPw,
			@Param("newName") String newName, @Param("newDate") String newDate, @Param("newPhone") String newPhone,
			@Param("newEmail") String newEmail);

	public int checkId(@Param("newID") String newID);

	public void update(MemberDto mDto);
	
	public void fileUpload(FileDto dto);

	public void writeBoard(BoardDto dto);
	
	public ArrayList<Select_orderDto> Select_orderDto(@Param("id") String id, @Param("page") String page, @Param("pageDataCount") String pageDataCount);

	public int ordersDateCount(String id);

	public ArrayList<CartVO> listCart2(@Param("id") String id, @Param("page") String page, @Param("pageDataCount") String pageDataCount);

	public int cartDateCount(String id);

	public void writeBoard_customer_inquiry(BoardDto dto);

	public int boardDateCount(String id);

	public ArrayList<BoardProductDto> select1By1(@Param("id") String id, @Param("page") String page, @Param("pageDataCount") String pageDataCount);

	public ArrayList<BoardDto> replySelect();

}
