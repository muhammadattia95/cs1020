/**
* Name: Wong Kang Fei
* Matric Number: A0138862W
*/

import java.util.*;

public class Swing {

	private int[] trees;

    public static void main(String[] args) {
        //implement your main method here
		
		Scanner sc = new Scanner(System.in);

		int treeCount = sc.nextInt();

		sc.nextLine(); // consume line feed

		int[] theTrees = new int[treeCount];

		for(int i=0; i<treeCount; i++){
			theTrees[i] = sc.nextInt();
		}

		sc.nextLine();

		Swing swing = new Swing(theTrees);

		System.out.println(swing.calcPairCount());

    }

	public Swing(int[] trees){
		this.trees = trees;
	}

	private int calcPairCount(){
		int result = 0;
		Stack<Integer> s = new Stack<Integer>();
		//System.out.println(s);

		for(int i = 0; i< trees.length; i++){
			//System.out.println("SSS: "+trees[0]);
			// push the first tree
			s.push(trees[i]);

			// start tracing second tree...
			for( int j = i+1; j< trees.length; j++){
				if(trees[j] < s.peek()){
					// if the subsequent tree is less than the on on top of the stack
					// push it to the stack and inc result by 1
					s.push(trees[j]);
					result++;
					System.out.println(result+": "+s);
				}else{
					// if the subsequent tree is equals or more than the top of the stack
					// push it to the stack and inc result by 1
					s.push(trees[j]);
					result++;
					System.out.println(result+": "+s);

					// empty the stack
					while(!s.isEmpty()){
						s.pop();
					}

					// early break since the monkey cannot traverse to the next tree
					break;
				}
			}
			System.out.println("=====");
		}

		return result;
	}

}
