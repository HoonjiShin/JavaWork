package com.lec.java.inherit07;

//final class : 더이상 상속불가
//public final class Person
public class Person {
	
	private String name;
	
	public String getName() {return this.name;}
	public void setName(String name) {this.name = name;}
	
	public void showInfo() {
		System.out.println("이름: " + name);
	}
	
	//final method : no more overiding
	public final void whoAreYou() {
		System.out.println("이름: " + name);
	}
}










