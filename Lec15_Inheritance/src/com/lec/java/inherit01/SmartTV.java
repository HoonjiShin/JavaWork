package com.lec.java.inherit01;

public class SmartTV {
	//멤버변수
	boolean isPowerOn;
	int channel;
	int volume;
	String ip; //smart tv에서 새로 추가된 필드
	
	public void displayInfo() {
		System.out.println("---TV 현재 상태---");
		System.out.println("전원: "+isPowerOn);
		System.out.println("채널: "+ channel);
		System.out.println("볼륨: "+volume);
		System.out.println("IP: "+ip); //smarttv에서 추가된 필드
		
	}
}
