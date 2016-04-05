/**
 *	name	  : Wong Kang Fei
 *	matric no.: A0138862W
 */

import java.util.*;

class Result {
    // declare the member field
	private int[] nums;

    // declare the constructor
	public Result( int[] nums){
		this.nums = nums;
	}
	
	public String solveMaxAndMin(){
		// max1 >= max2 >= max3
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		int max3 = Integer.MIN_VALUE;

		// min1 <= min2 <= min3
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		int min3 = Integer.MAX_VALUE;

		for( int i = 0; i<nums.length; i++){
			if(nums[i] > max1){
				max3 = max2;
				max2 = max1;
				max1 = nums[i];
			}else if( nums[i] > max2){
				max3 = max2;
				max2 = nums[i];
			}else if(nums[i] > max3){
				max3 = nums[i];
			}

			if(nums[i] < min1){
				min3 = min2;
				min2 = min1;
				min1 = nums[i];
			}else if( nums[i] < min2){
				min3 = min2;
				min2 = nums[i];
			}else if( nums[i] < min3){
				min3 = nums[i];
			}
		}

		return Math.min(min1*min2*min3, min1*max1*max2)+
			" " +
			Math.max(max1*max2*max3, max1*min1*min2);


	}

}

public class Triplet {

	public static void main(String[] args) {

		// declare the necessary variables
		Scanner sc = new Scanner(System.in);

		// declare a Scanner object to read input
		int numCount = sc.nextInt();

		int[] nums = new int[numCount];

		// read input and process them accordingly
		for( int i = 0; i<numCount; i++){
			nums[i] = sc.nextInt();
		}
		
		Result result = new Result(nums);

		System.out.println(result.solveMaxAndMin());
	}
}
