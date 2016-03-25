
/**
 * Name			: Wong Kang Fei
 * Matric. No	: A0138862W
 * PLab Acct.	: plab0960
 */

import java.util.*;

public class EelsAndEscalators {
	private TailedLinkedList<Player> players = new TailedLinkedList<Player>();
	private TailedLinkedList<Cell> board = new TailedLinkedList<Cell>();
	private Player currPlayer = null;

	public EelsAndEscalators() {
		// constructor

		// init start pt
		board.addLast(new Cell(0));
	}
	
	// more current player X spaces forward, take care of eels and ladders
	// pre: x>0
	public void roll(int x){
		ListNode<Cell> curr = currPlayer.getCurrentPos();
		while(x!= 0){
			curr = curr.getNext(); // exception here, need to check curr != null
			x--;
			if(curr == board.getTail()){
				break;
			}	
		}

		// check for eels or ladders
		if(curr.getElement().getTo() != null){
			curr = curr.getElement().getTo();
		}
		
		// set current pos
		currPlayer.setCurrentPos(curr);

		System.out.println(currPlayer.getName()+" "+currPlayer.getCurrentPos().getElement().getNum());

		// remove if reaches 100
		if(currPlayer.getCurrentPos().getElement().getNum() == 100){
			players.remove(currPlayer);
		}

		// switch next player
		if(players.size() != 0){
			/*
			if(currPlayer.getNext() != null){
				currPlayer = currPlayer.getNext();
			}else{
				currPlayer = players.getHead();
			}
			*/
		}else{
			System.out.println("no more players");
		}
	}

	// show the position of the playerName
	// pre: playerName exists
	public void position(String playerName){
		ListNode<Player> curr = players.getHead();
		while(curr !=null){
			if(curr.getElement().getName().equals(playerName)){
				break;
			}
			curr = curr.getNext();
		}

		System.out.println(curr.getElement().getCurrentPos().getElement().getNum());
	}

	// show num of players currently in the cell number
	// pre: cell Number > 0
	public void numPlayer(int cellNumber){
		int count = 0;

		ListNode<Player> curr = players.getHead();

		while(curr != null){
			if(curr.getElement().getCurrentPos().getElement().getNum() == cellNumber){
				count++;
			}
			curr = curr.getNext();
		}

		System.out.println(count);
	}

	public void run() {
		// implement your "main" method here

		// read in
		Scanner sc = new Scanner(System.in);
		int numPlayers = sc.nextInt();
		int numUpDowns = sc.nextInt();
		int numQueries = sc.nextInt();

		sc.nextLine(); // consume line feed

		// init players
		for(int i=0; i<numPlayers; i++){
			players.addLast(new Player(sc.nextLine(), board.getHead()));
		}	

		// init 100 cells
		for(int i=1; i<= 100; i++){
			board.addLast(new Cell(i));
		}

		// init eels and ladders
		for(int i=0; i<numUpDowns; i++){
			int startPos = sc.nextInt();
			int endPos = sc.nextInt();

			ListNode<Cell> from = board.getNode(startPos);
			ListNode<Cell> to = board.getNode(endPos);

			from.getElement().setTo(to);	
		}

		// assign current Player
		currPlayer = players.getFirst();

		sc.nextLine(); // consume line feed

		// queries
		for(int i=0; i<numQueries; i++){
			switch(sc.next()){
				case "ROLL":
					roll(sc.nextInt());
					sc.nextLine();
					break;
				case "POSITION":
					position(sc.next());
					sc.nextLine();
					break;
				case "NUMPLAYER":
					numPlayer(sc.nextInt());
					sc.nextLine();
					break;
			}
		}
	}

	public static void main(String[] args) {
		EelsAndEscalators newGame = new EelsAndEscalators();
		newGame.run();
	}
}

class Cell {
	// define appropriate attributes, methods, and constructor
	private int num;
	private ListNode<Cell> to;

	public Cell(int num, ListNode<Cell> to){
		this.num = num;
		this.to = to;
	}

	public Cell(int num){
		this(num, null);
	}

	public int getNum(){
		return num;
	}

	public ListNode<Cell> getTo(){
		return to;
	}

	public void setTo(ListNode<Cell> to){
		this.to = to;
	}
}

class Player {
	// define appropriate attributes, methods, and constructor
	private String name;
	private ListNode<Cell> currentPos;

	public Player(String name, ListNode<Cell> currentPos){
		this.name = name;
		this.currentPos = currentPos;
	}

	public String getName(){
		return name;
	}

	public ListNode<Cell> getCurrentPos(){
		return currentPos;
	}

	public void setCurrentPos(ListNode<Cell> currentPos){
		this.currentPos = currentPos;
	}


}

class TailedLinkedList<E> {

	// Data attributes
	private ListNode<E> head;
	private ListNode<E> tail;
	private int num_nodes;

	public TailedLinkedList() {
		this.head = null;
		this.tail = null;
		this.num_nodes = 0;
	}

	// Return true if list is empty; otherwise return false.
	public boolean isEmpty() {
		return (num_nodes == 0);
	}

	// Return number of nodes in list.
	public int size() {
		return num_nodes;
	}

	// Return value in the first node.
	public E getFirst() throws NoSuchElementException {
		if (head == null)
			throw new NoSuchElementException("can't get from an empty list");
		else
			return head.getElement();
	}

	// Return true if list contains item, otherwise return false.
	public boolean contains(E item) {
		for (ListNode<E> n = head; n != null; n = n.getNext())
			if (n.getElement().equals(item))
				return true;

		return false;
	}

	// Add item to front of list.
	public void addFirst(E item) {
		head = new ListNode<E>(item, head);
		num_nodes++;
		if (num_nodes == 1)
			tail = head;
	}

	// Return reference to first node.
	public ListNode<E> getHead() {
		return head;
	}

	// Return reference to last node of list.
	public ListNode<E> getTail() {
		return tail;
	}

	// Add item to end of list.
	public void addLast(E item) {
		if (head != null) {
			tail.setNext(new ListNode<E>(item));
			tail = tail.getNext();
		} else {
			tail = new ListNode<E>(item);
			head = tail;
		}
		num_nodes++;
	}

	// Remove node after node referenced by current
	public E removeAfter(ListNode<E> current) throws NoSuchElementException {
		E temp;
		if (current != null) {
			ListNode<E> nextPtr = current.getNext();
			if (nextPtr != null) {
				temp = nextPtr.getElement();
				current.setNext(nextPtr.getNext());
				num_nodes--;
				if (nextPtr.getNext() == null) // last node is removed
					tail = current;
				return temp;
			} else
				throw new NoSuchElementException("No next node to remove");
		} else { // if current is null, we want to remove head
			if (head != null) {
				temp = head.getElement();
				head = head.getNext();
				num_nodes--;
				if (head == null)
					tail = null;
				return temp;
			} else
				throw new NoSuchElementException("No next node to remove");
		}
	}

	// Remove first node of list.
	public E removeFirst() throws NoSuchElementException {
		return removeAfter(null);
	}

	// Remove item from list
	public E remove(E item) throws NoSuchElementException {
		ListNode<E> current = head;
		if (current == null) {
			throw new NoSuchElementException("No node to remove");
		}
		if (current.getElement().equals(item)) {
			return removeAfter(null);
		}
		while (current.getNext().getElement() != null) {
			if (current.getNext().getElement().equals(item)) {
				return removeAfter(current);
			}
			current = current.getNext();
		}
		throw new NoSuchElementException("No node to remove");
	}

	// get the index i node
	public ListNode<E> getNode(int i){
		ListNode<E> curr = head;

		while(i != 0){
			curr = curr.getNext();
			i--;
		}

		return curr;
	}
}

class ListNode<E> {
	protected E element;
	protected ListNode<E> next;

	/* constructors */
	public ListNode(E item) {
		this.element = item;
		this.next = null;
	}

	public ListNode(E item, ListNode<E> n) {
		element = item;
		next = n;
	}

	/* get the next ListNode */
	public ListNode<E> getNext() {
		return this.next;
	}

	/* get the element of the ListNode */
	public E getElement() {
		return this.element;
	}

	public void setNext(ListNode<E> item) {
		this.next = item;
	}

	public void setElement(E item) {
		this.element = item;
	}
}