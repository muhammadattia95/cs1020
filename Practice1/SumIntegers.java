/*
Author: Wong Kang Fei
Mat No: A0138862W
*/

import java.util.*;

public class SumIntegers{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter n: ");
		int n = sc.nextInt();
		int count = 1;
		int ans = 0;

		while(count<=n){
			ans+=count;
			count++;
		}

		System.out.println("Sum = " + ans);
	}
}
