<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cnt" class="com.lec.beans.CountBean" scope="request"/>

<h3>request2<br>cnt와 getCount 호출</h3><br>
<jsp:getProperty name="cnt" property="count"/><br>
<a href="scope2_request1.jsp">request1로...</a>
