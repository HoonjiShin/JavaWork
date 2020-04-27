package com.lec.java.if01;

/* if, if ~ else 조건문
 * 
 * 구문1:
 * 	if (조건식) {
 *  	조건식이 true 일때 실행되는 문장(들) 
 *  	...
 * 	}
 * 
 * 구문2:
 *  if (조건식) {
 *		조건식이 true 일때 실행되는 문장(들)
 *		...
 *  } else {
 *		조건식이 false 일때 실행되는 문장(들)
 *		...
 *  }
 */
public class If01Main {

	public static void main(String[] args) {
		System.out.println("if 조건문");

		int num= -10;
		if(num < 0) {
			System.out.println("음수");
		}
		
		if(num > 0) {
			System.out.println("양수");
		} else {
			System.out.println("not 양수");
		}
		
		if(num < 0) 
			System.out.println("음수");
		else 
			System.out.println("not 양수");
		
		int num2 = 124;
		if(num2 % 2 == 0) {
			System.out.println("짝수");
		}else {
			System.out.println("not짝수");
		}
		
		//주어진 숫자가 0 ~ 100점 까지 범위 여부
		int num3 = 40;
		
		if(0<= num3 && num3<=100)
		{
			System.out.println("점수 가능");
		} else {
			System.out.println("not 점수");
		}
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
