package com.human.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.human.domain.MemberDto;
import com.human.mapper.MemberMapper;
import com.human.security.domain.CustomUser;

import com.human.controller.CustomersController;




public class CustomUserDetailsService implements UserDetailsService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomersController.class);

	private MemberMapper memberMapper;

	@Autowired
	public void setMemberMapper(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}


	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		logger.warn("Load User By UserName : " + userName);

		// userName means userid
		MemberDto vo = memberMapper.read(userName);

		logger.warn("queried by member mapper: " + vo);

		return vo == null ? null : new CustomUser(vo);
	} 
	
	

}
