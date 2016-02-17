/*
 *	Name		: Wong Kang Fei
 *	Matric no.	: A0138862W
 *
 */

import java.util.*;

/*
 *	Key observation to take note:
 *	1. the smallest odd super X is 3x3, and even super X is 4,4
 *	2. a bigger super X always contain smaller super X.
 *	
 *	The general idea of the algorithm is to check for the existence of smallest super X.
 *	If smallest super X exist, then take that it as reference, try to check for a bigger super X by growing it's boundary.
 *
 *  Process flow:
 *	1. check if sizeOfSuperX is odd/even (has different mathematical formula for 2D array index)
 *	2. check for outermost X'es (top left, top right, bottom left, bottom right) are X'es
 *	3. +1 to the total super X if step-2 is true. otherwise proceed to next 2D array index.
 *	4. grow sizeOfSuperX by 1.
 *	5. restart step-1.
 *
 */
public class FindX{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		final int MAX_ROW = sc.nextInt();
		final int MAX_COL = sc.nextInt();

		char[][] map = new char[MAX_ROW][MAX_COL];

		sc.nextLine();  // Consume newline left-over

		for(int i=0; i<MAX_ROW; i++){
			map[i] = sc.nextLine().toCharArray();
		}

		int totalSuperX = 0;

		for(int i=0; i<MAX_ROW; i++){
			for(int j=0; j<MAX_COL; j++){
				// initialize smallest possible super X
				int sizeOfOddSuperX = 3;
				int sizeOfEvenSuperX = 4;
				
				while(isOddSuperXAt(i, j, sizeOfOddSuperX, map)){
					totalSuperX++;
					sizeOfOddSuperX+=2;
				}
				
				while(isEvenSuperXAt(i, j, sizeOfEvenSuperX, map)){
					totalSuperX++;
					sizeOfEvenSuperX+=2;
				}
			}
		}

		System.out.println(totalSuperX);
	}

	private static boolean isOddSuperXAt(int row, int col, int sizeOfSuperX, char[][] map){
		
		boolean isCenterX;
		boolean isTopLeftX;
		boolean isTopRightX;
		boolean isBottomLeftX;
		boolean isBottomRightX;

		try{
			isCenterX = map[row][col] == 'X';

			// early return if the center is not an X
			if(!isCenterX){ return false; } 
		
			// the index offset from center to the outer most X
			int centerOffset = sizeOfSuperX/2;

			isTopLeftX = map[row-centerOffset][col-centerOffset] == 'X';
			isTopRightX = map[row-centerOffset][col+centerOffset] == 'X';
			isBottomLeftX = map[row+centerOffset][col-centerOffset] == 'X';
			isBottomRightX = map[row+centerOffset][col+centerOffset] == 'X';
		}catch(ArrayIndexOutOfBoundsException ex){
			return false;
		}

		return isCenterX &&
			isTopLeftX &&
			isTopRightX &&
			isBottomLeftX &&
			isBottomRightX;
	}

	private static boolean isEvenSuperXAt(int row, int col, int sizeOfSuperX, char[][] map){
		boolean isCenterX;
		boolean isTopLeftX;
		boolean isTopRightX;
		boolean isBottomLeftX;
		boolean isBottomRightX;
		
		try{
			// for an even super X, the center is a 2x2 X'es
			isCenterX = map[row][col] == 'X' &&
						map[row][col+1] == 'X' &&
						map[row+1][col] == 'X' &&
						map[row+1][col+1] == 'X';

			int centerOffset = sizeOfSuperX/2-1;

			// assume to take the top left X as reference, there will be a margin offset of 1 to top right, bottom left, bottom right X'es
			int marginOffset = 1;

			isTopLeftX = map[row-centerOffset][col-centerOffset] == 'X';
			isTopRightX = map[row-centerOffset][col+centerOffset+marginOffset] == 'X';
			isBottomLeftX = map[row+centerOffset+marginOffset][col-centerOffset] == 'X';
			isBottomRightX = map[row+centerOffset+marginOffset][col+centerOffset+marginOffset] == 'X';

		}catch(ArrayIndexOutOfBoundsException ex){
			return false;	
		}
		
		return isCenterX &&
			isTopLeftX &&
			isTopRightX &&
			isBottomLeftX &&
			isBottomRightX;
	}
}
