package com.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lec.beans.AjaxCategWriteResult;

public class AjaxCategResultCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		AjaxCategWriteResult result = new AjaxCategWriteResult();
		
		result.setStatus((String)request.getAttribute("status"));
		result.setCount((Integer)request.getAttribute("result"));	
		
		ObjectMapper mapper = new ObjectMapper();
		

		try {
			String jsonString = mapper.writerWithDefaultPrettyPrinter()
								.writeValueAsString(result);
			
			response.setContentType("application/json; charset=utf-8"); 
			response.getWriter().write(jsonString);			
		} catch(JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
