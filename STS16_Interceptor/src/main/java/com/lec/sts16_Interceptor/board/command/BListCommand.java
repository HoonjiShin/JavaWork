package com.lec.sts16_Interceptor.board.command;

import java.util.List;

import org.springframework.ui.Model;

import com.lec.sts16_Interceptor.board.beans.*;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {
		BWriteDAO dao = new BWriteDAO();
		List<BWriteDTO> list = dao.select();
		model.addAttribute("list", list);

	}

}








