package 반복제어문2.형성평가02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int temp;
		
		if(num1>num2) {
			temp = num1;
			num1= num2;
			num2 = temp;
			
		}
		for(;num1<=num2;num1++) {
			System.out.print(num1+" ");
		}
		
	}

}

