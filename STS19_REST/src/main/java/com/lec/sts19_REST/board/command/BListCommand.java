package com.lec.sts19_REST.board.command;

import java.util.List;

import org.springframework.ui.Model;

import com.lec.sts19_REST.board.C;

import com.lec.sts19_REST.board.beans.*;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {
		/*
		 * BWriteDAO dao = new BWriteDAO(); 
		 * List<BWriteDTO> list = dao.select();
		 * model.addAttribute("list", list);
		 */

		//MyBatis 사용
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		model.addAttribute("list",dao.select());
	}
}