import java.util.*;
public class PrintInOrder{
	public static void main(String[] args){
		double[] num = new double[]{10, 7, 20, 556, 33, 999, 1};
		int[] rank =   new int[]{ 5, 6, 4,  2,   3,  1,   7};

		int[] iSearchSample = new int[]{-7, 0, 1, 3, 8, 12};

		Stack<Integer> s = new Stack<Integer>();
		s.push(3);
		s.push(8);
		s.push(4);
		s.push(8);
		s.push(5);
		s.push(4);

		removeMax(s, Integer.MIN_VALUE);

		System.out.println(s);

		System.out.println(iSearch(iSearchSample, 0, iSearchSample.length-1));

		printInOrder(num, rank);
	}
	public static void printInOrder(double[] num, int[] rank){
		HashMap<Integer, Double> map = new HashMap<Integer, Double>();
		
		for(int i = 0; i<rank.length; i++){
			map.put(rank[i], num[i]);
		}

		for(int i = 1; i<=rank.length; i++){
			System.out.println(map.get(i));
		}
	}

	public static LinkedList<Integer> mergeSortedQueues(LinkedList<Integer> queue1, LinkedList<Integer> queue2){
		LinkedList<Integer> q = new LinkedList<Integer>();

		while(!queue1.isEmpty() && !queue2.isEmpty()){
			if(queue1.peek() < queue2.peek()){
				q.offer(queue1.poll());
			}else{
				q.offer(queue2.poll());
			}
		}

		while(!queue1.isEmpty()){
			q.offer(queue1.poll());
		}

		while(!queue2.isEmpty()){
			q.offer(queue2.poll());
		}

		return q;
	}

	public static Integer removeMax(Stack<Integer> s, Integer currMax){
		if(s.isEmpty()){ 
			return currMax;	
		}else{
			Integer top = s.pop();
			Integer theCurrMax = removeMax(s, top > currMax? top: currMax);

			if(top != theCurrMax){
				s.push(top);
			}

			return theCurrMax;
		}
		
	}

	public static int iSearch(int[] ints, int leftPt, int rightPt){
		int midPt = (leftPt + rightPt)/2;
		if(ints[midPt] == midPt){
			return midPt;
		}else if( leftPt > rightPt){
			return -1;
		}else if( ints[midPt] > midPt){
			return iSearch(ints, leftPt, midPt-1);
		}else{
			return iSearch(ints, midPt+1, rightPt);
		}

	}
}
