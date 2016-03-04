import java.util.*;

public class MagicTrick{
	// character count for each card name
	private static int[] cardCharCount = {3,3,5,4,4,3,5,5,4,3,4,5,4};

	public static void main(String[] args){
		// to store the sorted result and display at the end
		ArrayList<String> resultantCardSequence = new ArrayList<String>();

		Scanner sc = new Scanner(System.in);

		while(true){

			int cardCount = sc.nextInt();

			if(cardCount == 0){
				// break loop if user enter 0
				break;
			}

			// initialize empty nodes depending on the cardCount
			CircularLinkedList<String> cll = new CircularLinkedList<String>(cardCount);

			// requested card sequence to solve
			ArrayList<String> requestedCardSequence = new ArrayList<String>();

			sc.nextLine(); // consume line feed

			for(int i = 0; i<cardCount; i++){
				requestedCardSequence.add(sc.next());
			}

			sc.nextLine(); // consume line feed

			// see skipAndModify()
			// iteratively skip and modify the circular list
			// only modify empty-node
			int index = 0;
			for(String theCard : requestedCardSequence){
				index = cll.skipAndModify(index, getCardCharCountOf(theCard), theCard);
			}
			
			// remember the sorted result
			resultantCardSequence.add(cll.toString());
		}

		// display each set of sorted cards with max of 13 each line
		// different decks are seperated by empty line feed
		for(int i=0; i<resultantCardSequence.size(); i++){
			String[] theCards = resultantCardSequence.get(i).split(" ");
			String toBePrinted = "";
			for(int j=0; j<theCards.length; j++){
				if(j%13 == 0){
					toBePrinted +="\n" + theCards[j]+" ";
				}else{
					toBePrinted +=theCards[j] + " ";
				}
			}

			System.out.println(toBePrinted.trim());
			System.out.println();
		}

	}

	private static int getCardCharCountOf(String s){
		switch(s){
			case "A":
				return cardCharCount[0];
			case "T":
				return cardCharCount[9];
			case "J":
				return cardCharCount[10];
			case "Q":
				return cardCharCount[11];
			case "K":
				return cardCharCount[12];
			default:
				return cardCharCount[Integer.parseInt(s)-1];
		}
	}
}

// Using dummy node to mitigate special cases where
// 1. removing first node
// 2. insertion at the end
// 3. updating circular (tail to head) references whenever performing removal and insertion at extreme nodes
//
// Dummy node will always present even the list is empty. It's not accessible to public.
class CircularLinkedList<E>{
	protected int size;
	protected ListNode<E> dummy;

	public CircularLinkedList(){
		this.size = 0;
		this.dummy = new ListNode<E>(null);
		this.dummy.setNext(dummy);
	}

	// initialize empty nodes, similar to ArrayList's capacity
	public CircularLinkedList(int initialCapacity){
		this();

		for(int i=0; i<initialCapacity; i++){
			addFirst(null);
		}
	}

	// int index: start index
	// int offset: offset count
	// E data: data to be modified at the end of the traversal
	// return: index where the traversal ends
	//
	// dummy node and nodes where content is NOT null does not count towards offset count,
	// it will advance next node without decreasing offset
	public int skipAndModify(int index, int offset, E data){
		if(index<0 || index>=size){
			throw new IndexOutOfBoundsException();
		}else{
			int resultIndex=0;

			// point the curr to the first node
			ListNode<E> curr = dummy.getNext();

			// traverse index
			while(index!=0){
				if(curr == dummy){
					// reaching the end of the list

					// cycle back to first element
					curr = curr.getNext();

					// reset resultIndex to zero
					resultIndex = 0;
				}else{
					curr = curr.getNext();
					index--;
					resultIndex++;
				}
			}

			// traverse offset (skips)
			while(offset != 0){
				if(curr == dummy){
					curr = curr.getNext();
					resultIndex = 0;
				}else if(curr.getData() != null){
					// skip this node if the content is not null
					// do not decrease offset
					curr = curr.getNext();
					resultIndex++;
				}else{
					curr = curr.getNext();
					resultIndex++;
					offset--;
				}
			}
			
			// special case when the pointer lands on dummy node or node with content
			while(curr==dummy || curr.getData() != null){
				if(curr == dummy){
					curr = curr.getNext();
					resultIndex = 0;
				}else if(curr.getData() != null){
					curr = curr.getNext();
					resultIndex++;
				}else{
					break;
				}
			}

			curr.setData(data);

			return resultIndex;
		}
	}

	public boolean isEmpty(){
		return dummy.getNext() == dummy;
	}

	public int size(){
		return this.size();
	}

	public E getFirst(){
		if(isEmpty()){
			throw new NoSuchElementException("getFirst(): List is empty.");
		}else{
			return dummy.getNext().getData();
		}
	}

	public boolean contains(E data){
		ListNode<E> curr = dummy.getNext();

		while(curr != dummy){
			if(curr.getData().equals(data)){
				return true;
			}else{
				curr = curr.getNext();
			}
		}

		return false;
	}

	public void addFirst(E data){
		ListNode<E> dataNode = new ListNode<E>(data);
		dataNode.setNext(dummy.getNext());
		dummy.setNext(dataNode);
		size++;
	}

	public E removeFirst(){
		if(isEmpty()){
			throw new NoSuchElementException("removeFirst(): List is empty.");
		}else{
			ListNode<E> dataNode = dummy.getNext().getNext();
			dummy.setNext(dataNode);
			size--;
			return dataNode.getData();
		}
	}

	public void print(){
		String result = "[";
		ListNode<E> curr = dummy.getNext();

		while(curr != dummy){
			result += curr.getData() + " ";
			curr = curr.getNext();
		};

		result = result.trim() + "]";

		System.out.println(result);
	}

	@Override
	public String toString(){
		String result = "";
		ListNode<E> curr = dummy.getNext();
		while(curr != dummy){
			result += curr.getData() +" ";
			curr = curr.getNext();
		}

		return result.trim();
	}

}

class ListNode<E>{
	private E data;
	private ListNode<E> next;

	public ListNode(E data){
		this(data, null);
	}

	public ListNode(E data, ListNode<E> next){
		this.data = data;
		this.next = next;
	}

	public E getData(){
		return this.data;
	}

	public ListNode<E> getNext(){
		return this.next;
	}

	public void setData(E data){
		this.data = data;
	}

	public void setNext(ListNode<E> next){
		this.next = next;
	}


}
