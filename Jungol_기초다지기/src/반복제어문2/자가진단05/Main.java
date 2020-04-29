package 반복제어문2.자가진단05;

import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {    
	   Scanner sc = new Scanner(System.in);
	   int num, multi3=0, multi5=0;
	   for(int i=0;i<10;i++) {
		   num = sc.nextInt();
		   if(num % 3 ==0 )   multi3++;
		   if(num % 5 == 0)   multi5++;
	   }
	   System.out.println("Multiples of 3 : "+multi3);
	   System.out.println("Multiples of 5 : "+multi5);

	 }
	}