/**
 *	name	  : Wong Kang Fei
 *	matric no.: A0138862W
 */

import java.util.*;

public class Stick {

	private int targetLength;
	private int[] stickLengths;

	public Stick(int targetLength, int[] stickLengths){
		this.targetLength = targetLength;
		this.stickLengths = stickLengths;
	}
	
	public static void main(String[] args) {
		// declare the necessary variables
		Scanner sc = new Scanner(System.in);

		// declare a Scanner object to read input
		int stickCount = sc.nextInt();
		int targetLength = sc.nextInt();

		int[] stickLengths = new int[stickCount];

		// read input and process them accordingly
		for(int i=0; i < stickCount; i++){
			stickLengths[i] = sc.nextInt();
		}

		Stick stick = new Stick(targetLength, stickLengths);
		System.out.println(stick.solve());
	}

	public int solve(){
		int stickCount = solve(0, 0, 1);

		return stickCount == 999? -1: stickCount;
	}

	public int solve(int total, int index, int stickCount){
		if(index >= stickLengths.length){
			return 999; // not possible
		}

		int totalChosen = total + stickLengths[index];
		int totalNotChosen = total;

		if(totalChosen == targetLength){
			return stickCount;
		}else{
			int pathChosen = solve(totalChosen, index+1, stickCount+1);
			int pathNotChosen = solve(totalNotChosen, index+1, stickCount);

			return Math.min(pathChosen, pathNotChosen);
		}
	}


}
