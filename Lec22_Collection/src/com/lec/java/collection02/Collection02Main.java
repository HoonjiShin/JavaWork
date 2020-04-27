package com.lec.java.collection02;

import java.util.ArrayList;
import java.util.Iterator;

import javax.sound.sampled.Line;

public class Collection02Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		
		// String 타입을 담는 ArrayList를 만들고
		ArrayList<String> list = new ArrayList<String>();
		
		//Student stu = new Student();
		
		// 5개 이상의 String을 저장하고
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		list.add("eee");
		
		// set(), remove() 등의 메소드 사용하여
		// 임의의 것을 수정, 삭제 도 해보시고
		list.set(3, "change");
		list.remove(4);
		
		// 3가지 방식으로 출력해보세요
		//  for, Enhanced-for, Iterator
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			
		}
		
		System.out.println();
		System.out.println("Enhanced-for");
		for(String e:list) {
			System.out.println(e);
		}
		
		System.out.println();
		System.out.println("Iterator");
		
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()) {
			itr.next();
		}
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












