package 반복제어문2.형성평가08;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i,j;
		int num1 =sc.nextInt();
		int num2 = sc.nextInt();
	for(i=1;i<=num1;i++) {
		for(j=1;j<=num2;j++) {
			System.out.print((i*j)+" ");
		}
		System.out.println();
	}

	}

}
