package com.human.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.human.domain.BoardDto;
import com.human.domain.BoardProductDto;
import com.human.domain.CartVO;
import com.human.domain.Criteria;
import com.human.domain.FileDto;
import com.human.domain.QnaDto;

public interface BoardService {

	// insert
	public int insert(BoardDto dto);

	// update
	public int update(String boardContent, int boardNum) ;

	// delete
	public int delete(String boardDel, int boardNum) ;

	// select
	public ArrayList<BoardDto> select() ;

	// 세션ID를 얻어와 Board테이블에 있는 Customer 아이디와 같으면 데이터 select
	public ArrayList<BoardDto> select(String loginID) ;

	// 페이징처리
	public int dataCount(String loginID) ;

	// 페이징 고객센터-일대일문의-상품선택-장바구니
	public int dataCountCart(String loginID) ;

	// 페이징처리 일대일문의
	public int dataCount1by1(String loginID) ;
	
	// 페이징처리 상품문의
	public int dataCountQna(String loginID) ;

	// rownum으로 select
	public ArrayList<BoardProductDto> select(String page, String pageDataCount, String customerID) ;

	// 답변 불러오기
	public ArrayList<BoardDto> replySelect() ;

	// notice dataCount
	public int noticeCount(Criteria cri) ;

	// 공지사항 (notice) select
	public ArrayList<BoardDto> notice(int page, int pageDataCount);

	// productDetails 글쓰기
	public void insertQna(String Option, String productID, String customerID, String Title, String Content,
			ArrayList<FileDto> dtos) ;
	// indexSearch,index1By1
	// update
	public int updateQnaList(String boardContent, int boardNum) ;

	// delete
	public int deleteQnaList(int boardNum) ;

//	// 일대일문의 1By1 select
//	public ArrayList<BoardProductDto> select1By1(String page, String pageDataCount, String customerID) ;

	// 상품문의 QnA select
	public ArrayList<BoardProductDto> selectQna(int page, int pageDataCount, String customerID) ;
	
	// 고객센터 일대일문의
	public void insertQna2(String Option, String productID, String customerID, String Title, String Content,
			ArrayList<FileDto> dtos) ;
	
	// 고객센터 일대일문의 중 상품선택-장바구니탭
	public ArrayList<CartVO> listCart2(String userId, String page, String pageDataCount) ;
	
	// productDetails 상품문의 게시판 select 역순
	public ArrayList<QnaDto> searchSelect(String page, String pageDataCount, String searchCol, String searchVal,
			int productID) ;
	
	//productDetails 상품문의 게시글 개수
	public int qnadataCount(String searchCol, String searchVal, int productID);

	// QNA답변 불러오기
	public ArrayList<BoardDto> qnaReplySelect();
	
	// QnA 페이징처리된 리스트
	public ArrayList<BoardProductDto> select1By1(int page, int perPageNum, String customerID) ;
	
	// QnA 보여줄 게시물 수량체크
	public int listCountCriteria(Criteria cri, String userID);

	// myPage QnA 보여줄 게시물 수량체크
	public int listCountCriteria2(Criteria cri, String userID);
	
}
