package 반복제어문2.자가진단04;


import java.util.*;

public class Main {
 public static void main(String[] args) {    
     int sum = 0;
     Scanner sc = new Scanner(System.in);
     int num = sc.nextInt();
     for(;num <= 100; num++) sum+=num;
     System.out.println(sum);
 }
}