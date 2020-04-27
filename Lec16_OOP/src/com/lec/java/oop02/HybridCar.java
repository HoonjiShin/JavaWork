package com.lec.java.oop02;

public class HybridCar extends Car {
	private int electricity;

	public int getElectricity() {
		return electricity;
	}

	public void setElectricity(int electricity) {
		this.electricity = electricity;
	}
	
	@Override
	public void displayInfo() {
		System.out.println("---HybridCar info---");
		System.out.println(getSpeed());
		System.out.println(getOil());
		System.out.println(electricity);
	}
}
