<!-- 7번  트랜잭션만 수행하고 list.jsp 로 넘어갈거기 때문에 db_test.jsp 복붙-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*"%> <%-- JDBC 관련 import --%>  

<%
/* 8번  */
request.setCharacterEncoding("UTF-8"); //한글 인코딩 꼭!!

/* 9번  입력한 값 받아오기*/
String name = request.getParameter("name");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");

	// 유효성 체크, 
		// name, subject 는 비어있으면 안된다. NN
		// null 이거나 빈 문자열이면 이전화면으로 돌아가기
		if(name == null || subject == null ||
			name.trim().equals("") || subject.trim().equals("")){
	%>
			<script>
				alert("작성자 이름, 글제목은 필수 입니다!");
				history.back();   // history.go(-1);
			</script>
	<%		
			return;    // ★ 더 이상 JSP 프로세싱 하지 않도록 종료 ★
		}
	%>
<!-- /* end 9번 */ -->

<%!
//JDBC 관련 기본 객체변수
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;   // SELECT 결과, executeQuery() 
	int cnt = 0;   // DML 결과, executeUpdate()
	
	// Connection 에 필요한 값 세팅
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "scott0316";
	String userpw = "tiger0316";
%>

<%!
	// 쿼리문 준비
	String sql_insert = "INSERT INTO test_write " +
		"(wr_uid, wr_subject, wr_content, wr_name) " +
		"VALUES(test_write_seq.nextval, ?, ?, ?)"
		;
%>
<%
	try{
		
		Class.forName(driver);
		out.println("드라이버 로딩 성공"+"<br>");
		conn = DriverManager.getConnection(url,userid,userpw);
		out.println("conn 성공"+"<br>");
		/* 11번 */
		//트렌젝션 실행
		pstmt = conn.prepareStatement(sql_insert);
		
		pstmt.setString(1,subject);
		pstmt.setString(2,content);
		pstmt.setString(3,name);
		
		cnt = pstmt.executeUpdate();
		/* --------------------------------------->이부분에서 트렌젝션 수행 */
		/* end 11번 */
		
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
%>
<!-- end 7번 -->
<!-- 12번  -->
<!-- 위 트렌젝션이 마무리 되면 페이지 보여주기 -->
<% if(cnt == 0){ %>
	<script>
		alert("등록 실패!!!!!!");
		history.back(); // 브라우저가 직전에 기억하는 페이지로
	</script>
<% } else { %>
	<script>
		alert("등록 성공.  리스트 출력합니다");
		location.href = "list.jsp";
	</script>			
<% } %>

<!-- end 12번  -->