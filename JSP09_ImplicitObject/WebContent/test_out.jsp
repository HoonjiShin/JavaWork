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
<%-- <%
	int i = 0;
	while(true){
		i++;
		out.println("5 * " + i + "=" + 5 * i + "<br>");
%>

<%
		if(i >= 9) break;
	}
%> --%>
<%! //java part 선언부 태그
	int i = 100;
	String str = "test";
	public int hap(int a, int b){
		return a + b;
	}
%>
<% //스크립트릿
	out.println("i = "+i+"<br>");
	out.println("str = "+str +"<br>");
	out.println("hap = "+hap(2,10));
%>
<hr>
i = <%= i %><br>
str = <%= str %><br>
hap = <%= hap(2,10) %><br>
</body>
</html>