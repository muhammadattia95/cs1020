// Q1
import java.util.Stack;

public class Stacxercise {
	
	public static int sum(Stack<Integer> stackInt) { 
		if(stackInt.isEmpty()){
			return 0;
		}else{
			Integer theInt = stackInt.pop();
			Integer result = theInt + sum(stackInt);
			stackInt.push(theInt);
			return result;
		}
	}
	
	public static void insert(Stack<Integer> stackInt, int val) {
		if(stackInt.isEmpty()){
			stackInt.push(val);
		}else if(val < stackInt.peek()){
			Integer theInt = stackInt.pop();
			insert(stackInt, val);
			stackInt.push(theInt);
		}else{
			stackInt.push(val);
		}
	}
	
	public static void sort(Stack<Integer> stackInt) {
		Integer theInt = stackInt.pop();
		
		if(stackInt.isEmpty()){
			insert(stackInt, theInt);
		}else{
			sort(stackInt);
			insert(stackInt, theInt);
		}
		
	}
	
	public static void main(String[] args) {
		Stack<Integer> objUnsorted = new Stack<Integer>();
		objUnsorted.push(10); objUnsorted.push(6); objUnsorted.push(2);
		objUnsorted.push(3); objUnsorted.push(4);
		System.out.println(sum(objUnsorted));
		
		Stack<Integer> objSorted = new Stack<Integer>();
		objSorted.push(1); objSorted.push(3);
		insert(objSorted, 4); insert(objSorted, 2); insert(objSorted, 0);
		System.out.println(objSorted);
		
		sort(objUnsorted);
		System.out.println(objUnsorted); // now sorted =P
	}
}
