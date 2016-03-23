import java.util.*;

/********* Class definition for ListNode ********/
class ListNode <E> {
	/* data attributes */
	private E element;
	private ListNode <E> next;

	/* constructors */
	public ListNode(E element) { 
		this(element, null); 
	}

	public ListNode(E element, ListNode <E> next) { 
		this.element = element; 
		this.next = next; 
	}

	public ListNode <E> getNext() {
		return this.next;
	}

	public E getElement() {
		return this.element;
	}

	public void setNext(ListNode <E> next) {
		this.next = next;
	}
}

/********* Class definition for TailedLinkedList ********/
class TailedLinkedList <E> {

	// Data attributes
	private ListNode <E> head = null;
	private ListNode <E> tail = null;
	private int numNodes = 0;

	// Return true if list is empty; otherwise return false.
	public boolean isEmpty() { 
		return (numNodes == 0); 
	}

	// Return number of nodes in list.
	public int size() { 
		return numNodes; 
	}

	// Return value in the first node.
	public E getFirst() throws NoSuchElementException {
		if (head == null) 
			throw new NoSuchElementException("List is empty!");
		else 
			return head.getElement();
	}

	// Return true if list contains item, otherwise return false.
	public boolean contains(E item) {
		for (ListNode <E> curr = head; curr != null; curr = curr.getNext())
			if (curr.getElement().equals(item)) 
				return true;

		return false;
	}

	// Add item to front of list.
	public void addFirst(E item) {
		head = new ListNode <E> (item, head);
		numNodes++;
		if (numNodes == 1) 
			tail = head;
	}

	// Return string representation of list.
	public String toString() {
		ListNode <E> curr = head;
		String str = "[";

		if (curr != null) {
			str += curr.getElement();
			curr = curr.getNext();
			while (curr != null) {
				str += ", " + curr.getElement();
				curr = curr.getNext();	
			}
		}
		str += "]";
		return str;
	}

	// Return reference to first node of list.
	public ListNode <E> getHead() { 
		return head; 
	}

	// Return reference to last node of list.
	public ListNode <E> getTail() {
		return tail;
	}

	// Add item to end of list.
	public void addLast(E item) {
		if (head != null) {    
			tail.setNext(new ListNode <E> (item));
			tail = tail.getNext();
		} else {
			tail = new ListNode <E> (item);
			head = tail;
		}
		numNodes++;
	}

	// Add item after node referenced by current.
	public void addAfter(ListNode <E> current, E item) {
		if (current != null) {
			current.setNext(new ListNode <E> (item, current.getNext()));
			if (current == tail)  
				tail = current.getNext();
		} else { // add to the front of the list
			head = new ListNode <E> (item, head);
			if (tail == null) 
				tail = head;
		}
		numNodes++;
	}

	// Remove node after node referenced by current.
	public E removeAfter(ListNode <E> current) throws NoSuchElementException {
		E temp;
		if (current != null) {  
			ListNode <E> nextPtr = current.getNext();
			if (nextPtr != null) {
				temp = nextPtr.getElement();
				current.setNext(nextPtr.getNext());
				numNodes--;
				if (nextPtr.getNext() == null) // last node is removed
					tail = current;
				return temp;
			} 
			else 
				throw new NoSuchElementException("No next node to remove");

		} else { // if current is null, we want to remove head
			if (head != null) {
				temp = head.getElement();
				head = head.getNext(); 
				numNodes--;
				if (head == null)
					tail = null;
				return temp;
			} 
			else 
				throw new NoSuchElementException("No next node to remove");
		}
	}

	// Remove first node of list.
	public E removeFirst() throws NoSuchElementException {
		return removeAfter(null);
	}

}

