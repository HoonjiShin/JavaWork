package 반복제어문1.자가진단06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("1. Korea \n2. USA \n3. Japan \n4. China \nnumber? ");
			int num = sc.nextInt();
			System.out.println();
			if(num == 1) {
				System.out.println("Seoul");
			}else if(num == 2) {
				System.out.println("Washington");
			}else if(num == 3) {
				System.out.println("Tokyo");
			}else if(num == 4) {
				System.out.println("Beijing");
			}else{
				System.out.println("none");
				break;
			}
			System.out.println();
		}
	}

}
