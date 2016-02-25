public class LinkedList<E>{
	private ListNode<E> head;
	private int size;

	public void addFirst(E data){
		head = new ListNode<E>(data, head);
		size++;
	}

	public void flip(){
		if( size > 1 ){ // flip only make sense if the size of elements is > 1
			ListNode<E> last = head; // keep the reference of original head; this will become the last node after flipped
			ListNode<E> prev = head.getNext(); // advance prev pointer to the second element
			ListNode<E> curr = head.getNext().getNext(); // advance curr pointer to third element

			// Note:	We consider first element "flipped"
			// 			only need to set it to point to null

			while( prev != null){

				prev.setNext(head); // set next to point to the current head
				head = prev;	// update the head of flipped part

				prev = curr;	// move prev to curr (advance to where curr pointing to)
								// we cannot use prev = prev.getNext() because previously we set the reference to point to head
								// reference to the original next node is lost
								// so we have to make use of curr reference
				
				if(curr != null){	// this is to deal with the last element where the curr already at null, but we still need to advance prev pointer one last time.
					curr = curr.getNext();
				}
			}
			
			last.setNext(null); // finally, set the last node in the flipped part to null
		}else{
			return; // do nothing b*tches!
		}
	}

	@Override
	public String toString(){
		String result = "[";

		ListNode<E> curr = head;
		while(curr != null){
			result += curr.getData() + " ";
			curr = curr.getNext();
		}

		result = result.trim() + "]";

		return result;
	}

	public static void main(String[] args){
		LinkedList<String> alpha = new LinkedList<String>();
		
		// test for 1 element
		// flip do nothing
		/*
		alpha.addFirst("Z");
		*/

		// test for 2 element
		/*	
		alpha.addFirst("Y");
		alpha.addFirst("X");
		*/

		// test for 5 element ( size >1 )
		
		alpha.addFirst("E");
		alpha.addFirst("D");
		alpha.addFirst("C");
		alpha.addFirst("B");
		alpha.addFirst("A");
		
		
		// comment out all test case for testing size = 0

		System.out.println("original: " + alpha);

		alpha.flip();

		System.out.println("flipped: " +alpha);
	}
}

class ListNode<E>{
	E data;
	ListNode<E> next;

	public ListNode(E data){
		this(data, null);
	}

	public ListNode(E data, ListNode<E> next){
		this.data = data;
		this.next = next;
	}

	public E getData(){
		return data;
	}

	public ListNode<E> getNext(){
		return next;
	}

	public void setData(E data){
		this.data = data;
	}

	public void setNext(ListNode<E> next){
		this.next = next;
	}
}
