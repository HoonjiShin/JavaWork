<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %> <!-- 1번 JDBC관련 import -->
<%!
	//2번 JDBC 관련 기본 객체 변수
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; //select 결과 , executeQuery()
	int cnt = 0; //DML 결과 executeUpdate()
	//end 2번
	
	//3번 connection에 필요한 값 세팅
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "scott0316";
	String userpw = "tiger0316";
	//end 3번
	
%>

<%!
	//쿼리문 준비

%>
<%
	//4번
	try{
		
		Class.forName(driver);
		out.println("드라이버 로딩 성공"+"<br>");
		conn = DriverManager.getConnection(url,userid,userpw);
		out.println("conn 성공"+"<br>");
		
	}catch(Exception e){ //예외처리
		e.printStackTrace();
	} finally{ //리소스 해제
		try{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//end 4번
%>
<%-- 위 트랜잭션이 마무리 되면 페이지 보여주기 --%>
