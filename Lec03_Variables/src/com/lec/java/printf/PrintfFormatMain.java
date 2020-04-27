package com.lec.java.printf;
/* 서식화된 문자열 (formatted string)
 *  ● 화면에 출력할때는 -> printf()
 *    
 *    printf("서식문자열", 값1, 값2....)
 *    
 *  ● 문자열(String)으로 만들때는 -> String.format()
 *       	
 *    String.format("서식문자열", 값1, 값2....)
 *    
 *  ● format specifier (서식 지정자)
 *  	%d  :  십진수 정수로 출력
 *  	%f  :  실수 출력
 *  	%s  :  문자열 출력
 *  	%c  :  '문자하나' 출력
 *  	%x  :  16진수 정수로 출력
 *  	%%  :  % 출력
*/


public class PrintfFormatMain {

	public static void main(String[] args) {
		System.out.println("서식화된 출력: printf(), String.format()");
		double pi = Math.PI;
		System.out.println(pi);
		
		//printf:print with format
		//printf("서식문자열",값1,값2,...);
		//서식문자열 안에는 %로 시작하는 format specifiers
		System.out.printf("원주율 %f\n",pi);
		System.out.printf("원주율 %.2f\n",pi);
		
		int age = 10;
		short grade = 3;
		System.out.printf("My age is %d years old, My grade is %d\n",age,grade);
		
		//소수점 이하 제한
		double height =182.3;
		System.out.printf("My height is %.1fcm and I'm %d years old\n",height,age);
		
		//출력폭 지정 , 좌우정렬 
		System.out.printf("|%d|%d|%d|\n",100,200,300);
		System.out.printf("|%5d|%5d|%5d|\n",100,200,300); //출력폭 5칸 , 우측정렬
		System.out.printf("|%-5d|%-5d|%-5d|\n",100,200,300); //좌측정렬

		
		System.out.printf("My name is [%10s]. My blood type is %c.\n","봉준호",'B');
		
		//% 출력
		double rate = 134423.0 / 345678.0;
		System.out.printf("합격률은 %.1f%% 입니다.",rate);
				
		//숫자에 padding
		System.out.printf("|%05d|%05d|%05d|\n",100,200,300);
		
		//format 문자열을 따로 설정해서 운영
		 String fmt = "address: %s, mail number[%05d]";
		 System.out.printf(fmt + "\n","seoul",12345);
		 System.out.printf(fmt + "\n","광주",45);
		 System.out.printf(fmt + "\n","대구",125);

		 //String.format()
		 String.format("합격률은 %.1f%%", rate);
		 String result = String.format("합격률은 %.1f%%", rate);
		 System.out.println(result);
		 
		
		
		
	}

}
