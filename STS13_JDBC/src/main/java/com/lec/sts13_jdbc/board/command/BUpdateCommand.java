package com.lec.sts13_jdbc.board.command;

import java.util.Map;

import org.springframework.ui.Model;
import com.lec.sts13_jdbc.board.beans.*;

public class BUpdateCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// Model 안에 있는 값(attribute) 꺼내기
		Map<String, Object> map = model.asMap();
		BWriteDTO dto = (BWriteDTO)map.get("dto");	
		BWriteDAO dao = new BWriteDAO();
		int uid = dto.getUid();
		//int result = dao.update(uid);
		//model.addAttribute("updateok",result);
	}

}
