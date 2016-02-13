// RowColSums.java
// // To compute the row and column sums of a 2D array.
import java.util.*;
//
public class RowColSums {
	private static int ROW_COUNT = 0;
	private static int COL_COUNT = 0;
	public static void main(String[] args) {
		//
		// 			// code to read values into 2D array called 'array2D'
		//
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of rows and columns: ");
		ROW_COUNT = sc.nextInt();
		COL_COUNT = sc.nextInt();

		int[][] array2D = new int[ROW_COUNT][COL_COUNT];

		sc.nextLine(); // consume line feed

		System.out.println("Enter values for 2D array:");
		for(int i=0; i<ROW_COUNT; i++){
			for(int j = 0; j<COL_COUNT; j++){
				array2D[i][j] = sc.nextInt();
			}
		}

		sc.nextLine();

		int[] rowSums = computeRowSums(array2D);
		System.out.print("Row sums: ");
		System.out.println(Arrays.toString(rowSums));

		int[] colSums = computeColSums(array2D);
		System.out.print("Column sums: ");
		System.out.println(Arrays.toString(colSums));
	}

	private static int[] computeRowSums(int[][] arr){
		int[] rowSums = new int[ROW_COUNT];
		for(int i=0; i<ROW_COUNT;i++){
			int rowSum = 0;
			for(int j=0; j<COL_COUNT;j++){
				rowSum += arr[i][j];
			}
			rowSums[i] = rowSum;
		}

		return rowSums;
	}

	private static int[] computeColSums(int[][] arr){
		int[] colSums = new int[COL_COUNT];

		for(int i=0; i<ROW_COUNT; i++){
			for(int j=0;j<COL_COUNT; j++){
				colSums[j] += arr[i][j];
			}
		}

		return colSums;
	}
	//
}
