import java.util.*;

/******** Class definition for StackLL ********/
class StackLL <E> {
	private BasicLinkedList <E> list;

	public StackLL() {
		list = new BasicLinkedList <E> ();
	}

	public boolean isEmpty() { 
		return list.isEmpty(); 
	}

	// Check top of stack without removing it
	public E peek() throws EmptyStackException {
		try {
			return list.getFirst();
		} catch (NoSuchElementException e) {
			throw new EmptyStackException();
		}
	}

	// Remove element at top of stack
	public E pop() throws EmptyStackException {
		E obj = peek();
		list.removeFirst();
		return obj;
	}

	// Add element to top of stack
	public void push(E o) {
		list.addFirst(o);
	}

	// Return string representation of a stack
	// This is usually not done, but for this exercise we 
	// want a convenient way to see what the stack contains.
	public String toString() {
		ListNode <E> current = list.getHead();

		String s = "[";
		if (current != null) {
			s += current.getElement();
			current = current.getNext();
		}
		while (current != null) {
			s += ", " + current.getElement();
			current = current.getNext();
		}
		return s+"]";
	}
}

