// This program processes a list of "add" and "query" operations
// on a queue:
//    Add <a list of integers>: to enqueue integers into queue
//    Query <a list of integers>: to check if integers are present
//                                in queue by dequeueing elements
import java.util.*;

public class QueueExercise {
	public static void main(String [] args) throws NoSuchElementException {

		QueueLL <Integer> queue = new QueueLL <Integer> ();
		Scanner sc = new Scanner(System.in);
		String op;

		while (sc.hasNext()) {
			op = sc.next();

			if (op.equals("Add")) {
				while(sc.hasNextInt()){
					queue.offer(sc.nextInt());
				}
				System.out.println("Items added: "+queue);
			}else if (op.equals("Query")) {
				boolean hasFound = false;
				while(sc.hasNextInt()){
					int num = sc.nextInt();
					hasFound = findAndPoll(queue, num);
				}

				if(!hasFound){
					System.out.println("Query not met: " + queue);
				}else{
					System.out.println("Query met: " + queue);
				}
				
			}
		}
	}

	// You may write additional method(s) to make your program more modular
	private static boolean findAndPoll(QueueLL<Integer> queue, int num){
		if(queue.isEmpty()){
			return false;
		}else if(queue.poll() == num){
			return true;
		}else{
			return findAndPoll(queue, num);
		}
	}

}

