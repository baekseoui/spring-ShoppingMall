

# Spring 쇼핑몰 팀 프로젝트

JSP를 이용해 만들었던 쇼핑몰을 Spring로 업그레이드 한 버전입니다.

이 프로젝트에 대한 설명은 JSP 설명서를 참고해주시면 됩니다.



## 설명

 - Spring Security의 bcryptPasswordEncoder 를 사용하여 기존 DB에 저장되어 있던 패스워드를 해시코드로 암호화
 - 로그인이나 파일전송과 같이 request-POST 요청 작업을 수행할 때 CSRF 토큰을 이용하여 사용자 검증
 - MyBatis를 통해 프로그램 코드와 SQL을 분리 한 뒤 xml Mapper를 통해 맵핑함
 - 고객 문의 내역 및 공지사항 게시판 조회기능, 상품문의 수정 및 삭제 기능을 추가 구현


[프로젝트 설명서(pdf)](https://drive.google.com/file/d/19x47M6ag1GHeQOb31hOsEMIRrBgzOaTp/view?usp=sharing)
