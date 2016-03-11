
/**
 *	Name		: Wong Kang Fei
 *	Matric No.	: A0138862W
 */

import java.util.*;

public class Classroom {
	private static CircularDoublyLinkedList<String> students = new CircularDoublyLinkedList<String>();
	public static void main(String[] args) {
		// define your main method here...

		Scanner sc = new Scanner(System.in);

		int queryCount = sc.nextInt();

		sc.nextLine();

		students.add("Sharon");

		for(int i =0; i<queryCount; i++){
			String[] queryParameters = sc.nextLine().trim().split(" ");

			switch(queryParameters[0]){
				case "enter":
					int indexOfStudent2 = students.indexOf(queryParameters[2]);
					students.circularAddAfter(indexOfStudent2, Integer.parseInt(queryParameters[3]), queryParameters[1]);
					break;
				case "leave":
					int indexOfStudent = students.indexOf(queryParameters[1]);
					students.remove(indexOfStudent);
					break;
				case "list":
					int indexOfSharon = students.indexOf("Sharon");
					students.circularDisplayFrom(indexOfSharon);
					break;
			}
		}
	}


}

class CircularDoublyLinkedList<E> extends DoublyLinkedList<E>{
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

		listNode.getPrev().setNext(listNode);
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

		while(curr != dummy){
			System.out.println(curr.getData());
			curr = curr.getNext();
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
