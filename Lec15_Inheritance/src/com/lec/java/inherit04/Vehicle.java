package com.lec.java.inherit04;

public class Vehicle {
	int speed;
	
	public Vehicle() {
		System.out.println("vehicle 생성");
	}
	public Vehicle(int speed) {
		this.speed = speed;
		System.out.println("vehicle 생성: speed="+speed);
	}
}
