/*
 *	Author: Wong Kang Fei
 *	Mat No: A0138862W
 *
 * */
import java.util.*;
import java.text.*;


public class Statistics{
	public static void main(String[] args){
		int[] arr = readArray();
		//printArray(arr);
		
		DecimalFormat df = new DecimalFormat("0.000");
		System.out.println("Mean = " + df.format(computeMean(arr)));
		System.out.println("Standard deviation = " + df.format(computeStdDev(arr)));


	}

	private static int[] readArray(){
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter size of array: ");
		final int SIZE = sc.nextInt();

		System.out.println("Enter "+SIZE+(SIZE==1? " value: ":" values: "));
		int[] arr = new int[SIZE];
		for(int i =0; i<SIZE;i++){
			arr[i] = sc.nextInt();
		}
		
		return arr;
	}

	private static double computeMean(int[] arr){
		double total = 0;
		for(int i =0; i<arr.length;i++){
			total = total+arr[i];
		}

		return total/arr.length;
	}

	private static double computeStdDev(int[] arr){
		double total = 0;
		double mean = computeMean(arr);
		for(int i =0; i<arr.length; i++){
			total = total + Math.pow(arr[i] - mean, 2);
		}

		//System.out.println(total);
		//System.out.println(mean);

		return Math.sqrt(total/arr.length);
	}

	public static void printArray(int[] arr) {
		for (int element: arr) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
}
