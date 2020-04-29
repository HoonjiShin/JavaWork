package 반복제어문2.형성평가04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int number;
		double sum =0 ,avg =0;
		for(int i=0;i<num;i++) {
			number = sc.nextInt();
			sum += number;
		}
		avg = sum / num;
		System.out.println(Math.round(avg*100)/100.0);
	}

}
