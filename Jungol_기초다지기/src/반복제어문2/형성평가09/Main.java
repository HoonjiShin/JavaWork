package 반복제어문2.형성평가09;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, j;
		int num = sc.nextInt();
		int num2 = sc.nextInt();
		if (num > num2) {
			for (i = 1; i < 10; i++) {
				for (j = num; j >= num2; j--) {
					System.out.printf("%d * %d = %2d   ", j, i, i * j);
				}
				System.out.println();
			}
		} else if (num < num2) {
			for (i = 1; i < 10; i++) {
				for (j = num; j <= num2; j++) {
					System.out.printf("%d * %d = %2d   ", j, i, i * j);
				}
				System.out.println();
			}
		}else {
			for (i = 1; i < 10; i++) {
				for (j = num; j <= num2; j++) {
					System.out.printf("%d * %d = %2d   ", j, i, i * j);
				}
				System.out.println();
			}
		}
	}

}
