package com.human.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.human.domain.MemberDto;



public class CustomUser extends User {

	
	private static final long serialVersionUID = 1L;

	private MemberDto member;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public MemberDto getMember() {
		return member;
	}

	public CustomUser(String newName, String newPw, 
			Collection<? extends GrantedAuthority> newRank) {
		super(newName, newPw, newRank);
	}

	public CustomUser(MemberDto vo) {

		super(vo.getNewID(), vo.getNewPw(), vo.getAuthList().stream()
				.map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));

		this.member = vo;
	}
}
