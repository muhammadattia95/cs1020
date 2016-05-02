import java.util.*;

/********** Class definition for ListNode *********/
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

/********** Class definition for BasicLinkedList ********/
class BasicLinkedList <E> {

	// Data attributes
	private ListNode <E> head = null;
	private int numNodes = 0;

	// Return true if list is empty; otherwise return false.
	public boolean isEmpty() { 
		return (numNodes == 0); 
	}

	// Return number of nodes in list.
	public int size() { 
		return numNodes; 
	}

	// Return reference to first node.
	public ListNode <E> getHead() { 
		return head; 
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
	}

	// Remove first node of list.
	public E removeFirst() throws NoSuchElementException {
		if (head == null) 
			throw new NoSuchElementException("can't remove from an empty list");
		else { 
			ListNode <E> first = head;
			head = head.getNext();
			numNodes--;
			return first.getElement();
		}
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

	public ListNode<E> reverseLinkedList(){
		return reverseLinkedList(head, null);
	}

	public ListNode<E> reverseLinkedList(ListNode<E> head, ListNode<E> revHead){
		if(head == null || head.getNext() == null){
			this.head = head;
			return head;
		}else{
			ListNode<E> next = head.getNext();

			revHead = reverseLinkedList(next, null);

			next.setNext(head);
			head.setNext(null);
		
			return revHead;
		}

	}
}
