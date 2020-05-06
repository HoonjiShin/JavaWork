package 반복제어문3.자가진단01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num, count = 0,sum = 0;
		num= sc.nextInt();
		
		for(int i=1;i<100;i+=2) {
			sum+=i;
			count++;			
			if(sum >= num) break;
		}
		System.out.println(count+" "+sum);
	}

}
