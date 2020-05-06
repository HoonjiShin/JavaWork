package 반복제어문3.형성평가02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum=0;
		for(int i=0;i<100;i++) {
			sum += num;
			
			if(sum>100) break;
			System.out.print(sum+" ");
			if(sum % 10 ==0)break;
			
		}
	}

}
