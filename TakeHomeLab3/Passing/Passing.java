
/**
 *	Name		: Wong Kang Fei
 *	Matric No.	: A0138862W
 */

import java.util.*;

public class Passing {
	private CircularDoublyLinkedList<Player> players;
	private int eliminationPoint;
	private int ballHolderIndex;
	private Player reportingPlayer;

	public Passing(){
		this.players = new CircularDoublyLinkedList<Player>();
		this.eliminationPoint = 0;
		this.ballHolderIndex = 0;
		this.reportingPlayer = null;
	}

	public void setEliminationPoint(int point){
		this.eliminationPoint = point;
	}

	public void addPlayer(String name){
		Player player = new Player(name);
		this.players.add(player);
	}

	public void executeTurn(int passingCount){
		int passedToIndex = players.circularOffsetFrom(ballHolderIndex, passingCount);	

		//System.out.println("size: "+players.getSize()+", ballHolderIndex: " +ballHolderIndex+", passingCount: "+passingCount+", passedToIndex:"+passedToIndex);

		Player passedToPlayer = players.get(passedToIndex);
		passedToPlayer.addPoints(1);

		if(passedToPlayer.getPoints() >= eliminationPoint){
			reportingPlayer = players.get(passedToIndex);
			players.remove(passedToIndex);
			//System.out.println("removed: "+passedToIndex);
			if(passedToIndex == players.getSize()){

				ballHolderIndex = 0;
			}else{
				ballHolderIndex = passedToIndex;
			}
		}else{
			players.swap(ballHolderIndex, passedToIndex);
			reportingPlayer = players.get(ballHolderIndex);
		}
	}

	public Player getReportingPlayer(){
		//System.out.println("getBallHolder(): "+ ballHolderIndex);
		return reportingPlayer;
	}

	public int getBallHolderIndex(){
		return ballHolderIndex;
	}

	public static void main(String[] args) {

		Passing passing = new Passing();

		Scanner sc = new Scanner(System.in);
		int playerCount = sc.nextInt();
		int turnCount = sc.nextInt();
		int eliminationPoint = sc.nextInt();

		passing.setEliminationPoint(eliminationPoint);

		sc.nextLine(); // consume line feed

		for(int i =0; i<playerCount; i++){
			passing.addPlayer(sc.nextLine());
		}

		for(int i=0; i<turnCount; i++){
			passing.executeTurn(sc.nextInt());
			//System.out.println(passing.getBallHolderIndex());
			//System.out.print("["+i+"]");
			System.out.println(passing.getReportingPlayer().getName());
		}

		/*	
			CircularDoublyLinkedList<String> cdll = new CircularDoublyLinkedList<String>();
			cdll.add("A");
			cdll.add("B");
			cdll.add("C");
			cdll.add("D");
			cdll.add("E");
			cdll.add("F");
			cdll.add("G");

			cdll.swap(1,3);

			cdll.remove(0);
			cdll.remove(5);

			System.out.println(cdll.circularOffsetFrom(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
			cdll.circularDisplayFrom(0);

			System.out.println(cdll.circularOffsetFrom(Integer.parseInt(args[2]), Integer.parseInt(args[3])));
			cdll.circularDisplayFrom(0);
			*/

		//cdll.circularDisplayFrom(0);

	}
}

class Player{
	private String name;
	private int points;

	public Player(String name){
		this.name = name;
		this.points = 0;
	}

	public String getName(){
		return name;
	}

	public int getPoints(){
		return points;
	}

	public void addPoints(int i){
		points += i;
	}

	@Override
	public String toString(){
		return "["+name+", "+points+"]";
	}
}


class CircularDoublyLinkedList<E> extends DoublyLinkedList<E> implements Iterator<E>{
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
