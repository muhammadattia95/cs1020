
/**
 *	Name		: Wong Kang Fei
 *	Matric No.	: A0138862W
 */

import java.util.*;

public class MagicTrick {
	private static int[] cardCharCount = {3,3,5,4,4,3,5,5,4,3,4,5,4};
	private static CircularDoublyLinkedList<String> seq;
	private static ArrayList<String> results = new ArrayList<String>();
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while(true){

			int cardCount = sc.nextInt();

			if(cardCount == 0){
				break;
			}

			seq = new CircularDoublyLinkedList<String>(cardCount);
		
			sc.nextLine(); // consume line feed

			ArrayList<String> theCards = new ArrayList<String>(cardCount);

			for(int i = 0; i<cardCount; i++){
				theCards.add(sc.next());
			}

			sc.nextLine(); // consume line feed

			int index = 0;
			for(String theCard : theCards){
				index = seq.circularOffsetOnlyNulls(index, getCardCharCountOf(theCard));
			
				seq.modify(index, theCard);
			}
			
			results.add(seq.toString());
			//System.out.println(seq.toString());//seq.circularDisplayFrom(0);
		}

		for(int i=0; i<results.size(); i++){
			String[] theCards = results.get(i).split(" ");
			String toBePrinted = "";
			for(int j=0; j<theCards.length; j++){
				if(j%13 == 0){
					toBePrinted +="\n" +theCards[j]+" ";
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

class CircularDoublyLinkedList<E> extends DoublyLinkedList<E> implements Iterator<E>{

	public CircularDoublyLinkedList(int capacity){
		super(capacity);
	}

	public void circularAddAfter(int index, int offset, E data){
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException();
		}else{
			ListNode<E> listNode = new ListNode<E>(data);

			ListNode<E> curr = dummy.getNext();
			while(index !=0){
				curr = curr.getNext();
				index--;
			}

			while(offset !=0){
				curr = curr.getNext();
				if(curr != dummy){
					offset--;
				}else{
					continue;
				}
			}

			curr.getNext().setPrev(listNode);
			listNode.setNext(curr.getNext());

			curr.setNext(listNode);
			listNode.setPrev(curr);
			size++;
		}
	}

	public void swap(int i, int j){
		int adjacencyCount = Math.abs(i - j);

		int temp = Math.max(i, j);

		i = Math.min(i, j);
		j = temp;

		/*
		 * i - j = 0,  no swap
		 * i - j = 1, swap adjacent
		 * i - j = 2 , swap with 3 neighours
		 * i - j = 3, swap with 4 neighbours
		 */			
		ListNode<E> listNode1 = dummy.getNext();
		ListNode<E> listNode2 = dummy.getNext();

		while(i != 0){
			listNode1 = listNode1.getNext();
			i--;
		}

		while(j != 0){
			listNode2 = listNode2.getNext();
			j--;
		}

		if( adjacencyCount == 0){
			return;
		}else if(adjacencyCount == 1){
			ListNode<E> listNode1Prev = listNode1.getPrev();
			ListNode<E> listNode2Next = listNode2.getNext();

			listNode1Prev.setNext(listNode2);
			listNode1.setNext(listNode2Next);
			listNode2.setNext(listNode1);

			listNode2Next.setPrev(listNode1);
			listNode2.setPrev(listNode1Prev);
			listNode1.setPrev(listNode2);
		}else if(adjacencyCount == 2){
			ListNode<E> listNode1Prev = listNode1.getPrev();
			ListNode<E> listNodeShare = listNode1.getNext(); // or listNode2.getPrev();
			ListNode<E> listNode2Next = listNode2.getNext();

			listNode1Prev.setNext(listNode2);
			listNode1.setNext(listNode2Next);
			listNodeShare.setNext(listNode1);
			listNode2.setNext(listNodeShare);

			listNode2Next.setPrev(listNode1);
			listNode2.setPrev(listNode1Prev);
			listNodeShare.setPrev(listNode2);
			listNode1.setPrev(listNodeShare);
		}else{
			// i - j >= 2
			// store the original neighbour reference of two target swapee
			ListNode<E> listNode1Prev = listNode1.getPrev();
			ListNode<E> listNode1Next = listNode1.getNext();
			ListNode<E> listNode2Prev = listNode2.getPrev();
			ListNode<E> listNode2Next = listNode2.getNext();

			//update the neighbour reference, result in swaps
			listNode1Prev.setNext(listNode2);
			listNode1.setNext(listNode2Next);
			listNode2Prev.setNext(listNode1);
			listNode2.setNext(listNode1Next);

			listNode2Next.setPrev(listNode1);
			listNode2.setPrev(listNode1Prev);
			listNode1Next.setPrev(listNode2);
			listNode1.setPrev(listNode2Prev);
		}
	}

	public int circularOffsetFrom(int index, int offset){
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException();
		}else{
			int resultIndex = 0;
			ListNode<E> curr = dummy.getNext();
			while(index !=0){
				if(curr == dummy){
					curr = curr.getNext();
					resultIndex = 0;
				}else{
					curr = curr.getNext();
					index--;
					resultIndex++;
				}
			}

			while(offset != 0){
				if(curr == dummy){
					curr = curr.getNext();
					resultIndex = 0;
				}else{
					curr = curr.getNext();
					offset--;
					resultIndex++;
				}
			}

			if(curr == dummy){
				curr = curr.getNext();
				resultIndex = 0;
			}


			return resultIndex;
		}
	}

	public int circularOffsetOnlyNulls(int index, int offset){
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException();
		}else{
			int resultIndex = 0;
			ListNode<E> curr = dummy.getNext();
			while(index !=0){
				if(curr == dummy){
					curr = curr.getNext();
					resultIndex = 0;
				}else{
					curr = curr.getNext();
					index--;
					resultIndex++;
				}
			}

			while(offset != 0){
				if(curr == dummy){
					curr = curr.getNext();
					resultIndex = 0;
				}else if(curr.getData() != null){
					curr = curr.getNext();
					resultIndex++;
				}else{
					curr = curr.getNext();
					resultIndex++;	
					offset--;
				}
			}

			while(curr == dummy || curr.getData() != null){
				if(curr == dummy){
					curr = curr.getNext();
					resultIndex = 0;
				}else if(curr.getData() != null){
					curr = curr.getNext();
					resultIndex++;
				}else{

				}
			}

			//System.out.print("Replacing {"+resultIndex+"}@ ");
			//this.circularDisplayFrom(0);

			return resultIndex;
		}
	}

	private int nextNullIndex(int from){
		return 0;
	}

	public int indexOf(E data){
		int i = 0;
		ListNode<E> curr = dummy.getNext();
		while(curr != dummy){
			if(data.equals(curr.getData())){
				return i;
			}else{
				curr = curr.getNext();
				i++;
				continue;
			}
		}
		return -1;
	}

	public void circularDisplayFrom(int index){
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException();
		}else{
			String result = "";

			// traverse to index i
			ListNode<E> curr = dummy.getNext();
			while(index !=0){
				curr = curr.getNext();
				index--;
			}

			// target node, the start & end node
			ListNode<E> targetNode = curr;

			result += curr.getData() +" ";

			curr = curr.getNext();

			// display from target node circularly
			// until it hits target node again
			while(curr != targetNode){
				if(curr == dummy){
					curr = curr.getNext();
				}else{
					result += curr.getData() + " ";
					curr = curr.getNext();
				}
			}

			System.out.println(result.trim());

		}

	}

	@Override
	public boolean hasNext(){
		return false;
	}

	public E next(){
		return null;
	}

	public void remove(){
		//stub
	}
}

// http://stackoverflow.com/questions/22029047/dummy-head-node-linked-list 
class DoublyLinkedList<E>{
	protected ListNode<E> dummy;
	protected int size;

	public DoublyLinkedList(){
		this.dummy = new ListNode<E>(null);
		this.dummy.setNext(dummy);
		this.dummy.setPrev(dummy);

		this.size = 0;
	}

	public DoublyLinkedList(int capacity){
		this.dummy = new ListNode<E>(null);
		this.dummy.setNext(dummy);
		this.dummy.setPrev(dummy);

		for(int i = 0; i<capacity; i++){
			this.add(null);
		}
	}

	public boolean isEmpty(){
		return dummy.getNext() == dummy && dummy.getPrev() == dummy;
	}

	public int getSize(){
		return size;
	}

	public void add(int index, E data) {
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException();
		}else if(index == size){
			add(data);
		}else{
			ListNode<E> listNode = new ListNode<E>(data);
			ListNode<E> curr = dummy.getNext();
			while(index != 0){
				curr = curr.getNext();
				index--;
			}

			curr.getPrev().setNext(listNode);
			listNode.setPrev(curr.getPrev());

			curr.setPrev(listNode);
			listNode.setNext(curr);

			size++;
		}
	}

	public void add(E data){
		ListNode<E> listNode = new ListNode<E>(data);

		listNode.setNext(dummy);
		listNode.setPrev(dummy.getPrev());


		dummy.getPrev().setNext(listNode);
		dummy.setPrev(listNode);

		size++;     
	}

	public void remove(int index){
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException();
		}else{
			ListNode<E> curr = dummy.getNext(); 
			while(index != 0){
				curr = curr.getNext();
				index--;
			}

			curr.getPrev().setNext(curr.getNext());
			curr.getNext().setPrev(curr.getPrev());

			size--;
		}
	}

	public E get(int index){
		if(index < 0 || index >= size){
			//display();
			//System.out.println(index+":"+size);
			throw new IndexOutOfBoundsException();
		}else{
			ListNode<E> curr = dummy.getNext();
			while(index !=0){
				curr = curr.getNext();
				index--;
			}

			return curr.getData();
		}
	}

	public void modify(int index, E data){
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException();
		}else{
			ListNode<E> curr = dummy.getNext();
			while(index !=0){
				curr = curr.getNext();
				index--;
			}

			curr.setData(data);
		}
	}

	public void display(){
		System.out.println("====display===");
		ListNode<E> curr = dummy.getNext();
		int i =0;

		while(curr != dummy){
			System.out.println(i +": "+curr.getData());
			curr = curr.getNext();
			i++;
		}
		System.out.println("====display===");
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

	/*
	   public static void main(String[] args){
	   DoublyLinkedList<String> dll = new DoublyLinkedList<String>();

	   System.out.println(dll.isEmpty());

	   dll.add("C");
	   dll.display();

	   dll.add("Z");
	   dll.display();

	   dll.add("A");
	   dll.display();

	   System.out.println(dll.isEmpty());

	   dll.remove(2);
	   dll.display();

	   dll.remove(1);
	   dll.display();

	   dll.remove(0);
	   dll.display();


	   System.out.println(dll.isEmpty());
	   }
	   */
}

class ListNode<E>{
	private E data;
	private ListNode<E> prev;
	private ListNode<E> next;

	public ListNode(E data){
		this.data = data;
		this.prev = null;
		this.next = null;
	}

	public ListNode(E data, ListNode<E> prev, ListNode<E> next){
		this.data = data;
		this.prev = prev;
		this.next = next;
	}

	public E getData(){
		return data;
	}

	public void setData(E data){
		this.data = data;
	}

	public ListNode<E> getPrev(){
		return prev;
	}

	public void setPrev(ListNode<E> listNode){
		this.prev = listNode;
	}

	public ListNode<E> getNext(){
		return next;
	}

	public void setNext(ListNode<E> listNode){
		this.next = listNode;
	}

}
