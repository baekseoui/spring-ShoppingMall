package com.human.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


import com.human.domain.MemberDto;


@RunWith(SpringRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml" })

public class MemberMapperTests {
	private static final Logger logger = LoggerFactory.getLogger(MemberMapperTests.class);

	private MemberMapper mapper;

	@Autowired
	public void setMapper(MemberMapper mapper) {
		this.mapper = mapper;
	}

	@Test
	public void testRead() {

		MemberDto vo = mapper.read("1");

		logger.info("vo: "+ vo);


	}

}
