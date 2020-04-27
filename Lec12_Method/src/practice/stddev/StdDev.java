package practice.stddev;

import java.util.Arrays;

public class StdDev {

	public static void main(String[] args) {

		int[] arr=new int[5];
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=((int)(Math.random()*100)+1);	
		}
		System.out.println(Arrays.toString(arr));		
		double avg = calcAvg(arr);
		System.out.println(avg);
		double variance = calcVariance(arr);
		System.out.println(variance);
		double sd = Math.sqrt(variance);
		System.out.println(sd);
		// 임의정수 5개로 초기화한 정수로
		// 평균, 분산, 표준편차 구하기

	} // end main
	

	/**
	 * 메소드 이름 : calcAvg
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 
	 * 주어진 배열의 '평균값' 리턴
	 */
	public static double calcAvg(int[] arr) {
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum +=arr[i];   
		}
		double avg = (double)sum / arr.length;
		return avg;
	}
	
	/**
	 * 메소드 이름 : calcVariance
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 
	 * 주어진 배열의 '분산값' 리턴
	 */
	public static double calcVariance(int[] arr) {
		double varian = 0;
		double sum2 =0;
		double avg = calcAvg(arr);
		for(int i=0;i<arr.length;i++) {
		sum2 += Math.pow((arr[i]-avg), 2);
		}
		varian = sum2/arr.length;
		return varian;
	}
	
	/**
	 * 메소드 이름 : calcStdDev
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 
	 * 주어진 배열의 '표준편차' 리턴
	 */
	
} // end class
