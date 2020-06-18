package com.lec.spring;

public class MessageKor implements MessageBean {
	
	String msgKor = "안녕하세요";
	
	public MessageKor() {
		super();
		System.out.println("messagekor() 생성");
	}

	@Override
	public void sayHello() {
		System.out.println(msgKor);
	}
}