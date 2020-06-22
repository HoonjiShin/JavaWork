package com.lec.spring.aop01;

import com.lec.beans.Service;
import com.lec.beans.Logger;
public class MyService11 extends Service {

	//관심사(공통기능) 코드가 함꼐 섞여 있는 경우.
	
	@Override
	public void doAction() {
		new Logger().logIn();
		
		// 핵심기능
		//System.out.println("MyService11 의 doAction()");
		printInfo();
		
		new Logger().logOut();
	}

}
