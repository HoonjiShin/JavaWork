package 반복제어문2.자가진단06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		double score;
		double avg=0;
		double sum =0;
		for(int i =0 ; i< num;i++) {
			score = sc.nextInt();
			sum += score;
			
		}
		
		avg = sum/num;
		
		System.out.printf("avg : %.1f \n",avg);
		
		if(avg > 80) {
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}
	}

}
