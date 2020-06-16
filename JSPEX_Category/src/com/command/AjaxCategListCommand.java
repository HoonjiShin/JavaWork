package com.command;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lec.beans.AjaxCategWriteList;
import com.lec.beans.CategoryDTO;

public class AjaxCategListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		CategoryDTO [] dtoArr = (CategoryDTO[])request.getAttribute("list");
		
		AjaxCategWriteList result = new AjaxCategWriteList();
		
		result.setStatus((String)request.getAttribute("status"));
		
		if(dtoArr != null) {
			result.setCount(dtoArr.length);
			result.setList(Arrays.asList(dtoArr));
		}
		
		try {
			result.setCa_depth((Integer)request.getAttribute("ca_depth"));
			result.setCa_parent((Integer)request.getAttribute("ca_parent"));
		}catch(Exception e) {
			// 개 무시..    /view.ajax 에선 페이징 관련 변수값들이 없다..
		}
		
		ObjectMapper mapper = new ObjectMapper();  // Json 매핑할 객체
		
		try {
			String jsonString = 
					mapper.writerWithDefaultPrettyPrinter()
						.writeValueAsString(result);
			response.setContentType("application/json; charset=utf-8"); 
			response.getWriter().write(jsonString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}