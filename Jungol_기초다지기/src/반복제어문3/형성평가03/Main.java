package 반복제어문3.형성평가03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 3;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == n) {
					for (j = n; j > 0; j--) {
						System.out.print("*");
					}
				}else
				System.out.print("*");

			}
			System.out.println();
		}
		sc.close();
	}
}