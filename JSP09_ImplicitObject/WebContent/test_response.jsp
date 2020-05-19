<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
<%! int age; %>
<%
 	String str = request.getParameter("age");
 	age = Integer.parseInt(str);
 	out.println(age);
 	
 	if(age >= 19){
 		response.sendRedirect("adult.jsp?age=" + age);
 	}else{
 		response.sendRedirect("underage.jsp?age=" + age);
 	} 	 
%>

</body>
</html>