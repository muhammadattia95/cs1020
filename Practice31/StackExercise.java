// This program processes a list of "add" and "query" operations
// on a stack:
//    Add <a list of integers>: to push integers into stack
//    Query <a list of integers>: to check if integers are present
//                                in stack by popping elements

import java.util.*;

public class StackExercise {
	public static void main(String [] args) throws NoSuchElementException {

		StackLL <Integer> stack = new StackLL <Integer> ();
		Scanner sc = new Scanner(System.in);
		String op;

		while (sc.hasNext()) {
			op = sc.next();

			if (op.equals("Add")) {
				// Fill in the code 
				while(sc.hasNextInt()){
					stack.push(sc.nextInt());
				}
				System.out.println("Items added: " + stack);
			}else if (op.equals("Query")) {
				// Fill in the code 

				while(sc.hasNextInt()){
					int target = sc.nextInt();

					findAndPop(stack, target);
				}

				if(stack.isEmpty()){
					System.out.println("Query not met: " + stack);
				}else{
					System.out.println("Query met: " + stack);
				}
			
				sc.nextLine();
			}
		}
	}

	// You may write additional method(s) to make your program more modular
	private static void findAndPop(StackLL<Integer> stack, int num){
		if(stack.isEmpty()){
			return;
		}else if(stack.pop() == num){
			return;
		}else{
			findAndPop(stack, num);
		}
	}

}

