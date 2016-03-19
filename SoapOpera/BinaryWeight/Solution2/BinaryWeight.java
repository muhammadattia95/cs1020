import java.util.*;

public class BinaryWeight{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(true){
			int num = sc.nextInt();
/*
			System.out.println("isPowerOfTwo: " + isPowerOfTwo(num));
			System.out.println("isPowerOfTwoMinusOne: " + isPowerOfTwoMinusOne(num)); 
			System.out.println("isComposedOfLeadingOnesAndTrailingZeros: " + isComposedOfLeadingOnesAndTrailingZeros(num));
			System.out.println("removeTrailingZeros: "+removeTrailingZeros(num));
			System.out.println("lowestOneBit: " + Integer.lowestOneBit(num));
*/
			if(isPowerOfTwo(num)){
				System.out.println(num << 1);
			}else if(isPowerOfTwoMinusOne(num)){
				System.out.println( (Integer.highestOneBit(num << 1)) + 
						removeTrailingZeros(num - Integer.highestOneBit(num)));
			}else if(isComposedOfLeadingOnesAndTrailingZeros(num)){
				System.out.println((Integer.highestOneBit(num) << 1) + 
					removeTrailingZeros(num - Integer.highestOneBit(num)));
			}else{
				// search for right most "01"
				//
				System.out.println(flipAndRightShift(num, -1, 0, num, 0, 0));
			}
		}
	}

	private static boolean isPowerOfTwo(int num){
		return (num & (num-1)) == 0;
	}

	private static boolean isPowerOfTwoMinusOne(int num){
		return isPowerOfTwo(num+1);
	}

	private static boolean isComposedOfLeadingOnesAndTrailingZeros(int num){
		return isPowerOfTwoMinusOne(removeTrailingZeros(num));
	}

	private static int removeTrailingZeros(int num){
		if(Integer.lowestOneBit(num) == 1){
			return num;
		}else{
			return removeTrailingZeros(num >> 1);
		}
	}

	private static int flipAndRightShift(int num, int prevLSB, int factorSoFar, int originalNum, int bitMask, int sumOfPrevLSBs){
		int currLSB = getLSB(num);
		if(prevLSB == 1 && currLSB == 0){
			/* 
			 * eg: 110111000
			 *
			 * 1. calculate flip factor: 110111000 + 100000 (flip factor) = 111011000 
			 * 2. right shift all bits before the position of '01' pattern: 111011000 - 11000 + 11 = 111000011
			 * */
			return originalNum + factorSoFar - sumOfPrevLSBs + removeTrailingZeros(sumOfPrevLSBs);
		}else{
			return flipAndRightShift(
					num >> 1, // left shift num
					currLSB, // set currLSB as prevLSB for next recursive call
					factorSoFar == 0? 1: (factorSoFar << 1), // flipping factor
					originalNum, // original num (for final calculation)
					(bitMask << 1)+1, // bit mask of 1s
					(originalNum & bitMask));  // apply AND operation on the original number to copy all digits given current bitmask
		}
	}
	
	private static int getLSB(int num){
	   return num & 1;
	}
	
}
