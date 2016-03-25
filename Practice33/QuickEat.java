// This program helps staff manage customers'
// orders and decide who should be given a ready dish.

import java.util.*;

// This class represents all orders of customers
class ListOrder {
    
    // Data member
    private int numDishes;
    // All dishes which the restaurant offers
    private String[] dishes;
    // Each dish has a queue of customers who ordered this dish
	// All such queues are put inside an ArrayList called dishQueues
    private ArrayList<QueueLL<Integer>> dishQueues;

    // Constructor
    public ListOrder(int numDishes, Scanner sc) {
		// eg
		// let dishQueues[1] = Fish n Chips Q
		// 	   dishQueues[2] = Chicken Chop Q
		// 	   dishqueues[3] = Grilled salmon Q
		//
		dishQueues = new ArrayList<QueueLL<Integer>>();

		dishQueues.add(null); // dummy
		
		dishes = new String[numDishes+1];

		for(int i = 1; i< numDishes+1; i++){
			dishes[i] = sc.nextLine();
			dishQueues.add(i, new QueueLL<Integer>());
		}
    }
    
    // Add new order to the list
    public void addNewOrder(int dishID, int tag) {
        dishQueues.get(dishID).offer(tag);
    }
    
    // Process food when it is ready
    // Return the customer who currently ordered for the dish
    // if there is no customer order for this dish return -1
    public int processReadyFood(int dishID) {
		if(dishQueues.get(dishID).isEmpty()){
			System.out.println("Throw away "+getDishName(dishID)+".");
			return -1;
		}else{
			System.out.println(getDishName(dishID) + " ready to be served to Tag "+ dishQueues.get(dishID).poll()+".");
			return dishID;
		}
    }

    // Get dish's name
    public String getDishName(int dishID) {
		return dishes[dishID];
    }

}

public class QuickEat {

    public static void main(String [] args) {
        
        Scanner sc = new Scanner(System.in);
        int numDishes = sc.nextInt();
        sc.nextLine();
        
        // Create the list order of food
        ListOrder listOrder = new ListOrder(numDishes, sc);
        
        int noOfCommands = sc.nextInt();
        sc.nextLine();
        
        // Process commands
		for(int i = 0; i<noOfCommands; i++){
			switch(sc.next()){
				case "Order":
					int tag = sc.nextInt();
					int numDishesOrdered = sc.nextInt();

					while(sc.hasNextInt()){
						listOrder.addNewOrder(sc.nextInt(), tag);				
					}
					break;
				case "Ready":
					listOrder.processReadyFood(sc.nextInt());
					break;
			}
		}


    }
}



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

