import java.util.*;

/******** Class definition for QueueLL ********/
class QueueLL <E> {
	private TailedLinkedList <E> list;

	public QueueLL() { 
		list = new TailedLinkedList <E> (); 
	}

	public boolean isEmpty() { 
		return list.isEmpty(); 
	}

	// Add element to end of queue (also call enqueue)
	public boolean offer(E o) { 
		list.addLast(o); 
		return true;
	}

	// Check first (front) element of queue without removing it
	public E peek() {
		if (isEmpty()) 
			return null;
		return list.getFirst();
	}

	// Remove element at front of queue (also call dequeue)
	public E poll() {
		E obj = peek();
		if (!isEmpty()) 
			list.removeFirst();
		return obj;
	}

	// Return string representation of a queue.
	public String toString() {
		return list.toString();
	}
}

