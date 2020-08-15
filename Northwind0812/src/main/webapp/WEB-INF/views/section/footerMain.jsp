<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<meta charset="UTF-8">

<div class="foot_inner">
	<h2 class="tit_foot">
		<span class="site_logo"> <img
			src="/resources/img/northwind8.png">
		</span>
	</h2>
	<div class="rel_foot">
		<ul class="list_rel">
			<li><a href="/member/customer_service" class="link_cont">Customer
					Service</a></li>
			<li><a href="/member/notice" class="link_cont _enterGuide">Notice</a></li>
			<sec:authorize access="isAuthenticated()">
				<li><a href="/member/customer_inquiry"
					class="link_cont _partners">1:1 Contacts</a></li>
			</sec:authorize>
			<sec:authorize access="isAnonymous()">
				<li><a href="/member/mainLoginPage"
					class="link_cont _partners">1:1 Contacts</a></li>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<li><a href="../manager2/employees" class="link_cont _partners">Admin</a>
			</sec:authorize>
			<sec:authorize access="isAnonymous()">
				<li><a href="/member/mainLoginPage" class="link_cont _partners">Admin</a>
			</sec:authorize>

		</ul>
	</div>
	<div class="policy_foot">
		<h3 class="blind">사업자 연락정보 및 약관</h3>
		<address class="contact_info">
			<span class="txt_info">© 2020 The NorthWind, Inc</span> <span
				class="txt_info">Privacy Policy</span> <span class="txt_info">Do
				Not Sell My Info</span> <span class="txt_info">Interest Based Ads</span> <span
				class="txt_info">Terms of Use</span> <span class="txt_info">Careers</span>
			<span class="txt_info">Sustainability</span> <span class="txt_info">Tel
				: 0000-0000 &nbsp;&nbsp; Fax : 00-0000-0000</span>
		</address>
		<ul class="list_terms_link">

			<li>NorthWind.com © Copyright 1997-2020 NorthWind, LLC. All
				rights reserved. NorthWind® is a registered trademark of NorthWind,
				LLC. Trusted Brands.<br> Healthy Rewards. and the NorthWind.com
				Trusted Brands. Healthy Rewards. Logo are trademarks of NorthWind,
				LLC.
			</li>
		</ul>
	</div>
</div>

