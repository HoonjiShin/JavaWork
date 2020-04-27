package com.lec.java.variable04;

public class Variable04Main {

	public static void main(String[] args) {
		System.out.println("변수 - char, boolean, String");
		// char : 문자열 하나 저장을 위한 data type (2byte)
		char ch1 = 'A';
		// char literal은 ''로 묶어줌
		// String literal은 ""로 묶어줌
		
		System.out.println(ch1);
		
		char ch2 = '한';
		char ch3 = '글';
		System.out.println(ch2);
		System.out.println(ch3);
		
		char ch4 = 0xAE01;
		System.out.println(ch4);
		char ch5 = 1234;
		System.out.println(ch5);
		
		//println()은 char를 문자로 출력함
		//그러나, 다른 정수형을 변환 되면 해당 코드값을 정수로 출력
		char ch6 = '!';
		System.out.println("ch6: " + ch6);
		char ch7 = 33;
		System.out.println("ch7: " + ch7);
		
		System.out.println("ch7 + 1 : " + (ch7 + 1));
		System.out.println("ch7 + 1 : " + (char)(ch7 + 1));
		
		char ch8 = 'A';
		char ch9 = 'a';
		System.out.println("'A' : " + ch8 + "-" + (int)ch8);
		System.out.println("'a' : " + ch9 + "-" + (int)ch9);
		
		// boolean(논리형) : 참(true), 거짓(false)
		boolean b1 = true;
		boolean b2 = false;
		System.out.println("b1 : " + b1);
		System.out.println("b2 : " + b2);
		
		System.out.println(10 < 20);
		System.out.println(10 > 20);
		
		boolean b3 = 10 < 20;
		System.out.println("b3 : " + b3);
		
		//String type
		//primitive ㅌ;
		// String 타입 (문자열)
				// primitive 타입 아닙니다!
				String name = "Hong";   // String literal 은 " ~ "
		String nick = "Thunder";
		System.out.println("이름은: " + name + "\n별명은:" + nick);
				
	}

}
