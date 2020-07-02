package com.lec.sts19_REST.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lec.sts19_REST.board.C;
import com.lec.sts19_REST.board.beans.*;

@RestController
@RequestMapping("/MyRest")
public class MyRestController {
	
	@RequestMapping("/")
	public String helloTEXT() {
		return "Hello REST";
	}

	@RequestMapping("/helloJSON")
	public BWriteDTO helloJSON() {
		BWriteDTO dto = 
				new BWriteDTO(100,"HELLO","REST","JSON!!",123,new Timestamp(10000));
		return dto;
	}
	
	// JSON 데이터 ← 자바객체 List
		@RequestMapping("/listJSON")
		public List<BWriteDTO> listJSON(){
			IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
			return dao.select();
		}
		
	// JSON 데이터 ← 자바 배열
	@RequestMapping("/arrJSON")
	public BWriteDTO[] arrJSON(){
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		List<BWriteDTO> list = dao.select();
		BWriteDTO[] arr = new BWriteDTO[list.size()];
		return list.toArray(arr);
	}
	
	// JSON 데이터 ← 자바객체 Map<k,v>
	@RequestMapping("/mapJSON")
	public Map<Integer, BWriteDTO> mapJSON(){
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		List<BWriteDTO> list = dao.select();
		
		Map<Integer, BWriteDTO> map = new HashMap<Integer, BWriteDTO>();
		
		for(BWriteDTO dto : list) {
			// key:value => id:DTO
			map.put(dto.getUid(), dto);  
		}
		
		return map;
	}

	@RequestMapping("/helloXML")
	public EmployeeVO helloXML() {
		return new EmployeeVO(100,"홍길동",200,new int[] {10,20,30},34.2);
	}

	//XML 데이터 <- 자바객체 (List 포함)
	@RequestMapping("/listXML")
	public EmployeeListVO listXML() {
		EmployeeListVO employees = new EmployeeListVO();
		
		EmployeeVO emp1 = new EmployeeVO(1,"개똥",23,new int[] {10,20,30},12.2);
		EmployeeVO emp2 = new EmployeeVO(2,"말자",31,new int[] {40,50,60},23.5);
		EmployeeVO emp3 = new EmployeeVO(3,"삼순",34,new int[] {70,80,90},50.9);
		
		employees.getEmployees().add(emp1);
		employees.getEmployees().add(emp1);
		employees.getEmployees().add(emp3);
		
		return employees;
	}
		
	/*
	 * @RequestMapping(value = "/read/{id}") public BWriteDTO
	 * read(@PathVariable("id") int id) { IWriteDAO dao =
	 * C.sqlSession.getMapper(IWriteDAO.class); return dao.selectByUid(id); }
	 */
	
	@RequestMapping(value = "/read/{uid}")
	public ResponseEntity<BWriteDTO> read(@PathVariable("uid") int uid) {
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		BWriteDTO dto = dao.selectByUid(uid);
		
		// 실패
		if(dto == null) return new ResponseEntity(HttpStatus.NOT_FOUND); // 404
		
		// 성공
		return new ResponseEntity<BWriteDTO>(dto, HttpStatus.OK); // 200
	}

	

}
