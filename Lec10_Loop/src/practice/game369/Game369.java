package practice.game369;

import java.util.Scanner;

public class Game369 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int n=1;
		int limit = sc.nextInt();
		while(n <= limit) {
			if (n % 10 == 3 || n % 10 == 6 || n % 10 == 9 || n % 30 == 0
					||n % 60 == 0 ||n % 90 == 0) {
				if (n % 10 == 0) {
					System.out.print("*" + "\t");
					System.out.println();
				} else
					System.out.print("*"+"\t");
			n++;
			}else {
				if(n % 10 == 0) {
					System.out.print(n+"\t");
					System.out.println();
				}else
				System.out.print(n+"\t");
				n++;
			}
		}
		
	}

}
