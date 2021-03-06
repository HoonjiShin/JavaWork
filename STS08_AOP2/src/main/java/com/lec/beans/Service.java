package com.lec.beans;

public abstract class Service {
	public abstract void doAction();
	
	//테스트용 : 메소드 호출정보 출력
	public void printInfo() {
		String className = this.getClass().getSimpleName(); //현재 실행되고 있는 클래스 이름
		StackTraceElement[] stackTrace = new Throwable().getStackTrace();
		String methodName = stackTrace[1].getMethodName();
		System.out.println(className+" 의  "+methodName+"() 호출");
	}
	
	
}
