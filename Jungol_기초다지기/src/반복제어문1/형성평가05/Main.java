package 반복제어문1.형성평가05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double base, height;
		String choice ;
		while(true) {
			
			System.out.print("Base = ");
			base = sc.nextDouble();
			System.out.print("Height = ");
			height = sc.nextDouble();
			System.out.printf("Triangle width = %.1f\n", (base*height) / 2.0f);
			System.out.print("Continue? ");
			choice = sc.next();
			
			if(!choice.equals("y") && !choice.equals("Y"))
				break;
			
		}

	}

}
