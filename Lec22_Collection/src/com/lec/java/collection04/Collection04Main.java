package com.lec.java.collection04;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;


public class Collection04Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		
		Scanner sc = new Scanner(System.in);
		ArrayList<MemberModel> list = new ArrayList<MemberModel>();

		for(int i=0;i<3;i++) {
			System.out.println("id: ");
			String id = sc.nextLine();
			System.out.println("passwd: ");
			String passwd = sc.nextLine();
			
			MemberModel model = new MemberModel(id,passwd);
			list.add(model);
		}
			sc.close();
			
		Iterator<MemberModel> itr = list.iterator();
		while(itr.hasNext()) {
			itr.next().displayInfo();
		}
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












