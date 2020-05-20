<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%
	String cookieName1="num1";
	String cookieValue1 = ""+(int)(Math.random() * 10);
	Cookie cookie1 = new Cookie(cookieName1, cookieValue1); 
	cookie1.setMaxAge(2*30); 
	response.addCookie(cookie1);
	
	String cookieName2 = "datetime";
	String cookieValue2 = new SimpleDateFormat("yyyymmddHHmmss").format(new Date());
	Cookie cookie2 = new Cookie(cookieName2, cookieValue2);
	cookie2.setMaxAge(30);
	response.addCookie(cookie2);
%>
<script>
alert("<%= cookieName1%>,<%= cookieName2%> 쿠키생성");
location.href = "cookieList.jsp";
</script>