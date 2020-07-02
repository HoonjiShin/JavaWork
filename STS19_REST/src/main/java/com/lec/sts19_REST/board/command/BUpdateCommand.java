package com.lec.sts19_REST.board.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts19_REST.board.C;
import com.lec.sts19_REST.board.beans.*;

public class BUpdateCommand implements BCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		BWriteDTO dto = (BWriteDTO)map.get("dto");
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		
		int cnt = dao.update(dto);
		model.addAttribute("result", dao.update(dto.getUid(),dto));
	}

}












