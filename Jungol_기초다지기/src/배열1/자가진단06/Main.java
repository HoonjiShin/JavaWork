package 배열1.자가진단06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array = new int[10] ;
		int min = 0;
		for (int i = 0; i < array.length; i++) {
			array[i]=sc.nextInt();
			if(array[i] > array[i+1]) {
				min = array[i+1];
			}else if(array[i] <= array[i+1]) {
				min = array[i];
			}
			System.out.println(min);
		}
	}

}
