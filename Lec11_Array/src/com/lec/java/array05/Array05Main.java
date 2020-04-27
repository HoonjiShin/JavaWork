package com.lec.java.array05;

import java.util.Scanner;

/* 2차원 배열 (2-dimensional array)
 * 	직전의 예제와 같이 같이 배열 첨자를 하나만 쓰는 배열을 
 * 1차원 배열 (one-dimensional array) 이라고 함
 *   배열원소가 '1차원 배열' 들로 이루어진 배열을 2차원 배열 이라 한다
 *   배열원소가 '2차원 배열' 들로 이루어진 배열을 3차원 배열 이라 한다
*/
public class Array05Main {

	public static void main(String[] args) {
		System.out.println("2차원 배열");
		
		// 1차원 배열들
				int[] arr1 = {1, 2};
				int[] arr2 = {3, 4};
				int[] arr3 = {5, 6};
				
		//2차원 배열
		int[][] array = {
				{1,2},
				{3,4},
				{5,6}	
		};
		System.out.println(array[0][0]);
		System.out.println(array[0][1]);
		System.out.println(array[1][0]);
		System.out.println(array[1][1]);
		System.out.println(array[2][0]);
		System.out.println(array[2][1]);
		
		
		
		//흔히 2차원 배열을 행과 열로 표기 하기도 함 
		//위 array는 3행 2열 인 2차원배열
		
		System.out.println("array.lenth = " + array.length);

		//array 의 type = int[][]
		//array[]의 타입 = int[]
		//array[][]의 타입 = int
		System.out.println("array[0].length = " + array[0].length);
		
		//2차원 배열 원소, for
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
		System.out.println(array);
		System.out.println(array[0]);
		System.out.println(array[1]);

		// TODO: 
				// 2행 4열의 2차원배열을 만들어서 
				// 아래와 같이 초기화하고 출력하기
				
				// 첫번째 배열 출력
				// 1 2 3 4
				// 5 6 7 8	
		
		int array2[][]= {
				{1,2,3,4},{5,6,7,8}
		};
		for (int i = 0; i < array2.length; i++) {
			for (int j = 0; j < array2[i].length; j++) {
				System.out.print(array2[i][j]);
			}System.out.println();
		}
		}
	
		
		// end main()

} // end class Array05Main









