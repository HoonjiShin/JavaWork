package 반복제어문2.형성평가06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int temp;
		int sum=0, count=0;
		if(num1>num2) {
			temp = num1;
			num1= num2;
			num2 = temp;
			
		}
		for(;num1<=num2;num1++) {
			if(num1 % 3 == 0 || num1%5==0) {
				sum += num1;
				count++;
			}
		}
		System.out.println("sum : "+sum);
		System.out.printf("avg : %.1f",(double)sum/count);
		
	}
}
