package 반복제어문2.형성평가07;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum =num;
		for(int i=0;i<10;i++) {
			System.out.println(sum);
			sum += num;
			
		}
	}

}
