package 배열1.자가진단09;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr= new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
			if(arr[i]>arr[i+1]) {
				int temp = arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
			}
			System.out.print(arr[i]);
		}
	}
}
