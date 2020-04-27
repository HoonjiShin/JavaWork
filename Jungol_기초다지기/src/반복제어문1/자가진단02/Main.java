package 반복제어문1.자가진단02;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i =0 ;
		int sum =0;
		int num = sc.nextInt();
		while(i<=num) {
			sum+=i;
			i++;
		}
		System.out.println(sum);
		
		 }
		
	} // end main()