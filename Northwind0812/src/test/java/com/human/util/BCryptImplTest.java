package com.human.util;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.human.domain.MemberDto;
import com.human.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class BCryptImplTest {
	
	@Autowired
	private EncryptHelper encryptHelper;
	
	@Inject
	private MemberService service;
	
	@Test
	public void pwEncoding() {
		ArrayList<MemberDto> newPw = service.getID();
		
		for(MemberDto pw: newPw) {
			
			String password =pw.getNewPw();
			
			String encrypted = encryptHelper.encrypt(password);
			
			assertTrue(encryptHelper.isMatch(password,  encrypted));
		}
		
		
		
	}
}
