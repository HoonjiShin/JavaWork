package 반복제어문3.형성평가01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		int sum=0;
		int cnt=0;
		for(int i=0;i<20;i++) {
			num =sc.nextInt();
			if(num == 0) break;
			sum += num;
			cnt++;
		}
		System.out.println(sum +" "+sum/cnt);
	}

}
