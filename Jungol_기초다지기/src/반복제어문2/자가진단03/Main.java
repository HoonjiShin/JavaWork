package 반복제어문2.자가진단03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
	 
	 int num = sc.nextInt();
	 
	 for (int i = 2; i <= num; i+=2) {
		System.out.print(i+" ");
	}
	}

}
