package 배열1.자가진단06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] num = new int [10];
		int [] inputNum = new int[num.length];
		for (int i = 0; i < num.length; i++) {
			inputNum[i] = sc.nextInt();
			num[i] = inputNum[i];
		}
		
		int numMin = 1000;
		for (int i = 0; i < inputNum.length; i++) {
			
			if(num[i] < numMin) {
				numMin = num[i];
			} else {
				continue;
			}
			
		}
		
		System.out.println(numMin);
		
		sc.close();

	}

}
