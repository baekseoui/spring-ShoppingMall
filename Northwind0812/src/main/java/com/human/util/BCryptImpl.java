package com.human.util;

import org.springframework.security.crypto.bcrypt.BCrypt;

import com.human.domain.MemberDto;

//by 재령 EncryptHelper 인터페이스를 구현한 커스텀 클래스 생성
public class BCryptImpl implements EncryptHelper {

	@Override
	public String encrypt(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}

	@Override
	public boolean isMatch(String password, String hashed) {
		return BCrypt.checkpw(password, hashed);
	}

}
