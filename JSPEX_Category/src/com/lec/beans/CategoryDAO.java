package com.lec.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.D;

public class CategoryDAO {

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;   // SELECT 결과, executeQuery()
	
	// DAO 객체가 생성될때 Connection 도 생성된다.
	public CategoryDAO() {
		
		try {
			Class.forName(D.driver);
			conn = DriverManager.getConnection(D.url, D.userid, D.userpw);
			System.out.println("WriteDAO 생성, 데이터 베이스 연결!");
		} catch(Exception e) {
			e.printStackTrace();
			// throw e;
		}		
		
	} // 생성자

	// DB 자원 반납 메소드,
	public void close() throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
	} // end close()
	
	public CategoryDTO[] createArray(ResultSet rs) throws SQLException{
		CategoryDTO[] arr = null;
		ArrayList<CategoryDTO> list = new ArrayList<CategoryDTO>();
		
		while(rs.next()) {
			int ca_uid = rs.getInt("ca_uid");
			String ca_name = rs.getString("ca_name");
			int ca_depth = rs.getInt("ca_depth");
			int ca_parent = rs.getInt("ca_parent");
			int ca_order = rs.getInt("ca_order");
			
			CategoryDTO categ_dto = new CategoryDTO(ca_uid,ca_name,ca_depth,ca_parent,ca_order);
			list.add(categ_dto);
			
		}// end while
		
		int size = list.size();
		
		if(size == 0) return null;
		
		arr = new CategoryDTO[size];
		list.toArray(arr);  // List -> 배열	
		
		return arr;
	}
	
	public CategoryDTO[] selectByParent(int ca_depth,int ca_parent) throws SQLException {
		CategoryDTO[] arr = null;
		
		try {
			if(ca_parent != 0) {
			pstmt = conn.prepareStatement(D.SQL_CATEGORY_BY_DEPTH_N_PARENT);
			pstmt.setInt(1, ca_depth);
			pstmt.setInt(2, ca_parent);
			} else if(ca_parent == 0) {
				pstmt = conn.prepareStatement(D.SQL_CATEGORY_BY_DEPTH_NO_PARENT);
			}
			rs = pstmt.executeQuery();
			arr = createArray(rs);
		}
		finally {
			close();
		} // end try
		
		return arr;
	}
	
	public CategoryDTO[] selectByNoParent() throws SQLException {
		CategoryDTO[] arr = null;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_CATEGORY_BY_DEPTH_NO_PARENT);
			rs = pstmt.executeQuery();
			arr = createArray(rs);
		}
		finally {
			close();
		} // end try
		
		return arr;
	} 
}





















