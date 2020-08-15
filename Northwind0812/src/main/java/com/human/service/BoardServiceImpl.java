package com.human.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.domain.BoardDto;
import com.human.domain.BoardProductDto;
import com.human.domain.CartVO;
import com.human.domain.Criteria;
import com.human.domain.FileDto;
import com.human.domain.QnaDto;
import com.human.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper mapper;

	// insert
	public int insert(BoardDto dto) {
		return 0;
	}

	// update
	public int update(String boardContent, int boardNum) {
		return 0;
	}

	// delete
	public int delete(String boardDel, int boardNum) {
		return 0;
	}

	// select
	public ArrayList<BoardDto> select() {
		return null;
	}

	// 세션ID를 얻어와 Board테이블에 있는 Customer 아이디와 같으면 데이터 select
	public ArrayList<BoardDto> select(String loginID) {
		return null;
	}

	// 페이징처리
	public int dataCount(String loginID) {
		return 0;
	}

	// 페이징 고객센터-일대일문의-상품선택-장바구니
	public int dataCountCart(String loginID) {
		return 0;
	}

	// 페이징처리 일대일문의
	public int dataCount1by1(String loginID) {
		return 0;
	}

	// 페이징처리 상품문의
	public int dataCountQna(String loginID) {
		return 0;
	}

	// rownum으로 select
	public ArrayList<BoardProductDto> select(String page, String pageDataCount, String customerID) {
		return null;
	}

	// 답변 불러오기
	public ArrayList<BoardDto> replySelect() {
		return mapper.replySelect();
	}

	// notice dataCount
	public int noticeCount(Criteria cri) {
		return mapper.noticeCount(cri);
	}

	// 공지사항 (notice) select
	public ArrayList<BoardDto> notice(int page, int perPageNum) {
		return mapper.notice(page, perPageNum);
	}

	// productDetails 글쓰기
	public void insertQna(String Option, String productID, String customerID, String Title, String Content,
			ArrayList<FileDto> dtos) {
	}

	// indexSearch,index1By1
	// update
	public int updateQnaList(String boardContent, int boardNum) {
		return mapper.updateQnaList(boardContent, boardNum);
	}

	// delete
	public int deleteQnaList(int boardNum) {
		return mapper.deleteQnaList(boardNum);
	}

	// 일대일문의 1By1 select
//	public ArrayList<BoardProductDto> select1By1(String page, String pageDataCount, String customerID) {
//		return mapper.select1By1(page, pageDataCount, customerID);
//	}

	// 상품문의 QnA select
	public ArrayList<BoardProductDto> selectQna(int page, int pageDataCount, String customerID) {
		return mapper.selectQna(page, pageDataCount, customerID);
	}

	// 고객센터 일대일문의
	public void insertQna2(String Option, String productID, String customerID, String Title, String Content,
			ArrayList<FileDto> dtos) {
	}

	// 고객센터 일대일문의 중 상품선택-장바구니탭
	public ArrayList<CartVO> listCart2(String userId, String page, String pageDataCount) {
		return null;
	}

	// productDetails 상품문의 게시판 select 역순
	public ArrayList<QnaDto> searchSelect(String page, String pageDataCount, String searchCol, String searchVal,
		int productID) {
		return mapper.searchSelect(page, pageDataCount, searchCol, searchVal, productID);
	}

	// productDetails 상품문의 게시글 개수
	public int qnadataCount(String searchCol, String searchVal, int productID) {
		return mapper.qnadataCount(searchCol, searchVal, productID);
	}

	// QNA답변 불러오기
	@Override
	public ArrayList<BoardDto> qnaReplySelect(){
		return null;
	}
//	@Override
//	public ArrayList<BoardProductDto> listCriteria(Criteria cri) throws Exception {
//
//		return mapper.listCriteria(cri);
//	}

	@Override
	public int listCountCriteria(Criteria cri, String userID) {
	
		return mapper.countPaging(cri, userID);
	}

	@Override
	public ArrayList<BoardProductDto> select1By1(int page, int perPageNum, String customerID) {

		return mapper.select1By1(page,perPageNum,customerID);
	}
	
	@Override
	public int listCountCriteria2(Criteria cri, String userID) {
	
		return mapper.countPaging2(cri, userID);
	}
}
