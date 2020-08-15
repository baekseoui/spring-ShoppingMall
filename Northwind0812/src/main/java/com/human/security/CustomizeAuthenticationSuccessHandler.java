package com.human.security;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	private String loginIdName;
	private String defaultUrl;

	private RequestCache reqCache = new HttpSessionRequestCache();
	private RedirectStrategy redirectStratgy = new DefaultRedirectStrategy();

	@Override
    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res,
Authentication auth)
            throws IOException, ServletException {
		String user_id=req.getParameter("username");
//      로그인 세션 지우기
        clrearAuthenticationAttributes(req);
//      이동 할 URL 지정
        resultRedirectStrategy(req, res, auth);
    }

	protected void resultRedirectStrategy(HttpServletRequest req, HttpServletResponse res,
			Authentication authentication) throws IOException, ServletException {
		SavedRequest savedRequest = reqCache.getRequest(req, res);

		if (savedRequest != null) {
			String targetUrl = savedRequest.getRedirectUrl();
			redirectStratgy.sendRedirect(req, res, targetUrl);
		} else {
			redirectStratgy.sendRedirect(req, res, defaultUrl);
		}

	}

	protected void clrearAuthenticationAttributes(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if (session == null)
			return;
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}

	public String getLoginIdName() {
		return loginIdName;
	}

	public void setLoginIdName(String loginIdName) {
		this.loginIdName = loginIdName;
	}

	public String getDefaultUrl() {
		return defaultUrl;
	}

	public void setDefaultUrl(String defaultUrl) {
		this.defaultUrl = defaultUrl;
	}

}