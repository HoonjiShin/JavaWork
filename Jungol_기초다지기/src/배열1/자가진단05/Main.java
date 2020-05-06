package 배열1.자가진단05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int class1,class2;
		double sum=0;
		double[] array = {85.6, 79.5, 83.1, 80.0, 78.2, 75.0 };
		class1 = sc.nextInt();
		class2 = sc.nextInt();
		double score1 = array[class1-1];
		double score2 = array[class2-1];
		
		sum =score1+score2;
		System.out.println(sum);
		
	}

}
