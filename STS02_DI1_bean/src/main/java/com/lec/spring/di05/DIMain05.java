package com.lec.spring.di05;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import com.lec.spring.Score;

public class DIMain05 {

	public static void main(String[] args) {
		System.out.println("Main 시작");
		
		// 컨테이너 생성
		AbstractApplicationContext ctx 
			= new GenericXmlApplicationContext("classpath:studentCtx2.xml");
		System.out.println("--컨테이너 생성--");
		
		Score score = null;
		
		score = (Score)ctx.getBean("score1");
		System.out.println(score);

		
		ctx.close();
		System.out.println("Main 종료");
	}

}
