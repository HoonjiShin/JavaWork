package 반복제어문1.형성평가02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int odd = 0, even =0;
		while(true) {
			int num = sc.nextInt();	
			if(num % 2 == 0)odd++;
			else if(num % 2 != 0)even++;
			else if(num == 0)break;
			
		}
		System.out.println("odd: "+odd);
		System.out.println("even: "+even);

	}

}
