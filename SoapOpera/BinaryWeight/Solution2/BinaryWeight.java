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
				System.out.println(num + getFlipFactor(num, -1, 0));
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

	private static int getFlipFactor(int num, int prevLSB, int factorSoFar){
		int currLSB = getLSB(num);
		if(prevLSB == 1 && currLSB == 0){
			return factorSoFar;
		}else{
			return getFlipFactor(num >> 1, currLSB, factorSoFar == 0? 1: (factorSoFar << 1));
		}
	}
	
	private static int getLSB(int num){
	   return num & 1;
	}
	
}
