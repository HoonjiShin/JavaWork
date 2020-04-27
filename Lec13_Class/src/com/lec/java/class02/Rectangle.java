package com.lec.java.class02;

public class Rectangle {
	//속성 : 멤버변수
	//가로,세로
	double height;
	double width;
	
	public Rectangle() {
		System.out.println("Rectangle() 생성");
		System.out.println("가로: "+ width);
		System.out.println("세로: "+ height);
	}
	 //2. 매개변수 가진 생성자
	public Rectangle(double w, double h) {
		width = w;
		height = h;
		System.out.println("가로: "+ width);
		System.out.println("세로: "+ height);
	}
}
