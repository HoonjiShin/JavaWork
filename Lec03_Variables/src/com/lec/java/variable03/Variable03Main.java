package com.lec.java.variable03;

//실수형 자료 타입: float(4바이트), double(8바이트)
//정수형 자료 타입의 기본형은 int
//실수형 자료 타입의 기본형은 double
public class Variable03Main {

	public static void main(String[] args) {
		System.out.println("변수 - 실수타입");
		
		double number1 = 3.141592;
		//float number2 = 3.14; 기본적으로 실수 literal은 double로 인식
		// float에 double 대입 불가
		
		//float literal
		float number3 = 3.14f;
		
		//실수 타입 최소, 최대값 
		System.out.println("Float:" + Float.MIN_VALUE + "~" + Float.MAX_VALUE);
		System.out.println("Double:" + Double.MIN_VALUE + "~" + Double.MAX_VALUE);
		
		float number4 = 1.23456789f;
		double number5 = 1.23456789;
		System.out.println(number4);
		System.out.println(number5);
		//float and double은 저장 할 수 있는 값의 크기만이 아니라 
		//소숫점 이하 정밀도(precision)의 차이가 있다
		
		//실수 표기법
		double number6 = 123;
		double number7 = 1.23e2; //exponential notation(지수표기법)
		System.out.println(number6);
		System.out.println(number7);
		
		double number8 = 0.0001213;
		double number9 = 1.2313E-4;
		System.out.println(number8);
		System.out.println(number9);
	}

}
