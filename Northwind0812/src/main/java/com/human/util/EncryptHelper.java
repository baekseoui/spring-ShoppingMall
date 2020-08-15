package com.human.util;

import com.human.domain.MemberDto;

//by 재령 암호화와 해시된 비밀번호를 검증하는 인터페이스
public interface EncryptHelper {
	String encrypt(String password);
	
	boolean isMatch(String password, String hashed);

}
