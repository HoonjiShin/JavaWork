package com.lec.java.static03;

public class Test {
	private int num;
	
	static int count =0;
	
	
	//singleton pattern
	private Test() {
		count++;
		System.out.println(count + "번쨰 인스턴스 생성");
	}
	private static Test instance = null;
	public static Test getInstance() {
		if(instance == null) {
			instance = new Test(); //인스턴스 생성
			}
		return instance;
	}
	
	public int getNum() {return num;}
	public void setNum(int num) {this.num = num;}
	//singleton pattern
	
}
