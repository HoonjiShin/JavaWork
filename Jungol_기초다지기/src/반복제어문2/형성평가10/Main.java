package 반복제어문2.형성평가10;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i,j;
		int num =sc.nextInt();
	for(i=1;i<=num;i++) {
		for(j=1;j<=num;j++) {
			System.out.print("("+i+", "+j+") ");
		}
		System.out.println();
	}

	}

}
