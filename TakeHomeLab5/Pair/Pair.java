/**
 *  Name          : Wong Kang Fei
 *  Matric Number : A0138862W
 */

import java.util.*;

public class Pair {

	private int[] playerStrs;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int playerCount = sc.nextInt();

		sc.nextLine(); // consume line feed

		int[] playerStrs = new int[playerCount];

		for( int i = 0; i< playerCount; i++){
			playerStrs[i] = sc.nextInt();
		}

		System.out.println((new Pair(playerStrs)).solve());
	}

	public Pair(int[] playerStrs){
		this.playerStrs = playerStrs;
	}

	public int solve(){
		int result = 0;
		
		// index = str, val = pairsCount sums up to str/index
		int pairsCount[] = new int[9999];

		for(int i = 0; i < playerStrs.length; i++){
			for( int j = i; j < playerStrs.length; j++){
				if( i == j){
					continue;
				}

				int sum = playerStrs[i] + playerStrs[j];
				pairsCount[sum] = pairsCount[sum]+1;
			}
		}

		for(int i = 0; i < pairsCount.length; i++){
			if( pairsCount[i] > 1){
				result += nChooseTwo(pairsCount[i])*8;
			}
		}

		return result;
	}

	public int nChooseTwo(int n){
		return (n*(n-1))/2;
	}
}
