package 반복제어문3.자가진단05;

import java.util.*;

public class Main {
 public static void main(String[] args) {    
  int n;
     Scanner sc = new Scanner(System.in);
     n = sc.nextInt();
     char tmp ='A';
     for(int i=0;i<n;i++){
         for(int j=1;j<=n-i;j++){
          System.out.print(tmp);
          tmp++;
         }
         System.out.println();
     }
 }
}