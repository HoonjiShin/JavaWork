<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="com.lec.beans.*" %>
<jsp:useBean id="dao" class="com.lec.beans.WriteDAO"/>
<%
	int cnt = (Integer)request.getAttribute("updateok");
	
	int uid = Integer.parseInt(request.getParameter("uid"));
%>
	<% if(cnt == 0){ %>
	<script>
		alert('수정 실패');
		history.back();
	</script>
<% } else { %>
	<script>
		alert('수정 성공');
		location.href = "view.do?uid=<%= uid%>";
	</script>
<% } %>