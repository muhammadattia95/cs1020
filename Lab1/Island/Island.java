/*
Author: Wong Kang Fei
Mat No: A0138862W
*/
import java.util.*;

public class Island{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		final int MAX_ROW = sc.nextInt();
		final int MAX_COL = sc.nextInt();

		sc.nextLine(); // consume line feed
		
		// initialize a sentinel map with zeroes
		int[][] sentinelMap = new int[MAX_ROW+2][MAX_COL+2];

		// base on user inputs, fill in the sentinel map with data
		// ignore sentinel index
		for(int i=0;i<MAX_ROW;i++){
			// original map begins at index (1,1), without sentinels boundary indexes, that's why i+1
			sentinelMap[i+1] = numberStringToIntArray(
					wrapSentinel(sc.nextLine().trim(), "0"));
		}
		
		//prettyPrint2DIntArray(sentinelMap);
		/*
		int[][] sampleMap = {
			{0,0,0,0,0},
			{0,1,1,1,0},
			{0,1,1,1,0},
			{0,1,1,1,0},
			{0,0,0,0,1},
			{0,0,0,0,1}
		};
		*/

		//System.out.println(calcIslandWidth(sentinelMap, 2, 2));
		//System.out.println(calcIslandHeight(sentinelMap, 2,2));
		
		final int MAX_ROW_SENTINEL_MAP = MAX_ROW+2;
		final int MAX_COL_SENTINEL_MAP = MAX_COL+2;

		int totalIsland = 0;

		for(int i=1; i<MAX_ROW_SENTINEL_MAP;i++){
			for(int j=1; j<MAX_COL_SENTINEL_MAP; j++){
				if(isTopLeftCornerOfAnIsland(sentinelMap, i, j)){
					int islandWidth = calcIslandWidth(sentinelMap, i, j);
					int islandHeight = calcIslandHeight(sentinelMap, i, j);
					
					//System.out.println(islandWidth);
					//System.out.println(islandHeight);
					sentinelMap = removeIsland(sentinelMap, i, j, islandWidth, islandHeight);
					
					//prettyPrint2DIntArray(sentinelMap);

					totalIsland++;
				}
			}
		}

		System.out.println(totalIsland);
	}

	// setting a sub island of WxH in a map to zeroes
	private static int[][] removeIsland(int[][] map, int i_pos, int j_pos, int islandWidth, int islandHeight){
		for(int i = 0; i<islandHeight; i++){
			for(int j = 0; j<islandWidth; j++){
				map[i+i_pos][j+j_pos] = 0;
				//System.out.println((i+i_pos) +":"+(j+j_pos));
			}
		}

		return map;
	}

	// calculate an island width
	private static int calcIslandWidth(int[][] map, int i_pos, int j_pos){
		int width = 0;
		for(int j = j_pos; j<map[i_pos].length; j++){
			if(map[i_pos][j] == 1){
				width++;
			}else{
				break;
			}
		}
		return width;
	}

	// calculate an island height
	private static int calcIslandHeight(int[][] map, int i_pos, int j_pos){
		int height = 0;
		for(int i = i_pos; i<map.length; i++){
			if(map[i][j_pos] == 1){
				height++;
			}else{
				break;
			}
		}
	
		return height;

	}

	// check if an island exist
	private static boolean isTopLeftCornerOfAnIsland(int[][] map, int i, int j){
		return map[i][j] == 1 &&
			map[i-1][j] == 0 &&
			map[i][j-1] == 0;
	}

	// prepend and append a string with sentinel value
	// to be used in conjuction with numberStringToIntArray
	private static String wrapSentinel(String line, String sentinel){
		return sentinel+" "+line+" "+sentinel;
	}

	// convert a number string to int array
	// to be used in conjunction with wrapSentinel
	private static int[] numberStringToIntArray(String numberString){
		String[] numberStringArray = numberString.split(" ");
		int[] intArray = new int[numberStringArray.length];

		for(int i = 0; i< numberStringArray.length; i++){
			intArray[i] = Integer.parseInt(numberStringArray[i]);
		}

		return intArray;
	}

	// for pretty print a 2D array
	private static void prettyPrint2DIntArray(int[][] intArray){		
		System.out.println("=====prettyPrint2DIntArray=====");
	    for(int i=0; i<intArray.length; i++){
	        for(int j=0; j<intArray[i].length; j++){
	            System.out.print(intArray[i][j] + " ");
	        }
	        System.out.println("");
	    }
		System.out.println("=====prettyPrint2DIntArray=====");
	}

	/*
	private static int[][] toSentinelMap(int[][] map){
		final int MAX_ROW = map.length;
		final int MAX_COL = map[].length;

		int[][] sentinelMap = new int[MAX_ROW+2][MAX_COL+2];

		for(int i = 0; i<MAX_ROW; i++){
			for(int j = 0; j<MAX_COL; j++){
				if(i==0){
					
				}
			}
		}
	}
	*/
}
