package 반복제어문3.자가진단07;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int n;
	     Scanner sc = new Scanner(System.in);
	     n = sc.nextInt();
	     char a = 64;
	     int num =0 ;
	     for(int i =0;i<n;++i) {
	    	 for(int j =i;j<n;++j) {
	    		 System.out.printf("%d " ,num+=1);
	    	 }
	    	 for(int k=0;k<i+1;k++) {
	    		 System.out.printf("%c ",a+=1);
	    	 }
	    	 System.out.println();
	     }

	}

}
