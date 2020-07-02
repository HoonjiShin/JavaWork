package com.lec.sts16_Interceptor.board.command;

import org.springframework.ui.Model;

public interface BCommand {
	void execute(Model model);
}
