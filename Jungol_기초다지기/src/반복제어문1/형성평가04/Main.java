package 반복제어문1.형성평가04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count  =0 ;
		while(true) {
			int num = sc.nextInt();	
			 if(num == 0)break;
			 else {
				 if(num % 3 != 0 && num % 5 != 0) {
					 count++;
				 }
			 }
		}
		System.out.println(count);

	}

}
