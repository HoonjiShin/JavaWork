package com.lec.spring;

public class MessageEng implements MessageBean {

	String msgEng = "Good morning";
	
	public MessageEng() {
		System.out.println("messageeng() 생성");
	}

	@Override
	public void sayHello() {
		System.out.println(msgEng);
	}
}