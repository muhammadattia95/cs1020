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

		sc.nextLine(); // consume line fedd

		Swing swing = new Swing(theTrees);

		System.out.println(swing.calcPairCount());

    }

	public Swing(int[] trees){
		this.trees = trees;
	}

	private int calcPairCount(){
		int result = 0;
		Stack<Integer> s = new Stack<Integer>();

		for(int i = 0; i< trees.length; i++){
			if(s.isEmpty()){
				s.push(trees[i]);
				continue;
			}else{
				while(!s.isEmpty() && s.peek() < trees[i]){
					/*
					 *	if it's not empty, we need to check if the next tree
					 *	is higher than the top of the stack
					 *
					 *	if so, we remove all descending trees except for the 
					 *	last one which is higher or equal height of the next tree
					 */
					
					// for each tree we pop, we increment counter, since these trees cannot
					// traverse further, we forget them
					result++;
					//System.out.println(result + ": "+ s);
					//s.pop();
					s.pop();
				}

				if(s.isEmpty()){
					// if the stack is empty, we push a new tree
					// no count at this phase because it doesn't form a pair
					s.push(trees[i]);
					continue;
				}else if(!s.isEmpty() && s.peek() > trees[i]){
					// next tree is shorter than the top of the stack
					// continue pushing
					// increment counter
					s.push(trees[i]);
					result++;
				}else if(s.peek() == trees[i]){
					// if the tree height is equal to the top of the stack
					// we do not push, only increment the counter
					result++;
				}
			}

			//System.out.println(result+": "+s);
		}

		return result;
	}

}
