package 배열1.자가진단03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = new String[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.next();
		}
		System.out.print(arr[0]+" "+arr[3]+" "+arr[6]);
		
	}

}
