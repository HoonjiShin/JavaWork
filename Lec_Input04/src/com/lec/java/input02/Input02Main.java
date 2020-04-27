package com.lec.java.input02;

import java.util.Scanner;

//CTRL + SHIFT + O = import 자동입력
// String 입력
// char 입력

public class Input02Main {

	public static void main(String[] args) {
		
		System.out.println("표준입력: String, char");
		
		Scanner sc = new Scanner(System.in);
		
//		//String 입력
//		System.out.print("input name:");
//		String name = sc.nextLine();
//		System.out.print("input nickname:");
//		String nick = sc.nextLine();
//		
//		System.out.println("name:"+name+"\tnickname:"+nick);
//		
//		//char 입력
//		//.nextChar()? 라는 명령 없음.
//		System.out.print("gender(M/F):");
//		char gender = sc.next().charAt(0);
//		System.out.println("name:"+name+"\tnickname:"+nick + "\tgender:"+ gender);
//		
//		System.out.println();
//		
		System.out.println("나이를 입력하세요: ");
		int age = sc.nextInt();
		
		System.out.println("주소도 입력하세요: ");
		
		
		sc.nextLine();//(중요!!)숫자 입력 받은 뒤에 문자열 입력시에는 반드시 \n 을 consume(buffer에서 제거)
		
		String addr = sc.nextLine();//enter를 입력할 때 까지 입력
		
		System.out.println("나이: " + age + "\n주소 : " + addr);
		
		
		
		
		
		sc.close();
	}

}
