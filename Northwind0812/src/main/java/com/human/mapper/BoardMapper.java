package com.human.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.human.domain.BoardDto;
import com.human.domain.BoardProductDto;
import com.human.domain.CartVO;
import com.human.domain.Criteria;
import com.human.domain.FileDto;
import com.human.domain.QnaDto;

public interface BoardMapper {

	// insert
	public int insert(BoardDto dto);

	// update
	public int update(String boardContent, int boardNum);

	// delete
	public int delete(String boardDel, int boardNum);

	// select
	public ArrayList<BoardDto> select();

	// 세션ID를 얻어와 Board테이블에 있는 Customer 아이디와 같으면 데이터 select
	public ArrayList<BoardDto> select(String loginID);

	// 페이징처리
	public int dataCount(String loginID);

	// 페이징 고객센터-일대일문의-상품선택-장바구니
	public int dataCountCart(String loginID);

	// 페이징처리 일대일문의
	public int dataCount1by1(String loginID);

	// 페이징처리 상품문의
	public int dataCountQna(String loginID);

	// rownum으로 select
	public ArrayList<BoardProductDto> select(String page, String pageDataCount, String customerID);

	// 답변 불러오기
	public ArrayList<BoardDto> replySelect();

	// notice dataCount
	public int noticeCount(Criteria cri);

	// 공지사항 (notice) select
	public ArrayList<BoardDto> notice(@Param("page") int page, @Param("perPageNum") int perPageNum);

	// productDetails 글쓰기
	public void insertQna(String Option, String productID, String customerID, String Title, String Content,
			ArrayList<FileDto> dtos);

	// indexSearch,index1By1
	// update
	public int updateQnaList(@Param("boardContent") String boardContent, @Param("boardNum") int boardNum);

	// delete
	public int deleteQnaList(int boardNum);

//	// 일대일문의 1By1 select
//	public ArrayList<BoardProductDto> select1By1( String page,
//			String pageDataCount, String customerID);

	// 상품문의 QnA select
	public ArrayList<BoardProductDto> selectQna(@Param("page") int page, @Param("perPageNum") int pageDataCount,
			@Param("customerID") String customerID);

	// 고객센터 일대일문의
	public void insertQna2(String Option, String productID, String customerID, String Title, String Content,
			ArrayList<FileDto> dtos);

	// 고객센터 일대일문의 중 상품선택-장바구니탭
	public ArrayList<CartVO> listCart2(String userId, String page, String pageDataCount);

	// productDetails 상품문의 게시판 select 역순
	public ArrayList<QnaDto> searchSelect(@Param("page") String page, @Param("pageDataCount") String pageDataCount,
			@Param("searchCol") String searchCol, @Param("searchVal") String searchVal, @Param("productId") int productID);

	// productDetails 상품문의 게시글 개수
	public int qnadataCount(@Param("searchCol") String searchCol, @Param("searchVal") String searchVal, @Param("productId") int productID);

	// QNA답변 불러오기
	public ArrayList<BoardDto> qnaReplySelect();

	// QnA 페이징처리
	public ArrayList<BoardProductDto> listCriteria(Criteria cri) throws Exception;

	// @Param("page") int page, @Param("perPageNum") int perPageNum,
	// @Param("customerID") String customerID
	// public ArrayList<BoardProductDto> select1By1(int page, int perPageNum, String
	// customerID) throws Exception;
	public ArrayList<BoardProductDto> select1By1(@Param("page") int page, @Param("perPageNum") int perPageNum,
			@Param("customerID") String customerID) ;

	public int countPaging(Criteria cri, @Param("userID") String userID);
	
	public int countPaging2(Criteria cri, @Param("userID") String userID);
}
