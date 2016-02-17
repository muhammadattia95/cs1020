/*
 * Name		: Wong Kang Fei
 * Matric No.		: A0138862W
 * Plab Account	: plab0196
 */

import java.util.*;

public class Queens {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// input: size of chessboard
		final int size = sc.nextInt();

		sc.nextLine(); // consume line feed

		// partial initialize map with row size only
		int[][] map = new int[size][];

		for(int i = 0; i< size; i++){
			// numberStringToIntArray converts string of 1&0 to int[]
			// set it to map[i]
			// this will initialize the columns
			map[i] = numberStringToIntArray(sc.nextLine().trim());
		}
		/*
		   int[][] sampleMap = {
		   {1, 0, 0},
		   {0, 1, 0},
		   {0, 0, 0}
		   };

		   int [][] sampleMap2 = {
		   {1, 0, 0, 0, 0,},
		   {0, 0, 0, 0, 0,},
		   {1, 0, 1, 0, 0,},
		   {0, 0, 0, 0, 0,},
		   {0, 1, 0, 0, 0,},
		   };

		   System.out.println(hasConflict(sampleMap, 1,1, 1));
		   System.out.println(hasConflict(sampleMap2, 2,2, 2));
		 */
		//prettyPrint(map);

		boolean isValid = true;

		// chessboard row
		for(int i=0; i< size; i++){
			//chessboard column
			for(int j = 0; j< size; j++){

				// given chesboard index fixed at [i,j], iteratively grow size of k around the 
given index
				// check for outermost 8 points at 8 direction (see hasNoConflict() method)
				for( int k = 1; k< size; k++){

					try{
						// if the given index value is 1 and the map has no conflict
						if(map[i][j] == 1 && !hasNoConflict(map, i, j, k)){
							// set validity to false
							isValid = false;
							//System.out.println("falsy at "+ i 
+":"+j+":"+k+":"+map[i][j]);
							// break out the loop
							break;
						}
					}catch(ArrayIndexOutOfBoundsException ex){
						// do nothing
						// do not consider when k grows out of array index bound
						// continue next iteration
						//System.out.println("out of bounds at "+i+":"+j+":"+k);
					}
					if(!isValid){
						// early break out of the inner loop (k) when validity is 
false
						break;
					}
				}
				if(!isValid){
					// early break out of the inner loop (j) when validity is false
					break;
				}
			}
			if(!isValid){
				// early break out of the inner loop (i) when validity is false
				break;

			}
		}

		// output
		System.out.println(isValid? "VALID" : "INVALID");
	}
	
	// pre: must be a 2D array of type int
	// input: int arr
	// to pretty print a 2d array, for checking/debugging user input 
	private static void prettyPrint(int[][] arr){
		System.out.println("====prettyPrint====");
		for(int i = 0; i< arr.length; i++){
			for(int j =0; j< arr.length; j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

	// pre: the string consist only of 1 & 0, advisable to use trim() to remove any trailing spaces
	// input: string of 1&0
	// convert string of 1&0 to int[]
	// eg: "100001" => {1,0,0,0,0,1}
	private static int[] numberStringToIntArray(String numberString){
		String[] numberStringArray = numberString.split(" ");
		int[] intArray = new int[numberStringArray.length];

		for(int i =0; i< numberStringArray.length; i++){
			intArray[i] = Integer.parseInt(numberStringArray[i]);
		}
		return intArray;
	}

	/* 
	   pre: i_pos, j_pos must be positive integer inclusive of zero, offset must be >=1
	   input:	int[][] map: 2d int array of 1&0
	   i_pos: given row index	
	   j_pos: given colomn index
	   offset: the offset away from given index, grow from 1

	   to check if the queen at given index has conflict with other queens.
	 */
	private static boolean hasNoConflict(int[][] map, int i_pos, int j_pos, int offset) throws 
ArrayIndexOutOfBoundsException{
		return map[i_pos][j_pos] == 1 && // center
			map[i_pos-offset][j_pos-offset] == 0 && // top left
			map[i_pos-offset][j_pos] == 0 && // top
			map[i_pos-offset][j_pos+offset] == 0 && // top right
			map[i_pos][j_pos+offset] == 0 && // right
			map[i_pos+offset][j_pos+offset] == 0 && // bottom right
			map[i_pos+offset][j_pos] == 0 && //bottom
			map[i_pos+offset][j_pos-offset] == 0 && // bottom left
			map[i_pos][j_pos-offset] == 0; // left
	}



}

