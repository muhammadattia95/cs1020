import java.util.*;
// http://stackoverflow.com/questions/22029047/dummy-head-node-linked-list 
public class DoublyLinkedList<E> implements IList<E>{
	private ListNode<E> dummy;
	private int size;

	public DoublyLinkedList(){
		this.dummy = new ListNode<E>(null);
		this.dummy.setNext(dummy);
		this.dummy.setPrev(dummy);

		this.size = 0;
	}

	public boolean isEmpty(){
		return dummy.getNext() == dummy && dummy.getPrev() == dummy;
	}

	public int size(){
		return size;
	}

	public void add(int index, E data) {
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException();
		}else{

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
	private ListNode<E> next; // if next is null, it's the end of the list

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

interface IList<E>{
	public boolean isEmpty();
	public int size();
	public void add(E data);
	public void add(int index, E data);
	public void remove(int index);
	public E get(int index);
}
