package com.lec.sts10_request;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/common") // /common으로 요청이 오면 
	public String cccmmm() {		// 밑에 cccmmm() 핸들러가 수행되고 
		return "comn"; 			   // /WEB-INF/views/comn.jsp 를 리턴하여 response 된다.
	}
	
	@RequestMapping(value="/member/search") // /member/search으로 요청이 오면 
	public String searchMember() {		// 밑에 searchMember() 핸들러가 수행되고 
		return "member/search"; 			   // /WEB-INF/views/member/search.jsp 를 리턴하여 response 된다.
	}
	
	@RequestMapping(value="/member/infoView") 
	public String infoMember(Model model) {
		model.addAttribute("mbAge",30);
		model.addAttribute("mbName","홍길동");
		return "member/info"; 			 
	}
	
	@RequestMapping(value="/member/find")
	public ModelAndView findMember() {
		ModelAndView mv = new ModelAndView();
		
		//데이터도 담고
		mv.addObject("mbName","다스베이터");
		mv.addObject("mbDate","2020/06/22");
		
		//뷰도 지정
		mv.setViewName("member/find");
		return mv;
	}
	
	// 확장자 패턴 사용 가능
	@RequestMapping(value = "/member/*.do")
	public String doMemeber() {
		
		
		
		return "member/doMember";
	}
	
}
