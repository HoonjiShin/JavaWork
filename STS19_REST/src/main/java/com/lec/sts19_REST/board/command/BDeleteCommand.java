package com.lec.sts19_REST.board.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts19_REST.board.C;
import com.lec.sts19_REST.board.beans.*;

public class BDeleteCommand implements BCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int uid = (Integer)map.get("uid");
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		
		int cnt = dao.deleteByUid(uid);
		model.addAttribute("result", cnt);		
		
	}

}