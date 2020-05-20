<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.isRequestedSessionIdValid()){
		out.println("유효한 session 존재<hr>");
	}else{
		out.println("유효한 session 없음<hr>");
	}

	String sessionName = "userid";
	String sessionValue;
	
	if(session.getAttribute("userid")==null){%>
		<h2>로그인 상태가 아닙니다</h2>
		<form action="loginOk.jsp">
			id:<input type="text" name="userid"><br>
			pw:<input type="password" name="pw"><br>
			<input type="submit" value="로그인"><br>
		</form>
	<%}else{%>
	<h2>로그인 상태입니다</h2>
			<form action="logout.jsp">
				<input type="submit" value="로그아웃"><br>
			</form>
	<%}%>