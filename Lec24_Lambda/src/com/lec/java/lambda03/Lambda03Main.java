package com.lec.java.lambda03;

/*
	 세가지 방법으로 자유자재로 구현할수 있어야 합니다.
	 방법 1) 클래스 implements 인터페이스 + 오버라이딩.
	 방법 2) 익명클래스
	 방법 3) 람다 표현식 lambda expression
*/
public class Lambda03Main {

	public static void main(String[] args) {
		System.out.println("익명 클래스, 람다 표현식 연습");
		
//		 방법 1) 클래스 implements 인터페이스 + 오버라이딩.
		// 덧셈연산
		Operable myAdd = new operate();
		double result = myAdd.operate(20, 30);
		System.out.println("result: " + result);

//		 방법 2) 익명클래스
		// 뺄셈연산
		Operable mySub2 = new Operable() {

			@Override
			public double operate(double x, double y) {

				return x - y;
			}
		};
		result = mySub2.operate(50, 30);
		System.out.println("result: " + result);
//		 방법 3) 람다 표현식 lambda expression
		// 제곱연산
		Operable myPow = (x, y) -> Math.pow(x, y);
		System.out.println("result: " + myPow.operate(3, 2));
		System.out.println();

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class

interface Operable {
	public abstract double operate(double x, double y);
}

class operate implements Operable{

	@Override
	public double operate(double x, double y) {
		// TODO Auto-generated method stub
		return x+y;
	}
	
}
