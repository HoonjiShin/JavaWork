package com.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.CategoryDAO;
import com.lec.beans.CategoryDTO;

public class CateListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		CategoryDAO dao = new CategoryDAO();
		CategoryDTO[] arr = null;

		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL";   // 기본 FAIL
		
		//카테고리 관련 세팅값들
		int ca_depth = 1; //디폴트 1
		int ca_parent = 0; //부모값
		
		String param;
		
		param = request.getParameter("ca_depth");
		if(param != null && param.trim().length() != 0) {
			try {				
				ca_depth = Integer.parseInt(param);
			} catch(NumberFormatException e) {
				// 예외 처리 안함
			}
		}
		
		param = request.getParameter("ca_parent");
		if(param != null && param.trim().length() != 0) {
			try {				
				ca_parent = Integer.parseInt(param);
			} catch(NumberFormatException e) {
				// 예외 처리 안함
			}
		}
		
		try {
			dao = new CategoryDAO();
			if(request.getParameter("ca_parent") == null) {
				arr = dao.selectByNoParent();
			}else {
				arr = dao.selectByParent(ca_depth, ca_parent);
			}
		
			if(arr == null) {
				message.append("[리스트할 데이터가 없습니다]");
			} else {
				status = "OK";
			}
			
		} catch (SQLException e) {
			message.append("[트랜잭션 에러:" + e.getMessage()+ "]");
			e.printStackTrace();
		}
		
		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());
		request.setAttribute("list", arr);
		
		request.setAttribute("ca_depth", ca_depth);
		request.setAttribute("ca_parent", ca_parent);
		
	}
}