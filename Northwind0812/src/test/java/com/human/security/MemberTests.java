package com.human.security;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.human.domain.MemberDto;

import com.human.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/security-context.xml" })
public class MemberTests {

	@Inject
	private PasswordEncoder pwencoder;
	@Inject
	private DataSource ds;
	@Inject
	private MemberService service;

	@Autowired
	public void setPwencoder(PasswordEncoder pwencoder) {
		this.pwencoder = pwencoder;
	}

	@Autowired
	public void setDs(DataSource ds) {
		this.ds = ds;
	}

	@Test
	@Ignore
	public void testInsertMember() {

		ArrayList<MemberDto> memberDtos = service.getID();

		int count = 1;
		// String sql = "insert into newcustomer(newpw) values (?)";
		

		for (MemberDto dto : memberDtos) {
			String sql = "update newcustomer set newpw= ? where newnum = " + count;
			String id = dto.getNewID();
			Connection con = null;
			PreparedStatement pstmt = null;

			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);

				pstmt.setString(1, pwencoder.encode(id));
				count++;

//				if (i < 80) {
//
//					pstmt.setString(1, "user" + i);
//					pstmt.setString(3, "일반사용자" + i);
//
//				} else if (i < 90) {
//
//					pstmt.setString(1, "manager" + i);
//					pstmt.setString(3, "운영자" + i);
//
//				} else {
//
//					pstmt.setString(1, "admin" + i);
//					pstmt.setString(3, "관리자" + i);
//
//				}

				pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (Exception e) {
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (Exception e) {
					}
				}

			}
		} // end for
	}

	@Test
	
	public void testInsertAuth() {

		String sql = "insert into tbl_member_auth (userid, auth) values (?,?)";

		for (int i = 0; i < 100; i++) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);

				if (i < 80) {

					pstmt.setString(1, "user" + i);
					pstmt.setString(2, "ROLE_USER");

				} else if (i < 90) {

					pstmt.setString(1, "manager" + i);
					pstmt.setString(2, "ROLE_MEMBER");

				} else {

					pstmt.setString(1, "admin" + i);
					pstmt.setString(2, "ROLE_ADMIN");

				}

				pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (Exception e) {
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (Exception e) {
					}
				}

			}
		} // end for
	}

}
