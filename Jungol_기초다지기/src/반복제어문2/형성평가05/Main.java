package 반복제어문2.형성평가05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num,odd=0,even=0;
		for (int i = 0; i < 10; i++) {
			num = sc.nextInt();
			if(num % 2 ==0) even++;
			if(num % 2 != 0) odd++;
		}
		System.out.println("even : "+even);
		System.out.println("odd : "+odd);

	}

}
