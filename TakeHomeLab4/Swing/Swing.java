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
			s.push(trees[i]);
			for( int j = i+1; j< trees.length; j++){
				if(trees[j] < s.peek()){
					s.push(trees[j]);
					result++;
					System.out.println(result+": "+s);
				}else{
					s.push(trees[j]);
					result++;
					System.out.println(result+": "+s);
					while(!s.isEmpty()){
						s.pop();
					}
					break;
				}
			}
			System.out.println("=====");
		}

		return result;
	}

}
