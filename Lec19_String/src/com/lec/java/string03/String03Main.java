package com.lec.java.string03;

/*  StringBuffer, StringBuilder

	 String 클래스는 immutable 클래스이고,
	 StringBuffer, StringBuilder는 mutable 클래스임


	 StringBuffer:
		Java ver 1.0부터 있던 클래스
		쓰레드에 안전(thread-safe), 속도가 느림
	
	 StringBuilder:
		Java 5부터 생긴 클래스
		쓰레드에 안전하지 않다(thread-unsafe), 속도가 빠름.
	
		그 외에는 StringBuffer와 StringBuilder는 같은 기능(메소드)을 갖고 있음
		

	** 웹 프로그래밍 등에선 문자열을 '붙여 나가며' 완성하는 동작을 많이 함
		실무에서는
			String 을 concat() (혹은 + 연산)하기 보다는
			StringBuffer 를 append() 하는 것을 더 많이 사용함  (성능 UP)
			
		※ 그러나 학습예제에선 예제단순화를 위해 String 을 기본적으로 사용하니 참조 바랍니다
 */
public class String03Main {

	public static void main(String[] args) {
		System.out.println("[1] StringBuffer, StringBuilder");
		// String 클래스는 immutable 클래스이고,
		// StringBuffer, StringBuilder는 mutable 클래스임

		System.out.println("[String: immutable]");

		String str1 = "Hello";
		String str2 = str1;

		System.out.println("str1 = " + str1);
		System.out.println("str2 = " + str2);

		if(str1==str2) {
			System.out.println("== 동일참조");
		} else {
			System.out.println("== 다른 참조");
		}
		
		System.out.println(str1.concat("java"));
		System.out.println(str1); //str1 변경x
		str1 = str1.concat("java");
		System.out.println(str1);//str1 변경o
		
		if(str1==str2) {
			System.out.println("== 동일참조");
		} else {
			System.out.println("== 다른 참조");
		}
		
		System.out.println();
		System.out.println("[StringBuffer: mutable]");
		
		StringBuffer buff1 = new StringBuffer("hello"); //new로 밖에 생성 못함.
		StringBuffer buff2 = buff1;
		
		System.out.println("buff1 = "+ buff1);
		System.out.println("buff2 = "+ buff2);
		
		if(buff1 == buff2) { //reference type 으로 주소 비교
			System.out.println("==동일참조");
		}else {
			System.out.println("==다른 참조");
		}
		
		System.out.println(buff1.append("java")); //append:String때의 concat과 같은 역할.
		System.out.println(buff1); //mutable
		
		if(buff1 == buff2) { //reference type 으로 주소 비교
			System.out.println("==동일참조");
		}else {
			System.out.println("==다른 참조");
		}
		System.out.println(buff2);
		
		//concat은  heap에 새로운 공간을 계속만들어 내고 
		//append는 사용한 공간에서 변화를 가지기 때문에 
		//concat이 append보다 속도가 현저히 느리다.
		
		
		
		// StringBuffer:
		//  Java ver 1.0부터 있던 클래스
		//  쓰레드에 안전(thread-safe), 속도가 느림
		
		// StringBuilder:
		// Java 5부터 생긴 클래스
		// 쓰레드에 안전하지 않다(thread-unsafe), 속도가 빠름.
		
		// 그 외에는 StringBuffer와 StringBuilder는 같은 기능을 갖고 있음
		
		StringBuilder buff3 =new StringBuilder("Hello");
		System.out.println(buff3.append("java"));
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class